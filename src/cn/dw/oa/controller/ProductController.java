package cn.dw.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.dw.oa.model.Product;

@RequestMapping("/product")
@Controller
public class ProductController extends BaseController {

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
