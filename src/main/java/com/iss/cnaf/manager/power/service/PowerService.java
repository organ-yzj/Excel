package com.iss.cnaf.manager.power.service;

import java.util.List;
import java.util.Map;

import com.iss.cnaf.manager.power.vo.Power;
import com.iss.cnaf.manager.sys.model.QueryParam;
import com.iss.cnaf.manager.user.vo.User;
import com.iss.cnaf.manager.sys.model.CnafGrid;

public interface PowerService {
	
	
	public CnafGrid queryPowers(QueryParam param, CnafGrid grid);

	/**
	 * 
	 * @method_name:queryPowerByUser 通过用户主键查询权限
	 * @author: WJF
	 * @date 2017年3月13日 下午2:04:48
	 * @version V1.0
	 * @param userId 用户主键
	 * @return
	 */
	List<Power> queryPowerByUser(String userId);

	List<Power> queryPowerList(String userId);
	
	List<Power> queryRightPowerList(String roleId);
	
	/**
	 * 通过登陆人查询菜单
	 * @author: WJF
	 * @date 2017年3月22日 上午10:22:29
	 * @version V1.0
	 * @param userId 登陆人信息
	 * @return
	 */
	List<Map<String, Object>> queryMenu(String userId);
}
