package com.github.hmld.desptop.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.hmld.desptop.core.enity.SysManagerEnity;

/**
 * 用户表 mapper
 * @author hmld
 *
 */
@Mapper
public interface SysManagerMapper {
  /**
   * 查询所有
   * @param sysManagerEnity 参数
   * @return 结果集
   */
  public List<SysManagerEnity> queryList(SysManagerEnity sysManagerEnity);
  /**
   * 查询一条
   * @param managerUserPk 主键
   * @return 结果
   */
  public SysManagerEnity queryOne(String managerUserPk);
  /**
   * 通过用户名 查询一条
   * @param managerUserName 所属用户名
   * @return 结果
   */
  public SysManagerEnity queryOneByUserName(String managerUserName);
  /**
   * 添加一条
   * @param sysManagerEnity 参数
   * @return 结果数
   */
  public int addOne(SysManagerEnity sysManagerEnity) ;
  /**
   * 更新一条
   * @param sysManagerEnity 参数
   * @return 结果数
   */
  public int updateOne(SysManagerEnity sysManagerEnity) ;
  /**
   * 删除一条
   * @param sysManagerEnity 参数
   * @return 结果数
   */
  public int delOne(SysManagerEnity sysManagerEnity);
}
