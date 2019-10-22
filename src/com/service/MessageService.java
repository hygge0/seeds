package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.dao.MybatisUtil;
import com.dao.ReceiveMessageDao;
import com.dao.SendMessageDao;
import com.vo.ReceiveMessage;
import com.vo.SendMessage;

public class MessageService {

	public void sendMessage(SendMessage message,Integer[] emps) {
		try(SqlSession session=MybatisUtil.openSession()){
			SendMessageDao sdao=session.getMapper(SendMessageDao.class);
			ReceiveMessageDao rdao=session.getMapper(ReceiveMessageDao.class);
			
			sdao.insert(message);
			
			for(Integer i:emps) {
				ReceiveMessage rmessage=new ReceiveMessage();
				rmessage.setSendId(message.getSendId());
				rmessage.setEmpId(i);
				rdao.insert(rmessage);
			}
			session.commit();
		}
	}
	//发件箱信息
	public List<SendMessage> getSendInfo(Integer empId){
		List<SendMessage> list=new ArrayList<SendMessage>();
		try(SqlSession session=MybatisUtil.openSession()){
			SendMessageDao sdao=session.getMapper(SendMessageDao.class);
			list=sdao.getSendInfo(empId);
		}
		return list;
	}
	//收件箱消息
	public List<Map<String,Object>> getReceiveInfo(Integer empId){
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		try(SqlSession session=MybatisUtil.openSession()){
			ReceiveMessageDao rdao=session.getMapper(ReceiveMessageDao.class);
			list=rdao.getReceiveInfo(empId);
		}
		return list;
	}
	//以empId为索引删除receive中的记录
	public void deleteRMessage(int[] empId) {
		try(SqlSession session=MybatisUtil.openSession()){
			ReceiveMessageDao rdao=session.getMapper(ReceiveMessageDao.class);
			rdao.deleteRMessage(empId);
			session.commit();
		}
	}
	
	//删除send表的记录 以sendid为索引
		public void deleteSendMessage(int[] empId) {
			
			try(SqlSession session=MybatisUtil.openSession()){
				SendMessageDao sdao=session.getMapper(SendMessageDao.class);
				sdao.deleteSEmp(empId);
				session.commit();
		 }
		}
	//删除send表的记录 以sendid为索引
	public void deleteSMessage(int sendId) {
		
		try(SqlSession session=MybatisUtil.openSession()){
			SendMessageDao sdao=session.getMapper(SendMessageDao.class);
			sdao.deleteSMessage(sendId);
			session.commit();
	 }
	}
	
	//删除receive表的记录 以receiveid为索引
		public void deleteRMessage(int receiveId) {
			
			try(SqlSession session=MybatisUtil.openSession()){
				ReceiveMessageDao rdao=session.getMapper(ReceiveMessageDao.class);
				rdao.deleteOneReceive(receiveId);
				session.commit();
		 }
		}
	
	
	//在receive表里查找sendid以empId为索引
	public List<ReceiveMessage> getSendId(int[] empId){
		List<ReceiveMessage> list=new ArrayList<ReceiveMessage>();
		try(SqlSession session=MybatisUtil.openSession()){
			ReceiveMessageDao rdao=session.getMapper(ReceiveMessageDao.class);
			list=rdao.getSendId(empId);
		}
		return list;
	}
	//在send表中以empId为索引删除记录
	public void deleteSEmp(int[] empId) {
		try(SqlSession session=MybatisUtil.openSession()){
			SendMessageDao sdao=session.getMapper(SendMessageDao.class);
			sdao.deleteSEmp(empId);
			session.commit();
	 }

	}
	//修改收件信息状态
	public void updateRMG(int[] id) {
		try(SqlSession session=MybatisUtil.openSession()){
			ReceiveMessageDao rdao=session.getMapper(ReceiveMessageDao.class);
			rdao.updateRM(id);
			session.commit();
		}
	}
	//修改发件信息状态
		public void updateSMG(int[] id) {
			try(SqlSession session=MybatisUtil.openSession()){
				SendMessageDao sdao=session.getMapper(SendMessageDao.class);
				sdao.updateSM(id);
				session.commit();
			}
		}
		//查看receive表信息
		public ReceiveMessage getReceiveMessageInfo(int receiveId) {
			ReceiveMessage rm=null;
			try(SqlSession session=MybatisUtil.openSession()){
				ReceiveMessageDao rdao=session.getMapper(ReceiveMessageDao.class);
				rdao.getRMI(receiveId);
			}
			return rm;
		}
		//查看send表信息
		public SendMessage getSendMessageInfo(int sendId) {
			SendMessage sm=null;
			try(SqlSession session=MybatisUtil.openSession()){
				SendMessageDao sdao=session.getMapper(SendMessageDao.class);
				sdao.getSMI(sendId);
			}
			return sm;
		}
}
	
