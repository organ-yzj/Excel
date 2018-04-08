package com.iss.cnaf.manager.power.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.iss.cnaf.manager.power.dao.PowerMapper;
import com.iss.cnaf.manager.power.service.PowerService;
import com.iss.cnaf.manager.power.vo.Power;
import com.iss.cnaf.manager.sys.model.CnafGrid;
import com.iss.cnaf.manager.sys.model.QueryParam;

@Service
public class PowerServiceImpl implements PowerService {

	@Autowired
	private PowerMapper powerMapper;

	
	@Override
	public CnafGrid queryPowers(QueryParam param, CnafGrid grid) {
		PageHelper.startPage(param.getPage(), param.getRows());
		Page<Power> page = powerMapper.queryPowers(param);
		grid.setGrid(page.getTotal(), page.getResult());
		return grid;
	}
	
	@Override
	public List<Power> queryPowerByUser(String userId) {
		List<Power> list = powerMapper.queryPowerByUser(userId);
		return list;
	}
	@Override
	public List<Power> queryPowerList(String roleId) {
		List<Power> list = powerMapper.queryRightPowerList(roleId);
		List<Power> powerList;
		if(list.size()==0){
			powerList = powerMapper.queryAllPowerList();
		}else{
			List<Integer> powerIds = new ArrayList<Integer>();
			for (int i = 0; i < list.size(); i++) {
				powerIds.add(list.get(i).getId());
			}
			powerList = powerMapper.queryPowerList(powerIds);
		}
		return powerList;
	}
	
	@Override
	public List<Power> queryRightPowerList(String roleId) {
		return powerMapper.queryRightPowerList(roleId);
	}

	@Override
	public List<Map<String, Object>> queryMenu(String userId) {
		Map<String, Object> paramMap = new HashMap<>();
		List<Power> powers = powerMapper.queryPowerByUser(userId);
		List<Map<String, Object>> firstMap = new ArrayList<Map<String, Object>>();
		if(powers.size()>0){
			Set<Integer> parent = new HashSet<Integer>();
			for(Power p:powers){
				if(p.getParentCode()!=0){
					parent.add(p.getParentCode());
				}
				
			}
			List<Power> first = new ArrayList<Power>();
			Iterator<Integer> item = parent.iterator();
			while(item.hasNext()){
				Integer parentCode = item.next();
				first.add(powerMapper.queryFistLevel(parentCode));
			}
			
			for(Power firstPower:first){
				Map<String, Object> fMap = new HashMap<String, Object>();
				fMap.put("id", firstPower.getTreeCode());
				fMap.put("text", firstPower.getPowerName());
				paramMap.put("userId", userId);
				paramMap.put("parentCode", firstPower.getTreeCode());
				List<Power> secondList = powerMapper.querySecondLevel(paramMap);
				if(secondList.size()>0){
					List<Map<String, Object>> childrenMap = new ArrayList<Map<String, Object>>();
					for(Power second:secondList){
						Map<String, Object> sMap = new HashMap<>();
						sMap.put("id", second.getTreeCode());
						sMap.put("text", second.getPowerName());
						Map<String, Object> attributesMap = new HashMap<>();
						attributesMap.put("url", second.getUrl());
						sMap.put("attributes", attributesMap);
						childrenMap.add(sMap);
					}
					fMap.put("children", childrenMap);
				}
				firstMap.add(fMap);
			}
		}
		
		return firstMap;
	}

}
