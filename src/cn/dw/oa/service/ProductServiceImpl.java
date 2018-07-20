package cn.dw.oa.service;

import java.util.List;

import cn.dw.oa.dao.ProductDaoImpl;
import cn.dw.oa.model.Product;

public class ProductServiceImpl {

	private ProductDaoImpl productDao = new ProductDaoImpl();
	
	public int save(Product product) {
		return productDao.save(product);
	}
	
	public int update(Product product) {
		return productDao.update(product);
	}
	
	public int delete(int id) {
		return productDao.delete(id);
	}
	
	public Product getById(int id) {
		return productDao.getById(id);
	}
	
	public List<Product> queryByName(String keyword) {
		return productDao.queryByName(keyword);
	}
	
}
