package cn.dw.oa.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dw.oa.model.Product;
import cn.dw.oa.service.ProductService;

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
		product.setName("速度放松放松分");
		product.setPrice(234.5);
		product.setRemark("asdadada阿打算");
		productService.save(product);
	}

	@Test
	public void testUpdateProduct() {
		Product product = new Product();
		product.setName("速度放松放松分");
		product.setPrice(234.5);
		product.setRemark("asdadada阿打算");
		product.setId(5);
		productService.update(product);
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		System.out.println(productService.getById(5));
	}

	@Test
	public void testQueryByName() {
		for (Product product : productService.queryByName("one")) {
			System.out.println(product);
		}
	}
}
