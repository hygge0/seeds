package com.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MessageService;
import com.vo.Emp;
import com.vo.SendMessage;

/**
 * Servlet implementation class SendMessageServlet
 */
@WebServlet("/files/SendMessageServlet")
public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//response.setCharacterEncoding("text/html;charset=UTF-8");
		//get
		String messageTitle=request.getParameter("messageTitle");
		String messageContent=request.getParameter("messageContent");
		String priority=request.getParameter("priority");
		String[] sids=request.getParameterValues("empId"); 
		
		//String[] sids=empId.split(",");
		System.out.println(Arrays.toString(sids));
		Integer[] ids=new Integer[sids.length];
		for(int i=0;i<ids.length;i++) {
			ids[i]=Integer.valueOf(sids[i]);
		}
		
		SendMessage smessage=new SendMessage();
		
		Emp emp=(Emp)request.getSession().getAttribute("emp");
		smessage.setEmpId(emp.getEmpId());
		smessage.setMessageTitle(messageTitle);
		smessage.setMessageContent(messageContent);
		smessage.setPriority(Integer.valueOf(priority));
		
		MessageService mservice=new MessageService();
		mservice.sendMessage(smessage, ids);
		
		response.sendRedirect("GetSendInfoServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
