package com.wipro.sales.main;

import com.wipro.sales.service.*;
import java.util.*;
import com.wipro.sales.bean.*;
import com.wipro.sales.dao.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Window;
import javax.swing.*;
import com.toedter.calendar.*;
import java.awt.Color;
import java.awt.SystemColor;

public class SalesApplication extends JFrame implements ActionListener{

	JFrame f;
	private JPanel contentPane;
	static JRadioButton rdbtnInsertStock,rdbtnDeleteStock,rdbtnInsertSales,rdbtnViewSalesReport;
	private JTextField textField;
	JLabel lblNewLabel,lblProductName,lblQuantity,lblProductUnitPrice,lblReorderLevel,lblProductId,lblDate,lblQunatitySold,lblSalesPricePer;
	JButton btnNewButton,btnNewButton_1,btnNewButton_2;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_8;
	JDateChooser dateChooser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesApplication frame = new SalesApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SalesApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		////////////////////////////////////////////Radio buttons///////////////////////////////////////////////////////////////////////////////
		rdbtnInsertStock = new JRadioButton("Insert Stock");
		rdbtnInsertStock.setBounds(22, 22, 118, 52);
		rdbtnInsertStock.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(rdbtnInsertStock);
		
		rdbtnDeleteStock = new JRadioButton("Delete Stock");
		rdbtnDeleteStock.setBounds(22, 57, 118, 52);
		rdbtnDeleteStock.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(rdbtnDeleteStock);
		
		rdbtnInsertSales = new JRadioButton("Insert Sales");
		rdbtnInsertSales.setBounds(22, 94, 118, 52);
		rdbtnInsertSales.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(rdbtnInsertSales);
		
