package com.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.EmpService;
import com.vo.Emp;

/**
 * Servlet implementation class UpdateEmpServlet
 */
@WebServlet("/files/AddEmpServlet")
public class AddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
        String empNo=null;
		String password=request.getParameter("password");
		String empName=request.getParameter("empName");
		String sex=request.getParameter("sex");
		String sbirth=request.getParameter("birth");
		System.out.println("sbirth≤‚ ‘£∫"+sbirth+"≥§∂»£∫"+sbirth.length());
		Date birth=null;
		if(sbirth=="") {
			System.out.println("birth if≤‚ ‘£∫"+birth);
			
			System.out.println("birth if≤‚ ‘£∫"+birth);
		}else {
			birth=Date.valueOf(sbirth);
		}
		System.out.println("birth≤‚ ‘£∫"+birth);
		String idCard=request.getParameter("idCard");
		String email=request.getParameter("email");
		String tel=request.getParameter("tel");
		String address=request.getParameter("address");
		String position=request.getParameter("position");
		String empType=request.getParameter("empType");
		String bankNo=request.getParameter("bankNo");
		String bankName=request.getParameter("bankName");
		String ssal=request.getParameter("sal");
		Integer sal=0;
		if(ssal!="") {
			sal=Integer.valueOf(ssal);
		}	
		String scomm=request.getParameter("comm");
		Integer comm=0;
		if(scomm!="") {
			comm=Integer.valueOf(scomm);
		}
		String ssubsidy=request.getParameter("subsidy");
		Integer subsidy=0;
		if(ssubsidy!="") {
			subsidy=Integer.valueOf(ssubsidy);
		}
		String shiredate=request.getParameter("hiredate");
		Date hiredate=null;
		if(shiredate=="") {
		  hiredate=null;
		}else {
			hiredate=Date.valueOf(shiredate);
		}
		String descript=request.getParameter("descript");
		
		Emp emp=new Emp();

		emp.setEmpNo(empNo);
		emp.setPassword(password);
		emp.setEmpName(empName);
		emp.setSex(sex);
		emp.setBirth(birth);
		emp.setIdCard(idCard);
		emp.setEmail(email);
		emp.setTel(tel);
		emp.setAddress(address);
		emp.setPosition(position);
		emp.setEmpType(empType);
		emp.setBankNo(bankNo);
		emp.setBankName(bankName);
		emp.setSal(sal);
		emp.setComm(comm);
		emp.setSubsidy(subsidy);
		emp.setHiredate(hiredate);
		emp.setDescript(descript);
		
		EmpService service=new EmpService();
		service.insertEmp(emp);
		
		response.sendRedirect("GetAllEmpServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
