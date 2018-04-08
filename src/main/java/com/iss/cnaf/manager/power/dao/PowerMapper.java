package com.iss.cnaf.manager.power.dao;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.iss.cnaf.manager.power.vo.Power;
import com.iss.cnaf.manager.sys.model.QueryParam;

public interface PowerMapper {
	
	Page<Power> queryPowers(QueryParam param);

	/**
	 * 
	 * @method_name:queryPowerByRole 通过用户主键查询权限
	 * @author: WJF
	 * @date 2017年3月13日 下午2:02:06
	 * @version V1.0
	 * @param userId 用户主键对应数据库user_id
	 * @return
	 */
	List<Power> queryPowerByUser(String userId);

	List<Power> queryPowerList();
	
	/**
	 * 
	 * @method_name:queryFistLevel 查询该用户的一级节点
	 * @author: WJF
	 * @date 2017年3月22日 上午10:11:22
	 * @version V1.0
	 * @param userId 用户编号
	 * @return
	 */
	Power queryFistLevel(Integer treeCode);
	
	/**
	 * 
	 * @method_name:querySecondLevel 通过父节点查询二级节点
	 * @author: WJF
	 * @date 2017年3月22日 上午10:13:09
	 * @version V1.0
	 * @param parentCode 父节点
	 * @param userId 用户编号
	 * @return
	 */
	List<Power> querySecondLevel(Map<String, Object> map);

	List<Power> queryRightPowerList(String roleId);

	List<Power> queryPowerList(List<Integer> powerIds);

	List<Power> queryAllPowerList();

}