		rdbtnViewSalesReport = new JRadioButton("View Sales Report");
		rdbtnViewSalesReport.setBounds(22, 132, 152, 52);
		rdbtnViewSalesReport.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(rdbtnViewSalesReport);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnInsertStock);
		bg.add(rdbtnDeleteStock);
		bg.add(rdbtnInsertSales);
		bg.add(rdbtnViewSalesReport);
		
		rdbtnInsertStock.addActionListener(this);
		rdbtnDeleteStock.addActionListener(this);
		rdbtnInsertSales.addActionListener(this);
		rdbtnViewSalesReport.addActionListener(this);
		
		/////////////////////////////////////////////////////////////////Insert Stock///////////////////////////////////////////////////////////////////////////
		lblProductName = new JLabel("Product Name:");
		lblProductName.setBounds(32, 204, 123, 25);
		lblProductName.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		contentPane.add(lblProductName);
		lblProductName.setVisible(false);
		
		lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(32, 247, 123, 25);
		lblQuantity.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		contentPane.add(lblQuantity);
		lblQuantity.setVisible(false);
		
		lblProductUnitPrice = new JLabel("Product Unit Price:");
		lblProductUnitPrice.setBounds(32, 294, 142, 25);
		lblProductUnitPrice.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		contentPane.add(lblProductUnitPrice);
		lblProductUnitPrice.setVisible(false);
		
		lblReorderLevel = new JLabel("Reorder Level:");
		lblReorderLevel.setBounds(32, 342, 123, 25);
		lblReorderLevel.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		contentPane.add(lblReorderLevel);
		lblReorderLevel.setVisible(false);
		
		textField_1 = new JTextField();
		textField_1.setBounds(187, 205, 159, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setVisible(false);
		
		textField_2 = new JTextField();
		textField_2.setBounds(187, 250, 159, 25);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		textField_2.setVisible(false);
		
		textField_3 = new JTextField();
		textField_3.setBounds(187, 297, 159, 25);
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		textField_3.setVisible(false);
		
		textField_4 = new JTextField();
		textField_4.setBounds(187, 345, 159, 25);
		textField_4.setColumns(10);
		contentPane.add(textField_4);
		textField_4.setVisible(false);
		
		btnNewButton_1 = new JButton("Insert");
		btnNewButton_1.setBounds(170, 395, 99, 27);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setVisible(false);
		
		
		////////////////////////////////////////////////////////////////////For delete stock/////////////////////////////////////////////////////////////////
	    lblNewLabel = new JLabel("Enter the product id of item to delete");
	    lblNewLabel.setBounds(32, 191, 290, 32);
		lblNewLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(34, 234, 128, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		
		btnNewButton = new JButton("Delete");
		btnNewButton.setBounds(171, 283, 101, 35);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(btnNewButton);
		btnNewButton.setVisible(false);
		
		/////////////////////////////////////////////////////////////////////Insert Sales//////////////////////////////////////////////////////////////////////////////////
		lblProductId = new JLabel("Product Id:");
		lblProductId.setBounds(32, 193, 97, 24);
		lblProductId.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		contentPane.add(lblProductId);
		lblProductId.setVisible(false);
		
		lblDate = new JLabel("Date:");
		lblDate.setBounds(32, 233, 97, 24);
		lblDate.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		contentPane.add(lblDate);
		lblDate.setVisible(false);
		
		lblQunatitySold = new JLabel("Qunatity Sold:");
		lblQunatitySold.setBounds(32, 276, 108, 24);
		lblQunatitySold.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		contentPane.add(lblQunatitySold);
		lblQunatitySold.setVisible(false);
		
		lblSalesPricePer = new JLabel("Sales Price per unit:");
		lblSalesPricePer.setBounds(32, 322, 152, 24);
		lblSalesPricePer.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		contentPane.add(lblSalesPricePer);
		lblSalesPricePer.setVisible(false);
		
		
		textField_5 = new JTextField();
		textField_5.setBounds(197, 193, 141, 24);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		textField_5.setVisible(false);
		
		textField_7 = new JTextField();
		textField_7.setBounds(197, 279, 141, 24);
		textField_7.setColumns(10);
		contentPane.add(textField_7);
		textField_7.setVisible(false);
		
		textField_8 = new JTextField();
		textField_8.setBounds(197, 325, 141, 24);
		textField_8.setColumns(10);
		contentPane.add(textField_8);
		textField_8.setVisible(false);
		
		btnNewButton_2 = new JButton("Insert");
		btnNewButton_2.setBounds(165, 376, 108, 27);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setVisible(false);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(197, 237, 141, 24);
		contentPane.add(dateChooser);
		dateChooser.setVisible(false);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		Administrator ad=new Administrator();
		Product pd=new Product();
		Sales sl=new Sales();
		if(rdbtnInsertStock.isSelected())
		{
			lblProductName.setVisible(true);
			lblQuantity.setVisible(true);
			lblProductUnitPrice.setVisible(true);
			lblReorderLevel.setVisible(true);
			textField_1.setVisible(true);
			textField_2.setVisible(true);
			textField_3.setVisible(true);
			textField_4.setVisible(true);
			btnNewButton_1.setVisible(true);
			
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					if(textField_1.getText().length()!=0 && textField_2.getText().length()!=0 &&
							textField_3.getText().length()!=0 && textField_4.getText().length()!=0)
					{
						pd.setProductName(textField_1.getText());
						pd.setQuantityOnHand(Integer.parseInt(textField_2.getText()));
						try
						{
							pd.setProductUnitPrice(Double.parseDouble(textField_3.getText()));
						}
						catch(Exception e1)
						{}
						pd.setReorderLevel(Integer.parseInt(textField_4.getText()));
						String s=ad.insertStock(pd);
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						JOptionPane.showMessageDialog(f,s);
					
					}
					else
						JOptionPane.showMessageDialog(f,"Please enter a value","Alert",JOptionPane.WARNING_MESSAGE);
				}
			});
			
		}
		else
		{
			lblProductName.setVisible(false);
			lblQuantity.setVisible(false);
			lblProductUnitPrice.setVisible(false);
			lblReorderLevel.setVisible(false);
			textField_1.setVisible(false);
			textField_2.setVisible(false);
			textField_3.setVisible(false);
			textField_4.setVisible(false);
			btnNewButton_1.setVisible(false);
		}
		
		if(rdbtnDeleteStock.isSelected())
		{
			lblNewLabel.setVisible(true);
			textField.setVisible(true);
			btnNewButton.setVisible(true);
			btnNewButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if(textField.getText().length()==0)
						JOptionPane.showMessageDialog(f,"Please enter a value","Alert",JOptionPane.WARNING_MESSAGE);
					else
					{
						JOptionPane.showMessageDialog(f,ad.deleteStock(textField.getText()));
						textField.setText("");
					}
				}   
			});
		}
		else
		{
			lblNewLabel.setVisible(false);
			textField.setVisible(false);
			btnNewButton.setVisible(false);
		}
		
		if(rdbtnInsertSales.isSelected())
		{
			lblProductId.setVisible(true);
			lblDate.setVisible(true);
			lblQunatitySold.setVisible(true);
			lblSalesPricePer.setVisible(true);
			textField_5.setVisible(true);
			textField_7.setVisible(true);
			textField_8.setVisible(true);
			dateChooser.setVisible(true);
			btnNewButton_2.setVisible(true);
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					
					if(textField_5.getText().length()!=0 && textField_7.getText().length()!=0 &&
							textField_8.getText().length()!=0  && dateChooser.getDate()!=null)
					{
						sl.setProductID(textField_5.getText());
						sl.setSalesDate(dateChooser.getDate());
						sl.setQuantitySold(Integer.parseInt(textField_7.getText()));
						try
						{
							sl.setSalesPricePerUnit(Double.parseDouble(textField_8.getText()));
						}
						catch(Exception e2) {}
						JOptionPane.showMessageDialog(f,ad.insertSales(sl));
						textField_5.setText("");textField_7.setText("");textField_8.setText("");
						dateChooser.setDate(null);
					}
					else
						JOptionPane.showMessageDialog(f,"Please enter a value","Alert",JOptionPane.WARNING_MESSAGE);
				}
			});
			
		}
		else
		{
			lblProductId.setVisible(false);
			lblDate.setVisible(false);
			lblQunatitySold.setVisible(false);
			lblSalesPricePer.setVisible(false);
			textField_5.setVisible(false);
			textField_7.setVisible(false);
			textField_8.setVisible(false);
			dateChooser.setVisible(false);
			btnNewButton_2.setVisible(false);
		}
		if(rdbtnViewSalesReport.isSelected())
		{
			ArrayList<SalesReport> list=new ArrayList<SalesReport>();
			list=ad.getSalesReport();
			
			JFrame j=new JFrame();
			j.setVisible(true);
			j.getContentPane().setLayout(null);
			j.setBounds(100, 100, 850, 450);
			
			JTable jTable1=new JTable();
			String headings[]= {"Sales_Id", "Sales_Date", "Product_Id", "Product_Name","Quantity_Sold","Product_Price","Sales_Price","Profit_Amount"};
			jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},headings));
			DefaultTableModel model=new DefaultTableModel(headings,0); 
			JScrollPane jScrollPane=new JScrollPane();
			jScrollPane.setBounds(20, 50, 800, 200);
			j.getContentPane().add(jScrollPane);
			jTable1=new JTable(model);
			jScrollPane.setViewportView(jTable1);
			Object rowdata[]=new Object[8];
			for(int i=0;i<list.size();i++)
			{
				rowdata[0]=list.get(i).getSalesId();
				rowdata[1]=list.get(i).getSalesDate();
				rowdata[2]=list.get(i).getProductId();
				rowdata[3]=list.get(i).getProductName();
				rowdata[4]=list.get(i).getQuantitySold();
				rowdata[5]=list.get(i).getProductUnitPrice();
				rowdata[6]=list.get(i).getSalesPricePerUnit();
				rowdata[7]=list.get(i).getProfitAmount();
				model.addRow(rowdata);
			}
			j.getContentPane().add(jScrollPane);
			
		}
	}
}