package com.techpalle;

import java.sql.*;
import java.util.ArrayList;

public class Reading
{
	private static final String url = "jdbc:mysql://localhost:3306/jdbc";
	private static final String username = "root";
	private static final String password = "admin";
	
	private static Connection con = null;
	private static Statement s = null;
	private static PreparedStatement ps = null;
	
	private static ResultSet rs = null;
	
	public static ArrayList<Department> getAllTableData()
	{
		ArrayList<Department> alDept = new ArrayList<Department>();
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			
			s = con.createStatement();
			
			rs = s.executeQuery("select * from dept");
			
			
			while (rs.next()) 
			{
				int id = rs.getInt("dno");
				String name = rs.getString("dname");
				String location = rs.getString("dlocation");
				int strength = rs.getInt("dstrength");
				
				Department d = new Department(id, name, location, strength);
				alDept.add(d);
			}                                                                            
			
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(rs != null) {
					rs.close();
				}
				if(s != null) {
					s.close();
				}
				if(con != null) {
					con.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return alDept;
	}
	
	
	// 1st approach:
	public static void f1()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			
			String qry = "select dname from dept";
			s = con.createStatement();			
			rs = s.executeQuery(qry);
			
			while(rs.next()) 
			{
				System.out.println(rs.getString("dname"));
			}
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e){
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(rs != null) {
					rs.close();
				}
				if(s != null) {
					s.close();
				}
				if(con != null) {
					con.close();
				}	
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	
	}
	
	// Req:
	/*
	 * create a method to retrieve all the columns and rows present in 
	 * dept table based on dno:
	 */
	public static Department getAllTableData(int no) 
	{
		Department d = null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			
			String qry = "select * from dept where dno = ?";
			ps = con.prepareStatement(qry);
			ps.setInt(1, no);
			
			rs = ps.executeQuery();
			
			rs.next();
			
			int i = rs.getInt("dno");
			String n = rs.getString("dname");
			String l = rs.getString("dlocation");
			int s = rs.getInt("dstrength");
				
			d = new Department(i, n, l, s);
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try 
			{
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return d;
	}
}
