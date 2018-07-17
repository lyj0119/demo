package cn.dw.oa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.dw.oa.model.Product;

public class ProductDaoImpl extends BaseDaoImpl<Product>{

	public static void main(String[] args) {
		ProductDaoImpl daoImpl = new ProductDaoImpl();
		System.out.println(daoImpl.getById(1));
	}
	
	public void save(Product product) {
		String sql = "insert into product (name,price,remark) values (?,?,?)";
		super.update(sql, product.getName(), product.getPrice(), product.getRemark());
	}
	
	public void update(Product product) {
		String sql = "update product set name = ? , price = ? , remark = ? where id = ?";
		super.update(sql, product.getName(), product.getPrice(), product.getRemark(), product.getId());
	}
	
	public void delete(int id) {
		String sql = "delete from product where id = ?";
		super.update(sql, id);
	}
	
	public Product getById(int id) {
		String sql = "select * from product where id = ?";
		List<Product> pList = query(sql, id);
		return pList.size() == 0 ? null : pList.get(0);
	}

	@Override
	protected Product getRow(ResultSet resultSet) throws SQLException {
		Product product = new Product();
		product.setDate(resultSet.getDate("date"));
		product.setId(resultSet.getInt("id"));
		product.setRemark(resultSet.getString("remark"));
		product.setName(resultSet.getString("name"));
		product.setPrice(resultSet.getDouble("price"));
		return product;
	}
	
}
