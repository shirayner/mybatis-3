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
package com.ray.study.mybatis.debug.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * description
 *
 * @author shira 2019/09/05 23:35
 */
public class SqlSessionFactoryUtil {

  public static SqlSessionFactory getSqlSessionFactory(){
    String path = "mybatis-config.xml";
    SqlSessionFactory sqlSessionFactory = null;
    try {
      Reader reader = Resources.getResourceAsReader(path);
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    } catch (IOException e) {
      System.out.println("获取配置文件失败");
      e.printStackTrace();
    }

    return sqlSessionFactory;
  }

}
