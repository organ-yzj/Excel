package com.iss.cnaf.excel.repair.service;

import com.iss.cnaf.excel.repair.vo.Repair;
import com.iss.cnaf.manager.sys.model.CnafGrid;
import com.iss.cnaf.manager.sys.model.QueryParam;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/5.
 */
public interface RepairService {
    CnafGrid queryRepair(QueryParam param, CnafGrid grid);

    int insertList(List<Repair> repairs);

    Map<String,Object> batchExportJiJin(Workbook wb);

    int addRepair(Repair repair);
}
