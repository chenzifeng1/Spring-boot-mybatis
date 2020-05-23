package com.chenzifeng.learn.dao;

import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.bean.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {

    /**
     * 查询所有的角色
     * 在添加/修改用户的时候要使用此方法
     * @param jsonObject
     */
    List<JSONObject> getAllRoles(JSONObject jsonObject);
    /**
     * 角色列表
     * @param jsonObject
     */
    List<JSONObject> listRole(JSONObject jsonObject);

    /**
     * 新增角色
     */
    int insertRole(JSONObject jsonObject);

    /**
     * 根据角色名获取角色信息
     * @param jsonObject
     * @return
     */
    Role getRoleByName(JSONObject jsonObject);

    /**
     * 插入用户的角色信息
     * @param jsonObject
     * @return
     */
    int insertRoleByUser(JSONObject jsonObject);


    /**
     * 角色是否存在
     * @param jsonObject
     * @return
     */
    int queryExistRolename(JSONObject jsonObject);

    /**
     * 批量插入角色的权限
     *
     * @param roleId      角色ID
     * @param permissions 权限
     */
    int insertRolePermission(@Param("roleId") String roleId, @Param("permissions") List<Integer> permissions);

//
//    /**
//     * 将角色曾经拥有而修改为不再拥有的权限 status改为'2'
//     */
//    int removeOldPermission(@Param("roleId") String roleId, @Param("permissions") List<Integer> permissions);
//
//    /**
//     * 修改角色名称
//     */
//    int updateRoleName(JSONObject jsonObject);
//
//    /**
//     * 查询某角色的全部数据
//     * 在删除和修改角色时调用
//     */
//    JSONObject getRoleAllInfo(JSONObject jsonObject);
//
//    /**
//     * 删除角色
//     */
//    int removeRole(JSONObject jsonObject);
//
////    /**
////     * 删除本角色全部权限
////     */
////    int removeRoleAllPermission(JSONObject jsonObject);
//
//    /**
//     * 查询该角色拥有的用户
//     * @param jsonObject
//     * @return
//     */
//    int getUserIds(JSONObject jsonObject);
//

//
//    /**
//     * 修改角色
//     * @param requestJson
//     */
//    void updateRole(JSONObject requestJson);
//
//    /**
//     * 查询角色数量
//     * @param jsonObject
//     * @return
//     */
//    int countRole(JSONObject jsonObject);
////
////    /**
////     *  计算分页查询的总数
////     * @param jsonObject
////     * @return
////     */
////    int countRoles(JSONObject jsonObject);
//
    /**
     * 根据用户查询所有的角色
     * @param requestJson
     * @return
     */
    List<JSONObject> getIdsByUser(JSONObject requestJson);
//
//    /**
//     * 导出查询
//     * @param requestJson
//     * @return
//     */
//    List<JSONObject> getRoles(JSONObject requestJson);
}
