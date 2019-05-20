package com.sapiens.dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.*;

import com.sapiens.customer.customer;
import com.sapiens.utils.DBUtils;

public class InsDao implements Closeable {
	private PreparedStatement stateselect, stateInsert,searchname,searchid;
	public InsDao() throws Exception {
		Connection connection = DBUtils.getConnection();
		this.stateselect = connection.prepareStatement("select * from Customer");
		this.stateInsert = connection.prepareStatement("insert into Customer(name,address,role) values(?,?,?)");
		this.searchname = connection.prepareStatement("select * from Customer where name = ?");
		this.searchid = connection.prepareStatement("select * from Customer where id = ?");
	}
	
	public int insert (customer customer) throws Exception
	{
		stateInsert.setString(1, customer.getName());
		stateInsert.setString(2, customer.getAddress());
		stateInsert.setString(3, customer.getRole());
		return stateInsert.executeUpdate();
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public customer searchByName(String name) throws Exception {
		searchname.setString(1, name);
		ResultSet rs = searchname.executeQuery();
		if(rs.next()) {
			customer cust = new customer();
			cust.setId(rs.getInt("id"));
			cust.setName(rs.getString("name"));
			cust.setAddress(rs.getString("address"));
			cust.setRole(rs.getString("role"));
			return cust;	
		}
		else
			return null;
	}

	public customer searchById(int id) throws Exception {
		// TODO Auto-generated method stub
		searchname.setInt(1, id);
		ResultSet rs = searchid.executeQuery();
		if(rs.next()) {
			customer cust = new customer();
			cust.setId(rs.getInt("id"));
			cust.setName(rs.getString("name"));
			cust.setAddress(rs.getString("address"));
			cust.setRole(rs.getString("role"));
			return cust;	
		}
		else
			return null;
	}
}
