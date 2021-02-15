package com.wipro.sales.service;

import java.util.*;
import java.util.Date;
import java.sql.*;
import com.wipro.sales.bean.Product;
import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.dao.SalesDao;
import com.wipro.sales.dao.StockDao;
import com.wipro.sales.util.DBUtil;
public class Administrator {
	
	public String insertStock(Product stockobj)
	{
		StockDao st=new StockDao();
		if(stockobj.getProductName().length()<2)
			return "Length of product name is short, enter again";
		else
		{
			  String m=st.generateProductID(stockobj.getProductName());
				stockobj.setProductId(m);
				if(st.insertStock(stockobj)!=0)
					return "Record created successfully. Product id is "+ m;
				else
					return "Data cannot be inserted as this product already exist";
		}
			
	}
	
	public String deleteStock(String productid)
	{
		StockDao st=new StockDao();
		int a=st.deleteStock(productid);
		if(a!=0)
			return "Record Successfully deleted";
		else
			return "Record cant be deleted";
	}
	
	public String insertSales(Sales salesobj)
	{
		Connection con=DBUtil.getDBConnection();
		PreparedStatement ps;
		SalesDao sad=new SalesDao();
		StockDao std=new StockDao();
		if(salesobj!=null)
		{
			int t=0;
			try {
				ps=con.prepareStatement("select quantity_on_hand from TBL_STOCK where product_id=?");
				ps.setString(1, salesobj.getProductID());
				ResultSet rs=ps.executeQuery();
				int val=0;
				if(rs.next())
					val=rs.getInt("quantity_on_hand");
				t=ps.executeUpdate();
				if(t==0)
					return "Product id doesnot exist";
				else
				{
					if(val<salesobj.getQuantitySold())
						return "Not enough stock on hand for sales";
					else
					{
						Date curr=new Date();
						Date d=salesobj.getSalesDate();
						if(d.compareTo(curr)>0)
							return "Invalid date";
						else
						{
							salesobj.setSalesId(sad.generateSalesID(d));
							if(sad.insertSales(salesobj)!=0)
							{
								if(std.updateStock(salesobj.getProductID(), salesobj.getQuantitySold())!=0)
									return "Sales successfully completed";
								else
									return "Error";
							}
							else
								return "Data cant be inserted";
						}
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
		}
		else
			return "Object not valid for insertion";
	}
	public ArrayList<SalesReport> getSalesReport()
	{
		ArrayList<SalesReport> list=new ArrayList<SalesReport>();
		SalesDao sd=new SalesDao();
		try {
			list=sd.getSalesReport();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	

}
