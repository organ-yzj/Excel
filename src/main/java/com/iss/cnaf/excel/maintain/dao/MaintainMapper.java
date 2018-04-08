package com.iss.cnaf.excel.maintain.dao;

import com.github.pagehelper.Page;
import com.iss.cnaf.excel.maintain.vo.Maintain;

import java.util.List;

/**
 * Created by Administrator on 2018/4/7.
 */
public interface MaintainMapper {
    Page<Maintain> queryMaintain();

    int insertList(List<Maintain> maintains);
}
