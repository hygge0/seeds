package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dao.EmpDao;
import com.dao.MybatisUtil;
import com.vo.Emp;

public class EmpService {

	public List<Emp> getAll(){
		List<Emp> list=new ArrayList<Emp>();
		
		try(SqlSession session=MybatisUtil.openSession()){
			EmpDao dao=session.getMapper(EmpDao.class);
			list=dao.getAll();
		}
		return list;
	}
	
	public Emp login(String empNo,String password) {
		Emp emp=null;
		try(SqlSession session=MybatisUtil.openSession()){
			EmpDao dao=session.getMapper(EmpDao.class);
			emp=dao.getEmpCheck(empNo, password);
		}
		return emp;
	}
	
	public List<Map<String,Object>> getAllEmp(){
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		try(SqlSession session=MybatisUtil.openSession()){
			EmpDao dao=session.getMapper(EmpDao.class);
			list=dao.getAllEmp();
		}
		return list;
	}
	//ɾ��
	public void DeleteEmp(int[] ids) {
		try(SqlSession session=MybatisUtil.openSession()){
			EmpDao dao=session.getMapper(EmpDao.class);
			dao.deleteEmp(ids);
			session.commit();
		}
	}
	//�޸�
	public void UpdateEmp(Emp emp) {
		try(SqlSession session=MybatisUtil.openSession()){
			EmpDao dao=session.getMapper(EmpDao.class);
			dao.updateEmp(emp);
			session.commit();
		}
	}
	//����
	public void insertEmp(Emp emp) {
		try(SqlSession session=MybatisUtil.openSession()){
			EmpDao dao=session.getMapper(EmpDao.class);
			dao.insertEmp(emp);
			session.commit();
		}
	}
	//��ѯ�޸�Ա������Ϣ
	public Emp getUpdateInfo(int empId) {
		Emp emp=null;
		try(SqlSession session=MybatisUtil.openSession()){
			EmpDao dao=session.getMapper(EmpDao.class);
			emp=dao.selectUpd(empId);		
		}
		return emp;
	}
	//��������ѯ
	public List<Emp> getRequestEmp(Map<String,Object> map){
		List<Emp> list=null;
		try(SqlSession session=MybatisUtil.openSession()){
			EmpDao dao=session.getMapper(EmpDao.class);
			list=dao.getRequestEmp(map);
		}
		
		return list;
	}
	//��ҳ
	public List<Emp> getEmpByPage(int start,int size){
		List<Emp> list=new ArrayList<Emp>();
		try(SqlSession session=MybatisUtil.openSession()){
			EmpDao dao=session.getMapper(EmpDao.class);
			dao.getEmpByPage(start, size);
		}
		return list;
	}
}
