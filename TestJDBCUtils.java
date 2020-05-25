package com.kgc.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;


public class TestJDBCUtils {

	@Test
	public void tesResultSetNew() {
		// 定义数据库连接对象
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 获取数据库连接
			conn = JDBCUtils.getConnection();
			
			// 获取数据库操作对象
			stmt = conn.createStatement();
			
			// 准备执行查询sql
			String sql = "select stu_no,stu_name,stu_pwd,sex,phone,birthday from students where grade_id = 3";
			
			// 执行查询，获取结果集
			rs = stmt.executeQuery(sql);
			
			// 处理结果集,如果没有查询到结果，rs.next返回false
			while(rs.next()){
				System.out.println("Student [" + rs.getInt(1) + "," 
						+ rs.getString(2)  + "," +  rs.getString(3) 
						+ "," +  rs.getString(4)  + "," +  rs.getString(5) 
						+ "," + rs.getTimestamp(6) + "]");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.releaseJdbc(rs, stmt, conn);
		}
	}

}
