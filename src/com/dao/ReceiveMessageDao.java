package com.dao;

import com.vo.SendMessage;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.vo.ReceiveMessage;

public interface ReceiveMessageDao {

	public void insert(ReceiveMessage message);
	
	public List<Map<String,Object>> getReceiveInfo(@Param("empId") Integer empId);
	
	public void deleteMessage(ReceiveMessage message);
	
	public void deleteRMessage(int[] empId);
	
	public List<ReceiveMessage> getSendId(int[] empId);
	
	public void updateRM(int[] Id);
	
	public ReceiveMessage getRMI(int receiveId);
	
	public void deleteOneReceive(int receiveId);
}
