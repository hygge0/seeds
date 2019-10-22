package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.vo.Emp;

public interface EmpDao {

	public List<Emp> getAll();
	
	public Emp getEmpCheck(@Param("empNo") String empNo,@Param("password") String password);
	
	public List<Map<String,Object>> getAllEmp();
	
	public void deleteEmp(int[] ids);
	
	public void updateEmp(Emp emp);
	
	public void insertEmp(Emp emp);
	
	public Emp selectUpd(int empId);
	
	public List<Emp> getRequestEmp(Map<String,Object> map);
	
	public List<Emp> getEmpByPage(@Param("start") Integer start,@Param("size") Integer size);
}
