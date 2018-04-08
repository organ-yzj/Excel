package com.iss.cnaf.excel.repair.controller;

import com.alibaba.fastjson.JSONObject;
import com.iss.cnaf.excel.repair.service.RepairService;
import com.iss.cnaf.excel.repair.vo.Repair;
import com.iss.cnaf.manager.sys.model.CnafGrid;
import com.iss.cnaf.manager.sys.model.QueryParam;
import com.iss.cnaf.manager.sys.model.SystemicInfo;
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
import java.util.*;

/**
 * Created by Administrator on 2018/4/5.
 */

@Controller
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    private RepairService repairService;

    @RequestMapping("repairIndex")
    public String airportIndex(){
        return "cnaf/repair/repairManager";
    }

    @RequestMapping("queryRepair")
    @ResponseBody
    public CnafGrid queryRepair(QueryParam param, CnafGrid grid) {

        repairService.queryRepair(param, grid);

        return grid;
    }


    @RequestMapping("excelImport")
    @ResponseBody
    public void  excelImport(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter out=response.getWriter();
        Workbook wb = FileUtils.getWorkbookFromRequest(request,response);
        repairService.batchExportJiJin(wb);
        out.flush();
        out.close();
    }


    @RequestMapping("addRepair")
    @ResponseBody
    public SystemicInfo addRepair(SystemicInfo system ,Repair repair) throws IOException{
        int result = repairService.addRepair(repair);
        if(result!=0){
            system.setSuccess(true, "添加成功");
        }else{
            system.setSuccess(true, "添加失败");
        }
    }


}
