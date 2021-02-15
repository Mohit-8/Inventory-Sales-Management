package com.wipro.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.util.DBUtil;
import java.util.*;

public class SalesDao {
	
	static Connection con=DBUtil.getDBConnection();
	static PreparedStatement st;
	public int insertSales(Sales sales) 
	{
		int a=0;
		try {
			java.sql.Date sql=new java.sql.Date(sales.getSalesDate().getTime());
			st=con.prepareStatement("insert into TBL_SALES values(?,?,?,?,?)");
			st.setString(1,sales.getSalesId());
			st.setDate(2,sql);
			st.setString(3,sales.getProductID());
			st.setInt(4,sales.getQuantitySold());
			st.setDouble(5,sales.getSalesPricePerUnit());
			a=st.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	public String generateSalesID(java.util.Date salesDate)
	{
		int year=1900+salesDate.getYear();
		String salesId=Integer.toString(year).substring(2);
		try {
			st=con.prepareStatement("select SEQ_SALES_ID.nextval from dual");
			ResultSet rs=st.executeQuery();
			if(rs.next())
			{
				salesId=salesId.concat(Integer.toString(rs.getInt(1)));
			}
			return salesId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public ArrayList<SalesReport> getSalesReport() throws SQLException
	{
		
		ArrayList<SalesReport> list=new ArrayList<SalesReport>();
			st=con.prepareStatement("select * from V_SALES_REPORT");
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				SalesReport sr=new SalesReport();
				sr.setProductId(rs.getString("product_id"));
				sr.setProductName(rs.getString("product_name"));
				sr.setProductUnitPrice(rs.getDouble("product_unit_price"));
				sr.setQuantitySold(rs.getInt("quantity_sold"));
				sr.setSalesDate(rs.getDate("sales_date"));
				sr.setSalesId(rs.getString("sales_id"));
				sr.setSalesPricePerUnit(rs.getDouble("sales_price_per_unit"));
				sr.setProfitAmount(rs.getDouble("profit_amount"));
				list.add(sr);
			}
			return list;
	}

}
