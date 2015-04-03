package com.yigou.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yigou.service.IUserService;
import com.yigou.service.IUserServiceImpl;

/*
 * Author by QinJiangbo 2012302580314
 * 
 *  Date 2014-05-24
 *  
 *  All Rights Reseverd
 *  
 *   Copy is never allowed!
 * */

public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IUserService userService=new IUserServiceImpl();
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@SuppressWarnings("rawtypes")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
		HttpSession session=request.getSession();
		//method from the login jsp page
		if(method.equals("userLogin"))
		{
			if(session.getAttribute("userEmail")==null)
			{
				String userEmail=request.getParameter("userEmail");
				String password=request.getParameter("password");
				if(userService.login(userEmail, password))
				{
					session.setAttribute("userEmail", userEmail);
					session.setAttribute("password", password);
					request.getRequestDispatcher("productServlet?method=Subquery").forward(request, response);
				}else
				{
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			}else
			{
				String userEmail=session.getAttribute("userEmail").toString();
				String password=session.getAttribute("password").toString();
				if(userService.login(userEmail, password))
				{
					request.getRequestDispatcher("productServlet?method=Subquery").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			}
		}
		//method from the register jsp page
		if(method.equals("userRegister"))
		{
			String email=request.getParameter("email");
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			String sex=request.getParameter("sex");
			String telephone=request.getParameter("telephone");
			String QQ=request.getParameter("QQ");
			String address=request.getParameter("Address");
			String date="";
			try{
				userService.register(0, userName, sex, password, email, telephone, QQ, address, date);
			    request.setAttribute("Msg", "<script>alert('Congratualations! You are now one of us!')</script>");
			}catch(Exception e){
			}
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		//method fro the user account jsp page 
		if(method.equals("userInfo"))
		{
			String userEmail=request.getParameter("userEmail");
			Map infoList=this.userService.userInfo(userEmail);
			session.setAttribute("infoList", infoList);
			request.getRequestDispatcher("userAccount.jsp").forward(request, response);
		}
		//add the feedbacks
		if(method.equals("addFeedback"))
		{
			String Feedback=request.getParameter("Feedback");
			String userEmail=session.getAttribute("userEmail").toString();
			this.userService.addFeedback(userEmail, Feedback);
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}
		// logout and invalidate the session
		if(method.equals("logout"))
		{
			session.invalidate();
			request.getRequestDispatcher("userLogin.jsp").forward(request, response);
		}
		//modify the user's information
		if(method.equals("modifyUser"))
		{
			String userID=request.getParameter("modifyUserID");
			String userName=request.getParameter("modifyUserName");
			String userGender=request.getParameter("modifyUserGender");
			String userPassword=request.getParameter("modifyUserPassword");
			String userEmail=request.getParameter("modifyUserEmail");
			String userTelephone=request.getParameter("modifyUserTelephone");
			String userQQ=request.getParameter("modifyUserQQ");
			String userAddress=request.getParameter("modifyUserAddress");
			this.userService.modifyUser(userID, userName, userGender, userPassword, userEmail, userTelephone, userQQ, userAddress);
			Map infoList=this.userService.userInfo(userEmail);
			session.setAttribute("infoList", infoList);
			request.getRequestDispatcher("userAccount.jsp").forward(request, response);
		}
	}
}
