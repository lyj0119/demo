package cn.dw.oa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.dw.oa.dao.CategoryDao;
import cn.dw.oa.model.Category;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Resource
	private CategoryDao categoryDao;
	
	@Override
	public List<Category> queryByName(String keyword) {
		return categoryDao.queryByName("%" + keyword + "%");
	}

}
