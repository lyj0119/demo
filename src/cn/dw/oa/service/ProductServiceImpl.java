package cn.dw.oa.service;

import java.util.List;

import cn.dw.oa.dao.ProductDao;
import cn.dw.oa.model.Product;

public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	/* (non-Javadoc)
	 * @see cn.dw.oa.service.ProductService#save(cn.dw.oa.model.Product)
	 */
	@Override
	public int save(Product product) {
		System.out.println(productDao);
		System.out.println(product);
		int result = productDao.save(product);
		//Integer.parseInt("sss");
		return result;
	}
	
	/* (non-Javadoc)
	 * @see cn.dw.oa.service.ProductService#update(cn.dw.oa.model.Product)
	 */
	@Override
	public int update(Product product) {
		return productDao.update(product);
	}
	
	/* (non-Javadoc)
	 * @see cn.dw.oa.service.ProductService#delete(int)
	 */
	@Override
	public int delete(int id) {
		return productDao.delete(id);
	}
	
	/* (non-Javadoc)
	 * @see cn.dw.oa.service.ProductService#getById(int)
	 */
	@Override
	public Product getById(int id) {
		return productDao.getById(id);
	}
	
	/* (non-Javadoc)
	 * @see cn.dw.oa.service.ProductService#queryByName(java.lang.String)
	 */
	@Override
	public List<Product> queryByName(String keyword) {
		int page = 2;
		int size = 5;
		return productDao.queryByName("%" + keyword + "%", (page - 1) * size, size);
	}
	
}
