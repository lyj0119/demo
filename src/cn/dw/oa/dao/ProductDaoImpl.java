package cn.dw.oa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cn.dw.oa.model.Product;

public class ProductDaoImpl implements ProductDao {
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/* (non-Javadoc)
	 * @see cn.dw.oa.dao.ProductDao#save(cn.dw.oa.model.Product)
	 */
	@Override
	public int save(Product product) {
		String sql = "insert into product (name,price,remark) values (?,?,?)";
		return jdbcTemplate.update(sql, product.getName(), product.getPrice(), product.getRemark());
	}
	
	/* (non-Javadoc)
	 * @see cn.dw.oa.dao.ProductDao#update(cn.dw.oa.model.Product)
	 */
	@Override
	public int update(Product product) {
		String sql = "update product set name = ? , price = ? , remark = ? where id = ?";
		return jdbcTemplate.update(sql, product.getName(), product.getPrice(), product.getRemark(), product.getId());
	}
	
	/* (non-Javadoc)
	 * @see cn.dw.oa.dao.ProductDao#delete(int)
	 */
	@Override
	public int delete(int id) {
		String sql = "delete from product where id = ?";
		return jdbcTemplate.update(sql, id);
	}
	
	/* (non-Javadoc)
	 * @see cn.dw.oa.dao.ProductDao#getById(int)
	 */
	@Override
	public Product getById(int id) {
		String sql = "select * from product where id = ?";
		return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setRemark(rs.getString("remark"));
				product.setDate(rs.getDate("date"));
				return product;
			}, id);
	}
	
	/* (non-Javadoc)
	 * @see cn.dw.oa.dao.ProductDao#queryByName(java.lang.String)
	 */
	@Override
	public List<Product> queryByName(String keyword) {
		String sql = "select * from product where name like ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class), "%" + keyword + "%");
	}
	
}
