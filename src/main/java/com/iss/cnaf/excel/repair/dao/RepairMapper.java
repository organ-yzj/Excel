package com.iss.cnaf.excel.repair.dao;

import com.github.pagehelper.Page;
import com.iss.cnaf.excel.repair.vo.Repair;

import java.util.List;

/**
 * Created by Administrator on 2018/4/5.
 */
public interface RepairMapper {
    Page<Repair> queryRepair();

    int insertList(List<Repair> repairs);

    int addRepair(Repair repair);
}
