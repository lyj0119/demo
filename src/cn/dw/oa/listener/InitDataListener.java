package cn.dw.oa.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.dw.oa.model.Category;
import cn.dw.oa.service.CategoryService;

@WebListener
public class InitDataListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("InitDataListener.contextDestroyed()");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("InitDataListener.contextInitialized()");
		ServletContext application = event.getServletContext();
		WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(application);
		CategoryService categoryService = applicationContext.getBean("categoryService", CategoryService.class);
		List<Category> catList = categoryService.queryByName("");
		application.setAttribute("catList", catList);
	}

}
