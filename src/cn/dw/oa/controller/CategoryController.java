package cn.dw.oa.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dw.oa.model.Category;

@RequestMapping("/category")
@Controller
public class CategoryController extends BaseController {

	@RequestMapping("/query")
	@ResponseBody
	public Object query() {
		return null;
	}
	
}
