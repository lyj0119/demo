package cn.dw.oa.service;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dw.oa.model.Category;
import cn.dw.oa.model.Product;

public class ProductServiceTest {
	
	private static ApplicationContext applicationContext;
	private static ProductService productService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");
		productService = applicationContext.getBean("productService", ProductService.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testSave() {
		Product product = new Product();
		product.setName("huawei234");
		product.setPrice(345.0);
		Category category = new Category();
		category.setId(2);
		product.setCategory(category);
		productService.save(product);
	}

	@Test
	public void testUpdate() {
		Product product = new Product();
		product.setId(2);
		product.setName("honor123");
		productService.update(product);
	}

	@Test
	public void testDelete() {
		productService.delete(2);
	}

	@Test
	public void testGetById() {
		System.out.println(productService.getById(1));
	}

	@Test
	public void testQueryByName() {
		for (Product temp : productService.queryByName("")) {
			System.out.println(temp);
		}
	}

}
