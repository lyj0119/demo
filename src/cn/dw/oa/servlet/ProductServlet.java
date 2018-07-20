package cn.dw.oa.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dw.oa.model.Product;
import cn.dw.oa.service.ProductService;
import cn.dw.oa.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService productService = new ProductServiceImpl();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		System.out.println(type);
		if (type.equals("save")) {
			Product product = new Product();
			product.setName(request.getParameter("name"));
			product.setPrice(Double.parseDouble(request.getParameter("price")));
			product.setRemark(request.getParameter("remark"));
			productService.save(product);
			response.sendRedirect("/demo/query.jsp");
		} else if (type.equals("query")) {
			String keyword = request.getParameter("keyword");
			request.setAttribute("proList", productService.queryByName(keyword));
			request.getSession().setAttribute("keyword", keyword);
			request.getRequestDispatcher("/query.jsp").forward(request, response);
		} else if (type.equals("delete")) {
			String id = request.getParameter("id");
			productService.delete(Integer.parseInt(id));
			String keyword = (String) request.getSession().getAttribute("keyword");
			request.setAttribute("proList", productService.queryByName(keyword));
			request.getRequestDispatcher("/query.jsp").forward(request, response);
		} else if (type.equals("getById")) {
			String id = request.getParameter("id");
			request.setAttribute("product", productService.getById(Integer.parseInt(id)));
			request.getRequestDispatcher("/update.jsp").forward(request, response);
		} else if (type.equals("update")) {
			Product product = new Product();
			product.setId(Integer.parseInt(request.getParameter("id")));
			product.setName(request.getParameter("name"));
			product.setPrice(Double.parseDouble(request.getParameter("price")));
			product.setRemark(request.getParameter("remark"));
			productService.update(product);
			response.sendRedirect("/demo/query.jsp");
		}
		
	}

}
