package com.iss.cnaf.manager.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iss.cnaf.manager.sys.model.*;
import com.iss.cnaf.manager.user.vo.Register;
import com.iss.cnaf.manager.user.vo.RegisterHistory;
import com.iss.cnaf.manager.user.vo.User;

/**
 * @author David
 */
public interface UserService {

    CnafGrid doQueryUsers(QueryParam param, CnafGrid grid, Integer airportI);

    void saveUser(User user, HttpServletRequest request);

    void updateUser(User user);

    void deleteUser(int id);

    User doLogin(User user);

    List<User> selectByUserid(User user);

    List<User> checkUser(User user, HttpServletRequest request);

    void updateUserpass(User user);


    CnafGrid doQueryRegister(QueryParam param, CnafGrid grid, HttpServletRequest request);


    void updateRegister(Register register);

    void assignRole(User user);

    void deleteRegisterById(Register registry);

    Register checkCarVal(Register registry);

    Register checkUserValidate(Register registry);

    List<User> checkRoleId(User user);

    /**
     * 根据carId查询登记表
     * @param registry
     * @return
     */
    Register selectByCarID(Register registry);

    List<GasMember> queryWorkByCar(HttpServletRequest request, Register registry);

    List<GasMember> queryAllWorkByCar(HttpServletRequest request, Register registry);

    GasCar queryCarByWorker(HttpServletRequest request, Register registry);

    GasCar queryCarPrepare(HttpServletRequest request, Register registry);

    GasPad queryPadByWorker(HttpServletRequest request, Register registry);

    void setRefuelNumZreo(Register registry);

    Register selectRegisterByPadId(String padId);

    /**
     * 将当前所有注册的加油员的总加油量和连续加油量置为0
     */
    void setRefuelNumZreoAndConCountZreo();

    void updateRegisterStatus(Register register);

    Register selectRegister(Integer autoId);

    void deleteRegister(Integer autoId);

    void saveRegisterHistory(RegisterHistory registerHistory);

    String queryPersonNum();

    void updaStatus(Register register);

    void updateRegisterCount(Register count);

    void updateLastMissionTimeByCarId(Register register);

    Register queryStatu(Register register);

    void setRefuelNumByCarId(Register regis);

    void toZero(Register registry);

    void updaStatusByCarId(Register register);

    Register queryRegisterByCarId(Register register);

    List<Register> queryRegistryByUserId(String userId);

    List<Register> queryRegistryWorker();

    List<Register> queryAllRegistryWorker();

    void updateRegisterPreStatusByCarId(String carId);

    /**
     * 修改pre_status状态，传入carId和pre_status
     * @param register
     */
    void updateRegisterPreStatusByCarId(Register register);

    /**
     * 修改pre_status状态根据userId，传入userId和pre_status
     * @param register
     */
    void updateRegisterPreStatusByUserId(Register register);


    GasPad queryPreprocePadByWorker(HttpServletRequest request, Register registry);

    List<GasMember> queryStatusList(HttpServletRequest request);

    void updaStatusByAutoId(Register register);

    int updateStatusAndPreStatusByCarId(Register register);

    Register selectByWorkerId(Register person);
}
