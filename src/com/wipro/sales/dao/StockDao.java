package com.wipro.sales.dao;

import java.sql.*;

import com.wipro.sales.bean.Product;
import com.wipro.sales.util.DBUtil;

public class StockDao {
	
	static Connection con=DBUtil.getDBConnection();
	static PreparedStatement st;
	public int insertStock(Product sales) 
	{
		int a=0;
		try {
			st=con.prepareStatement("insert into TBL_STOCK values(?,?,?,?,?)");
			st.setString(1,sales.getProductId());
			st.setString(2,sales.getProductName());
			st.setInt(3,sales.getQuantityOnHand());
			st.setDouble(4,sales.getProductUnitPrice());
			st.setInt(5,sales.getReorderLevel());
			a=st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	
	public String generateProductID(String productName)
	{
		
		String productId=productName.substring(0,2);
		try {
			st=con.prepareStatement("select SEQ_PRODUCT_ID.nextval from dual");
			ResultSet rs=st.executeQuery();
			if(rs.next())
			{
				productId=productId+Integer.toString(rs.getInt(1));
			}
			return productId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	
	public int updateStock(String productId, int soldQty)
	{
		int t=0;
		try {
			st=con.prepareStatement("select quantity_on_hand from TBL_STOCK where product_id=?");
			st.setString(1, productId);
			ResultSet rs=st.executeQuery();
			rs.next();
			int newQuantity=rs.getInt("quantity_on_hand")-soldQty;
			st=con.prepareStatement("update TBL_STOCK set quantity_on_hand=? where product_id=?");
			st.setInt(1, newQuantity);
			st.setString(2,productId);
			t=st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	
	public Product getStock(String productId) throws SQLException
	{
		Product obj=new Product();
			st=con.prepareStatement("select * from TBL_STOCK where product_id=?");
			ResultSet rs=st.executeQuery();
			if(rs.next())
			{
				obj.setProductId(rs.getString("product_id"));
				obj.setProductName(rs.getString("product_name"));
				obj.setQuantityOnHand(rs.getInt("quantity_on_hand"));
				obj.setProductUnitPrice(rs.getDouble("product_unit_price"));
				obj.setReorderLevel(rs.getInt("reorder_level"));
			}
		return obj;
	}
	public int deleteStock(String productId)
	{
		int t=0;
		try {
			System.out.println(productId);
			st=con.prepareStatement("delete from TBL_STOCK where product_id=?");
			st.setString(1, productId);
			t=st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		return t;
	}

}
