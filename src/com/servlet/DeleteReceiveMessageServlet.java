package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.EmpService;
import com.service.MessageService;

/**
 * Servlet implementation class DeleteReceiveMessageServlet
 */
@WebServlet("/files/DeleteReceiveMessageServlet")
public class DeleteReceiveMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReceiveMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String[] sids=request.getParameterValues("id");
		
		int[] ids=new int[sids.length];
		
	
		for(int i=0;i<ids.length;i++) {
			ids[i]=Integer.valueOf(sids[i]);
		}
		System.out.println("²âÊÔ"+ids.length);
		//É¾³ý
		MessageService ms=new MessageService();
		
		ms.updateRMG(ids);
		
		response.sendRedirect("GetReceiveInfoServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
