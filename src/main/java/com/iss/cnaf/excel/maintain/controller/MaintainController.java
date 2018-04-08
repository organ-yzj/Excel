package com.iss.cnaf.excel.maintain.controller;

import com.alibaba.fastjson.JSONObject;
import com.iss.cnaf.excel.maintain.service.MaintainService;
import com.iss.cnaf.manager.sys.model.CnafGrid;
import com.iss.cnaf.manager.sys.model.QueryParam;
import com.iss.common.utils.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/7.
 */

@Controller
@RequestMapping("/maintain")
public class MaintainController {

    @Autowired
    private MaintainService maintainService;

    @RequestMapping("maintainIndex")
    public String airportIndex(){
        return "cnaf/maintain/maintainManager";
    }

    @RequestMapping("queryMaintain")
    @ResponseBody
    public CnafGrid queryMaintain(QueryParam param, CnafGrid grid) {

        maintainService.queryMaintain(param, grid);

        return grid;
    }

    @RequestMapping("excelImport")
    @ResponseBody
    public void  excelImport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        Workbook wb = FileUtils.getWorkbookFromRequest(request,response);
        maintainService.batchExportJiJin(wb);
        out.flush();
        out.close();
    }


}
