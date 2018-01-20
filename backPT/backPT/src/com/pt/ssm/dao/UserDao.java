package com.pt.ssm.dao;

import java.util.List;
import java.util.Map;

import com.pt.ssm.po.User;



public interface UserDao {
	/**
	 * 添加用户
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	Integer addUser(Map<String, Object> paramMap) throws Exception;
	/**
	 * 查询用户信息
	 * @return
	 * @throws Exception
	 */
	List<User> getUser() throws Exception;
	/**
	 * 删除用户信息
	 * @param list
	 * @return
	 * @throws Exception
	 */
	Integer delUserById(Integer[] list) throws Exception;
	/**
	 * 修改用户信息
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	Integer updateUser(Map<String, Object> paramMap) throws Exception;
	/**
	 * 通过ID查询用户信息
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	User getUserByID(Map<String, Object> paramMap) throws Exception;
	/**
	 * 根据ID和USERNAME查询用户数用于判断修改是否重名
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Integer findUserName(Map<String, Object> map) throws Exception;
	/**
	 * 根据USERNAME查询用户数用于判断新增是否重名
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Integer getUserByName(Map<String, Object> map) throws Exception;

}
