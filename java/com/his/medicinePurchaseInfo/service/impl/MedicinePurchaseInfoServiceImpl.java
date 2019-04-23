package com.qhit.medicinePurchaseInfo.service.impl;

import com.qhit.common.commonUtils;
import com.qhit.medicinePurchaseInfo.service.IMedicinePurchaseInfoService;
import java.util.List;
import com.qhit.medicinePurchaseInfo.dao.IMedicinePurchaseInfoDao;
import com.qhit.medicinePurchaseInfo.dao.impl.MedicinePurchaseInfoDaoImpl;
import com.qhit.medicinePurchaseInfo.pojo.MedicinePurchaseInfo;
import com.qhit.medicineReqPlan.pojo.MedicineReqPlan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
* Created by GeneratorCode on 2018/12/04
*/

public class MedicinePurchaseInfoServiceImpl  implements IMedicinePurchaseInfoService {
    IMedicinePurchaseInfoDao dao=new MedicinePurchaseInfoDaoImpl();

    @Override 
    public boolean insert(Object object) { 
        return dao.insert(object); 
    } 


    @Override 
    public boolean update(Object object) { 
        return dao.update(object); 
    } 


    @Override 
    public boolean updateSelective(Object object) { 
        return dao.updateSelective(object); 
    } 


    @Override 
    public boolean delete(Object id) { 
        MedicinePurchaseInfo medicinePurchaseInfo = findById(id); 
        return dao.delete(medicinePurchaseInfo); 
    } 


    @Override 
    public List findAll() {
        String sql="SELECT * from medicine_purchase_info mpi " +
                "JOIN medicine_code mc ON mpi.medicine_codeid=mc.code_id;";
        List list = dao.freeFind(sql);
        return list;
    } 


    @Override 
    public MedicinePurchaseInfo findById(Object id) { 
        List<MedicinePurchaseInfo> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public boolean freeUpdate(String sql) {
        return dao.freeUpdate(sql);
    }


    @Override 
    public List<MedicinePurchaseInfo> search(MedicinePurchaseInfo medicinePurchaseInfo) {
            String sql = "SELECT * from medicine_purchase_info mpi " +
                    "JOIN medicine_code mc ON mpi.medicine_codeid=mc.code_id where 1=1 ";
            if (medicinePurchaseInfo.getMedicineCodeid()!=null && !"".equals(medicinePurchaseInfo.getMedicineCodeid())){        
                sql+=" and MEDICINE_CODEID like '%"+medicinePurchaseInfo.getMedicineCodeid()+"%' ";        
            } 
            if (medicinePurchaseInfo.getManCode()!=null && !"".equals(medicinePurchaseInfo.getManCode())){        
                sql+=" and MAN_CODE like '%"+medicinePurchaseInfo.getManCode()+"%' ";        
            } 
            if (medicinePurchaseInfo.getPchAmt()!=null && !"".equals(medicinePurchaseInfo.getPchAmt())){        
                sql+=" and PCH_AMT like '%"+medicinePurchaseInfo.getPchAmt()+"%' ";        
            } 
            if (medicinePurchaseInfo.getPchPrice()!=null && !"".equals(medicinePurchaseInfo.getPchPrice())){        
                sql+=" and PCH_PRICE like '%"+medicinePurchaseInfo.getPchPrice()+"%' ";        
            } 
            if (medicinePurchaseInfo.getPchTotal()!=null && !"".equals(medicinePurchaseInfo.getPchTotal())){        
                sql+=" and PCH_TOTAL like '%"+medicinePurchaseInfo.getPchTotal()+"%' ";        
            } 
            if (medicinePurchaseInfo.getStatus()!=null && !"".equals(medicinePurchaseInfo.getStatus())){        
                sql+=" and STATUS like '%"+medicinePurchaseInfo.getStatus()+"%' ";        
            } 
            if (medicinePurchaseInfo.getPchUserid()!=null && !"".equals(medicinePurchaseInfo.getPchUserid())){        
                sql+=" and PCH_USERID like '%"+medicinePurchaseInfo.getPchUserid()+"%' ";        
            } 
            if (medicinePurchaseInfo.getPchDate()!=null && !"".equals(medicinePurchaseInfo.getPchDate())){        
                sql+=" and PCH_DATE like '%"+medicinePurchaseInfo.getPchDate()+"%' ";        
            } 
            if (medicinePurchaseInfo.getApprvUserid()!=null && !"".equals(medicinePurchaseInfo.getApprvUserid())){        
                sql+=" and APPRV_USERID like '%"+medicinePurchaseInfo.getApprvUserid()+"%' ";        
            } 
            if (medicinePurchaseInfo.getApprvDate()!=null && !"".equals(medicinePurchaseInfo.getApprvDate())){        
                sql+=" and APPRV_DATE like '%"+medicinePurchaseInfo.getApprvDate()+"%' ";        
            } 
            List<MedicinePurchaseInfo> list = dao.freeFind(sql);        
            return list;        
    }

    @Override
    public void collect(HttpSession session) {
//        更新需求计划表  状态改为3
        String sql1="UPDATE medicine_req_plan SET STATUS=3 WHERE STATUS = 2";
        String sql2="SELECT *,CAST(SUM(reqamt) AS CHAR) AS sumamt from medicine_req_plan \n" +
                "WHERE STATUS = 2 GROUP BY medicine_codeid";
//        往采购信息表中插入数据 数据来源是需求计划表
        List<MedicineReqPlan> list = dao.freeFind(sql2);
        if (list!=null&&list.size()>0){
            dao.freeUpdate(sql1);
            MedicinePurchaseInfo info = new MedicinePurchaseInfo();
            for(MedicineReqPlan reqPlan:list){
                info.setMedicineCodeid(reqPlan.getMedicineCodeid());
                info.setPchAmt(Integer.parseInt(reqPlan.getSumamt()));
                info.setStatus(1);
                info.setPchDate(commonUtils.dateStr());
                info.setPchUserid(commonUtils.getUserId(session));
                info.setApprvUserid(reqPlan.getApprvUserid());
                info.setApprvDate(reqPlan.getApprvDate());
                dao.insert(info);
            }
        }

    }

    @Override
    public List<MedicinePurchaseInfo> getAllId(Integer userId) {
        String sql="SELECT * from medicine_purchase_info mpi " +
                "JOIN medicine_code mc ON mpi.medicine_codeid=mc.code_id where mpi.pch_userid="+userId+";";
        List list = dao.freeFind(sql);
        return list;
    }

    @Override
    public List<MedicinePurchaseInfo> findByStatus() {
        String sql="SELECT * from medicine_purchase_info mpi " +
                "JOIN medicine_code mc ON mpi.medicine_codeid=mc.code_id WHERE STATUS=2";
        List<MedicinePurchaseInfo> list = dao.freeFind(sql);
        return list;
    }

}