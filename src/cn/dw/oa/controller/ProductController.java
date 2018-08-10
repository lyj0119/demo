package cn.dw.oa.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;

import cn.dw.oa.model.Product;
import cn.dw.oa.service.ProductService;

@RequestMapping("/product")
public class ProductController {

	private ProductService productService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@Resource
	private HttpServletRequest request;
	
	@Resource
	private HttpSession session;
	
	@RequestMapping("/save")
	public String save(Product product) {
		productService.save(product);
		return "redirect:/query.jsp";
	}
	
	@RequestMapping("/query")
	public String query(String keyword) {
		request.setAttribute("proList", productService.queryByName(keyword));
		session.setAttribute("keyword", keyword);
		return "forward:/query.jsp";
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id) {
		productService.delete(id);
		String keyword = (String) session.getAttribute("keyword");
		request.setAttribute("proList", productService.queryByName(keyword));
		return "forward:/query.jsp";
	}
	
	@RequestMapping("/getById")
	public String getById(Integer id) {
		request.setAttribute("product", productService.getById(id));
		return "forward:/update.jsp";
	}
	
	@RequestMapping("/update")
	public String update(Product product) {
		productService.update(product);
		String keyword = (String) session.getAttribute("keyword");
		request.setAttribute("proList", productService.queryByName(keyword));
		return "forward:/query.jsp";
	}
	
}
