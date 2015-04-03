package com.yigou.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yigou.service.IAdminService;
import com.yigou.service.IAdminServiceImpl;

/*
 * Author by QinJiangbo 2012302580314
 * 
 *  Date 2014-05-24
 *  
 *  All Rights Reseverd
 *  
 *   Copy is never allowed!
 * */

public class AdminServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IAdminService adminService = new IAdminServiceImpl();

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	@SuppressWarnings("rawtypes")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession sessionAdmin = request.getSession();
		//get the method parameters from the jsp page and judge which function to execute
		String method = request.getParameter("method");
		if (method.equals("login")) {
			if (sessionAdmin.getAttribute("adminName") == null) {
				String adminName = request.getParameter("adminName");
				String password = request.getParameter("password");
				if (adminService.login(adminName, password)) {
					sessionAdmin.setAttribute("adminName", adminName);
					sessionAdmin.setAttribute("password", password);
					request.getRequestDispatcher("administrationIndex.jsp")
							.forward(request, response);
				} else {
					request.getRequestDispatcher("adminLogin.jsp").forward(
							request, response);
				}
			} else {
				String adminName = sessionAdmin.getAttribute("adminName").toString();
				String password = sessionAdmin.getAttribute("password").toString();
				if (adminService.login(adminName, password)) {
					request.getRequestDispatcher("administrationIndex.jsp")
							.forward(request, response);
				} else {
					request.getRequestDispatcher("adminLogin.jsp").forward(
							request, response);
				}
			}
		}
		if(method.equals("showUser"))
		{
			Map[] adminUserList=this.adminService.showUser();
			sessionAdmin.setAttribute("adminUserList", adminUserList);
			request.getRequestDispatcher("administrateUser.jsp").forward(request, response);
		}
		if(method.equals("deleteUser"))
		{
			String userName=request.getParameter("adminUserName");
			this.adminService.deleteUser(userName);
			Map[] adminUserList=this.adminService.showUser();
			sessionAdmin.setAttribute("adminUserList", adminUserList);
			request.getRequestDispatcher("administrateUser.jsp").forward(request, response);
		}
		if(method.equals("showProduct"))
		{
			Map[] adminProductList=this.adminService.showProducts();
			sessionAdmin.setAttribute("adminProductList", adminProductList);
			request.getRequestDispatcher("administrateProduct.jsp").forward(request, response);
		}
		if(method.equals("deleteProduct"))
		{
		    String productID=request.getParameter("adminProductID");
		    this.adminService.deleteProduct(productID);
			Map[] adminProductList=this.adminService.showProducts();
			sessionAdmin.setAttribute("adminProductList", adminProductList);
			request.getRequestDispatcher("administrateProduct.jsp").forward(request, response);
		}
		if(method.equals("showFeedback"))
		{
			Map[] adminFeedbackList=this.adminService.showFeedback();
			sessionAdmin.setAttribute("adminFeedbackList", adminFeedbackList);
			request.getRequestDispatcher("administrateFeedback.jsp").forward(request, response);
		}
		if(method.equals("deleteFeedback"))
		{
		    String feedbackID=request.getParameter("adminFeedbackID");
		    this.adminService.deleteFeedback(feedbackID);
			Map[] adminFeedbackList=this.adminService.showProducts();
			sessionAdmin.setAttribute("adminFeedbackList", adminFeedbackList);
			request.getRequestDispatcher("administrateFeedback.jsp").forward(request, response);
		}
		if(method.equals("modifyProduct"))
		{
			String productID=request.getParameter("modifyProductID");
			String productType=request.getParameter("modifyProductType");
			String productName=request.getParameter("modifyProductName");
			String productPrice=request.getParameter("modifyProductPrice");
			String productQuantity=request.getParameter("modifyProductQuantity");
			String productImage=request.getParameter("modifyProductImage");
			String productDescription=request.getParameter("modifyProductDescription");
			String productTime=request.getParameter("modifyProductTime");
			this.adminService.modifyProduct(productID, productType, productName, productPrice, productQuantity, productImage, productDescription, productTime);
			Map[] adminProductList=this.adminService.showProducts();
			sessionAdmin.setAttribute("adminProductList", adminProductList);
			request.getRequestDispatcher("administrateProduct.jsp").forward(request, response);
		}
		if(method.equals("logout"))
		{
			sessionAdmin.invalidate();
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
		}
		if(method.equals("showAdmin"))
		{
			Map[] administratorsList=this.adminService.showAdmin();
			sessionAdmin.setAttribute("administratorsList", administratorsList);
			request.getRequestDispatcher("Administrator.jsp").forward(request, response);
		}
		if(method.equals("deleteAdmin"))
		{
			String adminID=request.getParameter("adminID");
			this.adminService.deleteAdmin(adminID);
			Map[] administratorsList=this.adminService.showAdmin();
			sessionAdmin.setAttribute("administratorsList", administratorsList);
			request.getRequestDispatcher("Administrator.jsp").forward(request, response);
		}
		if(method.equals("addAdmin"))
		{
			String adminName=request.getParameter("adminInputName");
			String password=request.getParameter("password");
			String adminQQ=request.getParameter("adminQQ");
			String adminLevel=request.getParameter("adminLevel");
			this.adminService.addAdmin(adminName, password, adminQQ,adminLevel);
			Map[] administratorsList=this.adminService.showAdmin();
			sessionAdmin.setAttribute("administratorsList", administratorsList);
			request.getRequestDispatcher("Administrator.jsp").forward(request, response);
			
		}
	}

}
