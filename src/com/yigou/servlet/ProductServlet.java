package com.yigou.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yigou.service.IProductService;
import com.yigou.service.IProductServiceImpl;

/*
 * Author by QinJiangbo 2012302580314
 * 
 *  Date 2014-05-24
 *  
 *  All Rights Reseverd
 *  
 *   Copy is never allowed!
 * */

@SuppressWarnings("rawtypes")
public class ProductServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IProductService productService=new IProductServiceImpl();
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

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// to solve the coding error
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//get the method parameters from the jsp page and judge which function to execute
		String method=request.getParameter("method");
		if(method.equals("query"))
		{
			query(request,response);
		}
		if(method.equals("Subquery"))
		{
			Subquery(request,response);
		}
		if(method.equals("details"))
		{
			showDetails(request,response);
		}
		if(method.equals("queryProduct"))
		{
			queryProduct(request,response);
		}
		if(method.equals("showByPage"))
		{
			showByPage(request,response);
		}
		if(method.equals("addShoppingCart"))
		{
			shoppingCart(request,response);
		}
		if(method.equals("removeProduct"))
		{
			removeProduct(request,response);
		}
		if(method.equals("showMyProducts"))
		{
			showMyProducts(request,response);
		}
		if(method.equals("searchProducts"))
		{
			searchProducts(request,response);
		}
		if(method.equals("emptyShoppingCart"))
		{
			emptyShoppingCart(request,response);
		}
	}
	
	//show the products by page
	private void showByPage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int currentPage;
		int pageSize = 1;
		int pageCount = 0;
		String productID=request.getParameter("detailsProductID");
		if (session.getAttribute("currentPage") == null) {
			currentPage = this.productService.getCurrentPage(pageSize, productID);
			session.setAttribute("currentPage", currentPage);
		} else {
			currentPage = Integer.parseInt(session.getAttribute("currentPage").toString());
		}
		int totalPageCount = this.productService.getRecords();
		if (totalPageCount % pageSize == 0) {
			pageCount = totalPageCount / pageSize;
		} else {
			pageCount = totalPageCount / pageSize + 1;
		}
		String check = request.getParameter("move");
		//go to the previous page
		if (check.equals("previous")) {
			if (currentPage > 0) {
				currentPage = currentPage - 1;
				session.setAttribute("currentPage", currentPage);
				Map productDetails = this.productService.showByPage(currentPage,pageSize)[0];
				request.setAttribute("productDetails", productDetails);
				request.getRequestDispatcher("DetailsOfProduct.jsp").forward(request,response);
			}else
			{
				currentPage=1;
				session.setAttribute("currentPage", currentPage);
				Map productDetails = this.productService.showByPage(currentPage,pageSize)[0];
				request.setAttribute("productDetails", productDetails);
				request.getRequestDispatcher("DetailsOfProduct.jsp").forward(request,response);
			}//go to the next page
		} else if (check.equals("next")) {
			if (currentPage < pageCount) {
				currentPage = currentPage + 1;
				session.setAttribute("currentPage", currentPage);
				Map productDetails = this.productService.showByPage(currentPage,pageSize)[0];
				request.setAttribute("productDetails", productDetails);
				request.getRequestDispatcher("DetailsOfProduct.jsp").forward(request,response);
			}else
			{
				currentPage=pageCount;
				session.setAttribute("currentPage", currentPage);
				Map productDetails = this.productService.showByPage(currentPage,pageSize)[0];
				request.setAttribute("productDetails", productDetails);
				request.getRequestDispatcher("DetailsOfProduct.jsp").forward(request,response);
			}
		} else {
			Map productDetails = this.productService.showByPage(currentPage,pageSize)[0];
			request.setAttribute("productDetails", productDetails);
			request.getRequestDispatcher("DetailsOfProduct.jsp").forward(request, response);
	    }
	}

	//empty the shopping cart
	private void emptyShoppingCart(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String userEmail=session.getAttribute("userEmail").toString();
		this.productService.emptyShoppingCart(userEmail);
		double sum=0.0;
		Map[] shoppingCartList=this.productService.queryShoppingCart(userEmail);
		for(Map row:shoppingCartList)
		{
			sum=sum+Double.parseDouble(row.get("p_price").toString());
		}
		java.text.DecimalFormat df=new java.text.DecimalFormat("#.#");
		session.setAttribute("shoppingCartList", shoppingCartList);
		session.setAttribute("sum", df.format(sum));
		request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
	}

	//search the products by key words in the whole website
	private void searchProducts(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String searchContent=request.getParameter("searchContent");
		Map[] productList=this.productService.searchProducts(searchContent);
		session.setAttribute("productList", productList);
		request.getRequestDispatcher("searchResult.jsp").forward(request, response);
	}

	//dsiplay the customers' own preoducts
	private void showMyProducts(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String userEmail=session.getAttribute("userEmail").toString();
		Map[] shoppingCartList=this.productService.queryShoppingCart(userEmail);
		double sum=0.0;
		for(Map row:shoppingCartList)
		{
			sum=sum+Double.parseDouble(row.get("p_price").toString());
		}
		java.text.DecimalFormat df=new java.text.DecimalFormat("#.#");
		session.setAttribute("shoppingCartList", shoppingCartList);
		session.setAttribute("sum", df.format(sum));
		request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
	}

	//remove the product from the shopping cart
	private void removeProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String userEmail=session.getAttribute("userEmail").toString();
		String time=request.getParameter("time");
		this.productService.removeProduct(time);
		Map[] shoppingCartList=this.productService.queryShoppingCart(userEmail);
		double sum=0.0;
		for(Map row:shoppingCartList)
		{
			sum=sum+Double.parseDouble(row.get("p_price").toString());
		}
		java.text.DecimalFormat df=new java.text.DecimalFormat("#.#");
		session.setAttribute("shoppingCartList", shoppingCartList);
		session.setAttribute("sum", df.format(sum));
		request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
	}

	//go to the shopping cart and get the total money of the preoducts
	private void shoppingCart(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String userEmail=session.getAttribute("userEmail").toString();
		String productID=request.getParameter("productID");
		double sum=0.0;
		this.productService.addShoppingCart(userEmail, productID);
		Map[] shoppingCartList=this.productService.queryShoppingCart(userEmail);
		for(Map row:shoppingCartList)
		{
			sum=sum+Double.parseDouble(row.get("p_price").toString());
		}
		java.text.DecimalFormat df=new java.text.DecimalFormat("#.#");
		session.setAttribute("shoppingCartList", shoppingCartList);
		session.setAttribute("sum", df.format(sum));
		request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
	}

	//query the products by category
	private void queryProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String category=request.getParameter("category");
		Map[] List=productService.queryProduct(category);
		request.setAttribute("category", category);
		session.setAttribute("List", List);
		request.getRequestDispatcher("Product.jsp").forward(request, response);
	}

	//sub query show the products in the index page by category
	private void Subquery(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		Map[] BookList=productService.Subquery("Book");
		session.setAttribute("BookList", BookList);
		Map[] ClothesList=productService.Subquery("Clothes");
		session.setAttribute("ClothesList", ClothesList);
		Map[] DailyDealsList=productService.Subquery("DailyDeals");
		session.setAttribute("DailyDealsList", DailyDealsList);
		Map[] ElectronicsList=productService.Subquery("Electronics");
		session.setAttribute("ElectronicsList", ElectronicsList);
		Map[] HomesList=productService.Subquery("Homes");
		session.setAttribute("HomesList", HomesList);
		Map[] MotorsList=productService.Subquery("Motors");
		session.setAttribute("MotorsList", MotorsList);
		Map[] SportsGoodsList=productService.Subquery("Sports Goods");
		session.setAttribute("SportsGoodsList", SportsGoodsList);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	//get the products and show them in the index page
	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map[] productList=productService.query();
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	//show the details of each product
	private void showDetails(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.removeAttribute("currentPage");
		String productID=request.getParameter("productID");
		Map productDetails=productService.Details(productID);
		session.setAttribute("productDetails", productDetails);
		request.getRequestDispatcher("DetailsOfProduct.jsp").forward(request, response);
	}

}
