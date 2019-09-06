/**
 *    Copyright 2009-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.ray.study.mybatis.debug.mapper;

import com.ray.study.mybatis.debug.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * description
 *
 * @author shira 2019/09/05 23:29
 */
public interface UserMapper {

  /**
   * 根据用户名查询用户结果集
   *
   * @param name 用户名
   * @return 查询结果
   */
  @Select("SELECT * FROM  user  WHERE name = #{name}")
  User findByName(@Param("name") String name);

  User findById(Long id);

  /**
   * 查询所有用户
   *
   * @return
   */
  @Results({@Result(property = "name", column = "name"), @Result(property = "age", column = "age")})
  @Select("SELECT id,name, age,creation_date,creation_date FROM user")
  List<User> findAll();

  /**
   * 保存用户信息
   *
   * @param user 用户信息
   * @return 成功 1 失败 0
   */
  int insert(User user);

  @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
  int insertByNameAndAge(@Param("name") String name, @Param("age") Integer age);

  @Insert("INSERT INTO USER(NAME, AGE, CREATION_DATE, LAST_UPDATE_DATE) VALUES(#{name}, #{age}, #{creationDate}, #{lastUpdateDate} )")
  int insertByUser(User user);

  @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
  int insertByMap(Map<String, Object> map);


  @Update("UPDATE user SET age=#{age} WHERE name=#{name}")
  void update(User user);

  @Delete("DELETE FROM user WHERE id =#{id}")
  void delete(Long id);

}
