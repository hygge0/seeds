package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vo.ReceiveMessage;
import com.vo.SendMessage;

public interface SendMessageDao {

	public void insert(SendMessage message);
	
	public List<SendMessage> getSendInfo(@Param("empId") Integer empId);
	
	public void deleteSMessage(int sendId);
	
	public void deleteSEmp(int[] empId);
	
	public void updateSM(int[] Id);
	
	public SendMessage getSMI(int sendId);
	
	public void deleteOneReceive(int receiveId);
}
