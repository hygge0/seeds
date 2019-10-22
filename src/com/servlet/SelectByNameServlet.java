package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.EmpService;
import com.vo.Emp;

/**
 * Servlet implementation class SelectByNameServlet
 */
@WebServlet("/files/SelectByNameServlet")
public class SelectByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectByNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String empName=request.getParameter("name_sel");
		
		EmpService service=new EmpService();
		List<Emp> list=new ArrayList<Emp>();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("empName", empName);
		
		list=service.getRequestEmp(map);
		request.setAttribute("name_sel", empName);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("EmpInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
