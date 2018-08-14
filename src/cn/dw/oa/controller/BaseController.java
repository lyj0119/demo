package cn.dw.oa.controller;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.dw.oa.service.CategoryService;
import cn.dw.oa.service.ProductService;

public class BaseController {

	@Resource
	protected ProductService productService;
	
	@Resource
	protected CategoryService categoryService;
	
	@Resource
	protected HttpServletRequest request;

	@Resource
	protected HttpSession session;
	
	@Resource
	protected ServletContext application;

}