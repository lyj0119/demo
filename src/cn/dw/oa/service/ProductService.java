package cn.dw.oa.service;

import java.util.List;

import cn.dw.oa.model.Product;

public interface ProductService {

	int save(Product product);

	int update(Product product);

	int delete(int id);

	Product getById(int id);

	List<Product> queryByName(String keyword);

}