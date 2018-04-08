package com.iss.cnaf.excel.repair.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.iss.cnaf.excel.repair.dao.RepairMapper;
import com.iss.cnaf.excel.repair.service.RepairService;
import com.iss.cnaf.excel.repair.vo.Repair;
import com.iss.cnaf.manager.sys.model.CnafGrid;
import com.iss.cnaf.manager.sys.model.QueryParam;
import com.iss.common.utils.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/5.
 */

@Service
public class RepairServiceImpl implements RepairService{


    @Autowired
    private RepairMapper repairMapper;

    @Override
    public CnafGrid queryRepair(QueryParam param, CnafGrid grid) {
        PageHelper.startPage(param.getPage(), param.getRows());
        Page<Repair> page = repairMapper.queryRepair();
        grid.setGrid(page.getTotal(), page.getResult());
        return grid;
    }

    @Override
    public int insertList(List<Repair> repairs) {
        return repairMapper.insertList(repairs);
    }

    @Override
    public Map<String, Object> batchExportJiJin(Workbook wb) {
        List<Repair> repairs = new ArrayList<>();
        Sheet sheet = wb.getSheetAt(0);
        boolean fl = false;
        // 获取总行数
        int rows = sheet.getPhysicalNumberOfRows();
        if (rows > 2) {
            for (int start = 2; start < rows; start++) {
                // 从第三行开始逐行获取
                Row row = sheet.getRow(start);
                Repair repair = new Repair();
                for (int i = 0; i < 10; i++) {
                    Cell cell = row.getCell(i);
                    String cellValue = FileUtils.getCellValue(cell);

                    if (i == 0) {
                        if(cellValue==""){
                            fl = true;
                            break;
                        }else{
                            repair.setCarId(cellValue);
                        }
                    }
                    if (i == 1) {
                        repair.setRepairDate(cellValue);
                    }
                    if (i == 2) {
                        repair.setReason(cellValue);
                    }
                    if (i == 3) {
                        repair.setMoney(cellValue);
                    }
                    if (i == 4) {
                        repair.setPosition(cellValue);
                    }
                    if (i == 5) {
                        repair.setManufactor(cellValue);
                    }
                    if (i == 6) {
                        repair.setPhone(cellValue);
                    }
                    if (i == 7) {
                        repair.setInvoice(cellValue);
                    }
                    if (i == 8) {
                        repair.setBuyDate(cellValue);
                    }
                    if (i == 9) {
                        repair.setDriver(cellValue);
                    }
                }
                if(repair.getCarId()!=""&&repair.getCarId()!=null){
                    repairs.add(repair);
                }
                if(fl){
                    break;
                }
            }
        }
        repairMapper.insertList(repairs);
        return null;
    }

    @Override
    public int addRepair(Repair repair) {
        return repairMapper.addRepair(repair);
    }
}
