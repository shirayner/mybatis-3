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
import com.ray.study.mybatis.debug.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * description
 *
 * @author shira 2019/09/05 23:35
 */
public class UserMapperTest {

  @Test
  public void test() {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
    SqlSession sqlSession = sqlSessionFactory.openSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

    User user = new User("tom", 21);
    userMapper.insert(user);
    System.out.println(user.toString());

    User user1 = userMapper.findById(user.getId());
    System.out.println(user);

    sqlSession.commit();
    sqlSession.close();

  }

}
