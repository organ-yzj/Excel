package com.iss.cnaf.excel.maintain.service;

import com.iss.cnaf.manager.sys.model.CnafGrid;
import com.iss.cnaf.manager.sys.model.QueryParam;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.Map;

/**
 * Created by Administrator on 2018/4/7.
 */
public interface MaintainService {
    CnafGrid queryMaintain(QueryParam param, CnafGrid grid);

    Map<String,Object> batchExportJiJin(Workbook wb);
}
