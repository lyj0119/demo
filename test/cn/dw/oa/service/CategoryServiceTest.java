package cn.dw.oa.service;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dw.oa.model.Category;

public class CategoryServiceTest {

	private static ApplicationContext applicationContext;
	private static CategoryService categoryService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");
		categoryService = applicationContext.getBean("categoryService", CategoryService.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testQueryByName() {
		for (Category category : categoryService.queryByName("家")) {
			System.out.println(category);
		}
	}

}
