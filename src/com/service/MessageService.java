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
	//��������Ϣ
	public List<SendMessage> getSendInfo(Integer empId){
		List<SendMessage> list=new ArrayList<SendMessage>();
		try(SqlSession session=MybatisUtil.openSession()){
			SendMessageDao sdao=session.getMapper(SendMessageDao.class);
			list=sdao.getSendInfo(empId);
		}
		return list;
	}
	//�ռ�����Ϣ
	public List<Map<String,Object>> getReceiveInfo(Integer empId){
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		try(SqlSession session=MybatisUtil.openSession()){
			ReceiveMessageDao rdao=session.getMapper(ReceiveMessageDao.class);
			list=rdao.getReceiveInfo(empId);
		}
		return list;
	}
	//��empIdΪ����ɾ��receive�еļ�¼
	public void deleteRMessage(int[] empId) {
		try(SqlSession session=MybatisUtil.openSession()){
			ReceiveMessageDao rdao=session.getMapper(ReceiveMessageDao.class);
			rdao.deleteRMessage(empId);
			session.commit();
		}
	}
	
	//ɾ��send��ļ�¼ ��sendidΪ����
		public void deleteSendMessage(int[] empId) {
			
			try(SqlSession session=MybatisUtil.openSession()){
				SendMessageDao sdao=session.getMapper(SendMessageDao.class);
				sdao.deleteSEmp(empId);
				session.commit();
		 }
		}
	//ɾ��send��ļ�¼ ��sendidΪ����
	public void deleteSMessage(int sendId) {
		
		try(SqlSession session=MybatisUtil.openSession()){
			SendMessageDao sdao=session.getMapper(SendMessageDao.class);
			sdao.deleteSMessage(sendId);
			session.commit();
	 }
	}
	
	//ɾ��receive��ļ�¼ ��receiveidΪ����
		public void deleteRMessage(int receiveId) {
			
			try(SqlSession session=MybatisUtil.openSession()){
				ReceiveMessageDao rdao=session.getMapper(ReceiveMessageDao.class);
				rdao.deleteOneReceive(receiveId);
				session.commit();
		 }
		}
	
	
	//��receive�������sendid��empIdΪ����
	public List<ReceiveMessage> getSendId(int[] empId){
		List<ReceiveMessage> list=new ArrayList<ReceiveMessage>();
		try(SqlSession session=MybatisUtil.openSession()){
			ReceiveMessageDao rdao=session.getMapper(ReceiveMessageDao.class);
			list=rdao.getSendId(empId);
		}
		return list;
	}
	//��send������empIdΪ����ɾ����¼
	public void deleteSEmp(int[] empId) {
		try(SqlSession session=MybatisUtil.openSession()){
			SendMessageDao sdao=session.getMapper(SendMessageDao.class);
			sdao.deleteSEmp(empId);
			session.commit();
	 }

	}
	//�޸��ռ���Ϣ״̬
	public void updateRMG(int[] id) {
		try(SqlSession session=MybatisUtil.openSession()){
			ReceiveMessageDao rdao=session.getMapper(ReceiveMessageDao.class);
			rdao.updateRM(id);
			session.commit();
		}
	}
	//�޸ķ�����Ϣ״̬
		public void updateSMG(int[] id) {
			try(SqlSession session=MybatisUtil.openSession()){
				SendMessageDao sdao=session.getMapper(SendMessageDao.class);
				sdao.updateSM(id);
				session.commit();
			}
		}
		//�鿴receive����Ϣ
		public ReceiveMessage getReceiveMessageInfo(int receiveId) {
			ReceiveMessage rm=null;
			try(SqlSession session=MybatisUtil.openSession()){
				ReceiveMessageDao rdao=session.getMapper(ReceiveMessageDao.class);
				rdao.getRMI(receiveId);
			}
			return rm;
		}
		//�鿴send����Ϣ
		public SendMessage getSendMessageInfo(int sendId) {
			SendMessage sm=null;
			try(SqlSession session=MybatisUtil.openSession()){
				SendMessageDao sdao=session.getMapper(SendMessageDao.class);
				sdao.getSMI(sendId);
			}
			return sm;
		}
}
	
