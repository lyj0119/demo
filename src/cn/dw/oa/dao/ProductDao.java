package cn.dw.oa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.dw.oa.model.Product;

public interface ProductDao {

	int save(Product product);

	int update(Product product);

	int delete(int id);

	Product getById(int id);

	List<Product> queryByName(@Param("keyword") String keyword, 
			@Param("start") int start, @Param("size") int size);

}