package com.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.EmpService;
import com.service.MessageService;
import com.vo.ReceiveMessage;

/**
 * Servlet implementation class DeleteEmpServlet
 */
@WebServlet("/files/DeleteEmpServlet")
public class DeleteEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] sids=request.getParameterValues("empid");
		
		int[] ids=new int[sids.length];
		
	
		for(int i=0;i<ids.length;i++) {
			ids[i]=Integer.valueOf(sids[i]);
		}
		System.out.println("²âÊÔ"+ids.length);
		//É¾³ý
		MessageService ms=new MessageService();
		
		//List<ReceiveMessage> list=ms.getSendId(ids);
		ms.deleteRMessage(ids);
		
//		for(ReceiveMessage rm:list) {
//			ms.deleteSMessage(rm.getSendId());
//		}
		ms.deleteSEmp(ids);
		
		EmpService service=new EmpService();
		service.DeleteEmp(ids);
		
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
