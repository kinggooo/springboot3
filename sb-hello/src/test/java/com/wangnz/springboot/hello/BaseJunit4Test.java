package com.wangnz.springboot.hello;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
//@ContextConfiguration(locations = {"classpath:junit/spring-mvc.xml", "classpath:junit/spring-mybatis.xml"})
//@Transactional()
//@ActiveProfiles(value="dev")
//@Rollback(value = false)
public class BaseJunit4Test {
}
