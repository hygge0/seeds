package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.EmpService;
import com.service.MessageService;
import com.vo.Emp;
import com.vo.ReceiveMessage;
import com.vo.SendMessage;

/**
 * Servlet implementation class GetReceiveMessageInfo
 */
@WebServlet("/files/GetSendMessageInfo")
public class GetSendMessageInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSendMessageInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("sendId");
		Integer sendId=Integer.valueOf(id);
		
		MessageService ms=new MessageService();
		SendMessage send=ms.getSendMessageInfo(sendId);
		request.setAttribute("send", send);
		request.getRequestDispatcher("checkSendMessage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
