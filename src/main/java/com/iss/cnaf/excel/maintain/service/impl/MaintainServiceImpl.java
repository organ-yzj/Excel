package com.iss.cnaf.excel.maintain.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.iss.cnaf.excel.maintain.dao.MaintainMapper;
import com.iss.cnaf.excel.maintain.service.MaintainService;
import com.iss.cnaf.excel.maintain.vo.Maintain;
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
 * Created by Administrator on 2018/4/7.
 */
@Service
public class MaintainServiceImpl implements MaintainService{

    @Autowired
    private MaintainMapper maintainMapper;

    @Override
    public CnafGrid queryMaintain(QueryParam param, CnafGrid grid) {
        PageHelper.startPage(param.getPage(), param.getRows());
        Page<Maintain> page = maintainMapper.queryMaintain();
        grid.setGrid(page.getTotal(), page.getResult());
        return grid;
    }

    @Override
    public Map<String, Object> batchExportJiJin(Workbook wb) {
        List<Maintain> maintains = new ArrayList<>();
        Sheet sheet = wb.getSheetAt(0);
        boolean fl = false;
        // 获取总行数
        int rows = sheet.getPhysicalNumberOfRows();
        if (rows > 2) {
            for (int start = 2; start < rows; start++) {
                // 从第三行开始逐行获取
                Row row = sheet.getRow(start);
                Maintain maintain = new Maintain();
                for (int i = 0; i < 7; i++) {
                    Cell cell = row.getCell(i);
                    String cellValue = FileUtils.getCellValue(cell);

                    if (i == 0) {
                        if(cellValue==""){
                            fl = true;
                            break;
                        }else{
                            maintain.setCarId(cellValue);
                        }
                    }
                    if (i == 1) {
                        maintain.setMaintainDate(cellValue);
                    }
                    if (i == 2) {
                        maintain.setReason(cellValue);
                    }
                    if (i == 3) {
                        maintain.setMaterial(cellValue);
                    }
                    if (i == 4) {
                        maintain.setContents(cellValue);
                    }
                    if (i == 5) {
                        maintain.setWorker(cellValue);
                    }
                    if (i == 6) {
                        maintain.setRemark(cellValue);
                    }
                }
                if(maintain.getCarId()!=""&&maintain.getCarId()!=null){
                    maintains.add(maintain);
                }
                if(fl){
                    break;
                }
            }
        }
        maintainMapper.insertList(maintains);
        return null;
    }
}
