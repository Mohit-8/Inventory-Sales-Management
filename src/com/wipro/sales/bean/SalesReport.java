package com.wipro.sales.bean;

import java.util.Date;

public class SalesReport {
	
	String salesId, productId, productName;
	Date salesDate;
	int quantitySold;
	double productUnitPrice, salesPricePerUnit, profitAmount;

	public String getSalesId() {
		return salesId;
	}

	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}

	public int getQuantitySold() {
		return quantitySold;
	}

	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}

	public double getProductUnitPrice() {
		return productUnitPrice;
	}

	public void setProductUnitPrice(double productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}

	public double getSalesPricePerUnit() {
		return salesPricePerUnit;
	}

	public void setSalesPricePerUnit(double salesPricePerUnit) {
		this.salesPricePerUnit = salesPricePerUnit;
	}

	public double getProfitAmount() {
		return profitAmount;
	}

	public void setProfitAmount(double profitAmount) {
		this.profitAmount = profitAmount;
	}

}