package com.iss.cnaf.manager.user.dao;

import java.util.List;
import java.util.Map;

import com.iss.cnaf.manager.user.vo.StatusDto;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.iss.cnaf.manager.user.vo.Register;
import com.iss.cnaf.manager.user.vo.RegisterHistory;
import com.iss.cnaf.manager.user.vo.User;


/**
 * @author David
 */
public interface UsersMapper {

    int deleteByPrimaryKey(Integer autoId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer autoId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * queryUsers:查询用户集合
     *
     * @param map
     * @return
     * @author 李云萍
     * @since 　Ver 1.1
     */
    Page<User> queryUsers(Map<String, Object> map);

    /**
     * queryCountUsers:获取用户信息记录数
     *
     * @return
     * @author 李云萍
     * @since 　Ver 1.1
     */

    Long queryCountUsers();

    /**
     * doLogin:  管理员登陆
     *
     * @param map
     * @return
     * @author 李丛阳
     * @since 　Ver 1.1
     */
    User doLogin(Map<String, Object> map);

    /**
     * checkByUserid:验证用户编号是否重复
     *
     * @param user
     * @return
     * @author 李云萍
     * @since 　Ver 1.1
     */
    List<User> checkByUserid(User user);

    List<User> checkByUser(User user);


    Page<Register> queryRegister(Map<String, Object> paramap);

    int insertRegister(Register register);

    int updateRegisterstatus(Register register);

    int deleteRegisterById(int autoId);

    /**
     * updateTaskPerson: 更新任務
     *
     * @param register
     * @author 李丛阳
     * @since 　Ver 1.1
     */
    void updateTaskPerson(Register register);

    void updateRole(User user);

    Register checkCarValidate(Register registry);

    Register checkUserValidate(Register registry);

    List<User> checkRoleId(User user);

    /**
     * 根据carId查询登记表
     * @param registry
     * @return
     */
    Register selectByCarId(Register registry);

    /**
     * 根据workerId查询登记记录
     * @param registry
     * @return
     */
    Register selectByWorkerId(Register registry);
    /**
     * 预排暂停可选
     * @param registry
     * @return
     */
    Register selectByPrepareId(Register registry);
    /**
     * 通过padId查询
     * @param padId
     * @return
     */
    Register selectByPadId(@Param("padId") String padId);

    void setRefuelNumZreo(Register registry);

    /**
     * 将当前所有注册的加油员的总加油量和连续加油量置为0
     */
    void setRefuelNumZreoAndConCountZreo();

    /**
     * 根据carId修改RefuelNum
     * @param registry
     */
    void setRefuelNumByCarId(Register registry);

    Register selectRegisterByPrimaryKey(Integer autoId);

    void deleteRegisterByPrimaryKey(Integer autoId);

    void insertRegisterHistory(RegisterHistory registerHistory);

    String queryPersonNum();

    /**
     * 根据userId修改状态
     * @param register
     * @return
     */
    int updateStatusByUserId(Register register);

    Register queryStatu(Register register);

    int updateRegisterCount(Register count);

    void updateLastMissionTimeByCarId(Register register);

    /**
     * 根据carId查询登记记录
     * @param register
     * @return
     */
    Register queryRegisterByCarId(Register register);

    /**
     * 根据userId查询登记记录
     * @param userId
     * @return
     */
    List<Register> queryRegisterByCarIdAndStatusNotEquals10(@Param("userId") String userId);

    /**
     * 根据carId修改status
     *
     * @param register
     */
    void updaStatusByCarId(Register register);

    /**
     * 查询状态为0和4的加油员信息
     * @return
     */
    List<Register> queryRegistryWorker();


    /**
     * 查询全部登记人员
     * @return
     */
    List<Register> queryAllRegistryWorker();

    /**
     * 根据carId更新pre_status状态为0
     *
     * @param carId
     */
    void updateRegisterPreStatusByCarId(@Param("carId") String carId);

    /**
     * 根据carId更新pre_status状态为1
     * @param carId
     */
    void updateRegisterPreStatus1ByCarId(@Param("carId") String carId);

    /**
     * 修改pre_status状态，传入carId和pre_status
     * @param register
     */
    void updateRegisterPreStatus(Register register);

    /**
     * 修改pre_status状态根据userId，传入userId和pre_status
     * @param register
     */
    void updateRegisterPreStatusByUserId(Register register);

    Register selectPreproceByWorkerId(Register registry);

    List<StatusDto> queryStatusList();

    void updaStatusByAutoId(Register register);

    int updateStatusAndPreStatusByCarId(Register register);
}