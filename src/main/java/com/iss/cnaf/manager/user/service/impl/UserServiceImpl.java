package com.iss.cnaf.manager.user.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.iss.cnaf.manager.sys.model.*;
import com.iss.cnaf.manager.user.dao.UsersMapper;
import com.iss.cnaf.manager.user.vo.StatusDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.iss.cnaf.manager.user.service.UserService;
import com.iss.cnaf.manager.user.vo.Register;
import com.iss.cnaf.manager.user.vo.User;
import com.iss.cnaf.manager.user.vo.RegisterHistory;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public CnafGrid doQueryUsers(QueryParam param, CnafGrid grid, Integer airportId) {
        // TODO Auto-generated method stub
        Map<String, Object> map = new HashMap<>(1);
        map.put("airportId", airportId);
        PageHelper.startPage(param.getPage(), param.getRows());
        Page<User> page = usersMapper.queryUsers(map);
        grid.setGrid(page.getTotal(), page.getResult());
        return grid;
    }

    @Override
    public void saveUser(User user, HttpServletRequest request) {
        if (null != user.getPassword() && !"".equals(user.getPassword().trim())) {
            user.setPassword(Encrypt.md5(user.getPassword()));
        }
        SessionUser session = (SessionUser) request.getSession().getAttribute("sessionInfo");
        user.setAirportId(session.getAirportId());
        user.setLasttime(new Date());
        usersMapper.insertSelective(user);
    }

    @Override
    public void updateUser(User user) {
        usersMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deleteUser(int id) {
        // TODO Auto-generated method stub
        usersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User doLogin(User user) {
        /*param*/
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", user.getUsername());
        if (null != user.getPassword() && !"".equals(user.getPassword().trim())) {
            map.put("pass", Encrypt.md5(user.getPassword()));
        } else {
            map.put("pass", user.getPassword());
        }
        user = usersMapper.doLogin(map);
        return user;
    }

    @Override
    public List<User> selectByUserid(User user) {
        // TODO Auto-generated method stub
        return usersMapper.checkByUserid(user);
    }

    @Override
    public List<User> checkUser(User user, HttpServletRequest request) {
        SessionUser session = (SessionUser) request.getSession().getAttribute("sessionInfo");
        user.setAirportId(session.getAirportId());
        return usersMapper.checkByUser(user);
    }

    @Override
    public void updateUserpass(User user) {
        // TODO Auto-generated method stub
        user.setPassword(Encrypt.md5(user.getPassword()));
        usersMapper.updateByPrimaryKeySelective(user);

    }

    /**************        regist模块                                            **************/

    @Override
    public CnafGrid doQueryRegister(QueryParam param, CnafGrid grid, HttpServletRequest request) {
        Map<String, Object> paramap = new HashMap<>(1);
        SessionUser user = (SessionUser) request.getSession().getAttribute("sessionInfo");
        paramap.put("airportId", user.getAirportId());
        PageHelper.startPage(param.getPage(), param.getRows());
        Page<Register> page = usersMapper.queryRegister(paramap);
        grid.setGrid(page.getTotal(), page.getResult());
        return grid;
    }



    @Override
    public void updateRegister(Register register) {
        usersMapper.updateRegisterstatus(register);
    }

    @Override
    public void assignRole(User user) {
        usersMapper.updateRole(user);
    }

    @Override
    public void deleteRegisterById(Register registry) {
        usersMapper.deleteRegisterById(registry.getAutoId());

    }

    @Override
    public Register checkCarVal(Register registry) {
        return usersMapper.checkCarValidate(registry);
    }

    @Override
    public Register checkUserValidate(Register registry) {
        return usersMapper.checkUserValidate(registry);
    }

    @Override
    public List<User> checkRoleId(User user) {
        return usersMapper.checkRoleId(user);
    }

    @Override
    public Register selectByCarID(Register register) {
        return usersMapper.selectByCarId(register);
    }

    @Override
    public List<GasMember> queryWorkByCar(HttpServletRequest request, Register register) {
        SessionUser user = (SessionUser) request.getSession().getAttribute("sessionInfo");
        register.setAirportId(user.getAirportId());
        Register Register2 = null;
        if (register != null && !"null".equals(register) && !"".equals(register)) {

            Register2 = usersMapper.selectByCarId(register);
        }
        List<GasMember> comboboxModel = new ArrayList<>();
        //查询当前任务的加油员信息
        if (Register2 != null) {
            GasMember m = new GasMember();
            m.setId(Register2.getUserId());
            m.setText(Register2.getUserName());
            comboboxModel.add(m);
        }
        //查询状态为0和4的加油员信息
        List<Register> registers = usersMapper.queryRegistryWorker();
        for (Register r : registers) {
            GasMember m = new GasMember();
            m.setId(r.getUserId());
            m.setText(r.getUserName());
            comboboxModel.add(m);
        }
        return comboboxModel;

    }

    @Override
    public List<GasMember> queryAllWorkByCar(HttpServletRequest request, Register registry) {
        SessionUser user = (SessionUser) request.getSession().getAttribute("sessionInfo");
        registry.setAirportId(user.getAirportId());
        Register Register2 = null;
        if (registry != null && !"null".equals(registry) && !"".equals(registry)) {

            Register2 = usersMapper.selectByCarId(registry);
        }
        List<GasMember> comboboxModel = new ArrayList<>();
        //查询当前任务的加油员信息
        if (Register2 != null) {
            GasMember m = new GasMember();
            m.setId(Register2.getUserId());
            m.setText(Register2.getUserName());
            comboboxModel.add(m);
        }
        //查询状态为0和4的加油员信息
        List<Register> registers = usersMapper.queryAllRegistryWorker();
        for (Register r : registers) {
            GasMember m = new GasMember();
            m.setId(r.getUserId());
            m.setText(r.getUserName());
            comboboxModel.add(m);
        }
        return comboboxModel;
    }

    @Override
    public void setRefuelNumZreo(Register registry) {
        usersMapper.setRefuelNumZreo(registry);

    }

    @Override
    public Register selectRegisterByPadId(String padId) {
        return usersMapper.selectByPadId(padId);
    }

    @Override
    public void setRefuelNumZreoAndConCountZreo() {
        usersMapper.setRefuelNumZreoAndConCountZreo();
    }


    /**
     * 更新状态，是否暂停
     */
    @Override
    public void updateRegisterStatus(Register register) {
        usersMapper.updateRegisterstatus(register);
    }

    @Override
    public Register selectRegister(Integer autoId) {
        return usersMapper.selectRegisterByPrimaryKey(autoId);
    }

    /**
     * 删除记录
     */
    @Override
    public void deleteRegister(Integer autoId) {
        usersMapper.deleteRegisterByPrimaryKey(autoId);
    }

    @Override
    public void saveRegisterHistory(RegisterHistory registerHistory) {
        usersMapper.insertRegisterHistory(registerHistory);
    }

    @Override
    public String queryPersonNum() {
        return usersMapper.queryPersonNum();
    }

    @Override
    public void updaStatus(Register register) {
        usersMapper.updateStatusByUserId(register);
    }

    @Override
    public void updateRegisterCount(Register count) {
        usersMapper.updateRegisterCount(count);
    }

    @Override
    public void updateLastMissionTimeByCarId(Register register) {
        usersMapper.updateLastMissionTimeByCarId(register);
    }

    @Override
    public Register queryStatu(Register register) {
        return usersMapper.queryStatu(register);
    }

    @Override
    public void setRefuelNumByCarId(Register regis) {
        usersMapper.setRefuelNumByCarId(regis);

    }

    @Override
    public void toZero(Register registry) {
        usersMapper.setRefuelNumZreo(registry);
    }

    @Override
    public void updaStatusByCarId(Register register) {
        usersMapper.updaStatusByCarId(register);
    }

    @Override
    public Register queryRegisterByCarId(Register register) {
        return usersMapper.queryRegisterByCarId(register);
    }

    @Override
    public List<Register> queryRegistryByUserId(String userId) {
        return usersMapper.queryRegisterByCarIdAndStatusNotEquals10(userId);
    }

    @Override
    public List<Register> queryRegistryWorker() {
        return usersMapper.queryRegistryWorker();
    }

    @Override
    public List<Register> queryAllRegistryWorker() {
        return usersMapper.queryAllRegistryWorker();
    }

    @Override
    public void updateRegisterPreStatusByCarId(String carId) {
        usersMapper.updateRegisterPreStatusByCarId(carId);
    }

    @Override
    public void updateRegisterPreStatusByCarId(Register register) {
        usersMapper.updateRegisterPreStatus(register);
    }

    @Override
    public void updateRegisterPreStatusByUserId(Register register) {
        usersMapper.updateRegisterPreStatusByUserId(register);
    }



    @Override
    public GasCar queryCarByWorker(HttpServletRequest request, Register register) {
        SessionUser user = (SessionUser) request.getSession().getAttribute("sessionInfo");
        register.setAirportId(user.getAirportId());
        GasCar m = new GasCar();
        Register register2 = null;
        if (register != null && !"null".equals(register) && !"".equals(register)) {
            register2 = usersMapper.selectByWorkerId(register);
        }
        if (register2 != null) {
            m.setId(register2.getCarId());
            m.setText(register2.getCarId());
        }
        return m;
    }

    /**
     * 预排暂停可以选
     * @param request
     * @param registry
     * @return
     */
    @Override
    public GasCar queryCarPrepare(HttpServletRequest request, Register registry) {
        SessionUser user = (SessionUser) request.getSession().getAttribute("sessionInfo");
        registry.setAirportId(user.getAirportId());
        GasCar m = new GasCar();
        Register register2 = null;
        if (registry != null && !"null".equals(registry) && !"".equals(registry)) {
            register2 = usersMapper.selectByPrepareId(registry);
        }
        if (register2 != null) {
            m.setId(register2.getCarId());
            m.setText(register2.getCarId());
        }
        return m;
    }

    @Override
    public GasPad queryPadByWorker(HttpServletRequest request, Register registry) {
        SessionUser user = (SessionUser) request.getSession().getAttribute("sessionInfo");
        registry.setAirportId(user.getAirportId());
        GasPad m = new GasPad();
        Register register2 = null;
        if (registry != null && !"null".equals(registry) && !"".equals(registry)) {
            register2 = usersMapper.selectByWorkerId(registry);
        }
        if (register2 != null) {
            m.setId(register2.getPadId());
            m.setText(register2.getPadId());
        }
        return m;
    }

    @Override
    public GasPad queryPreprocePadByWorker(HttpServletRequest request, Register registry) {
        SessionUser user = (SessionUser) request.getSession().getAttribute("sessionInfo");
        registry.setAirportId(user.getAirportId());
        GasPad m = new GasPad();
        Register register2 = null;
        if (registry != null && !"null".equals(registry) && !"".equals(registry)) {
            register2 = usersMapper.selectPreproceByWorkerId(registry);
        }
        if (register2 != null) {
            m.setId(register2.getPadId());
            m.setText(register2.getPadId());
        }
        return m;
    }

    @Override
    public List<GasMember> queryStatusList(HttpServletRequest request) {
        List<StatusDto> status = usersMapper.queryStatusList();
        ArrayList<GasMember> comboboxModel = new ArrayList<GasMember>();
        for (StatusDto s : status) {
            GasMember m = new GasMember();
            m.setId(s.getStatus());
            m.setText(s.getDescription());
            comboboxModel.add(m);
        }
        return comboboxModel;
    }

    @Override
    public void updaStatusByAutoId(Register register) {
        usersMapper.updaStatusByAutoId(register);
    }

    @Override
    public int updateStatusAndPreStatusByCarId(Register register) {
        return usersMapper.updateStatusAndPreStatusByCarId(register);
    }

    @Override
    public Register selectByWorkerId(Register person) {
        return usersMapper.selectByWorkerId(person);
    }
}
