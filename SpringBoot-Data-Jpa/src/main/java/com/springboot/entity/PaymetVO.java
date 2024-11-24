package com.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PAYMENT_INFO")
@Data
@Getter
@Setter
public class PaymetVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3466883063997004176L;

	@Id
	@GeneratedValue
	private int pId;
	
	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	private String paymentType;
	
	@JsonFormat(shape = Shape.STRING,pattern = "dd-MM-yyyy")
	private Date paymetDate;
	
	public Date getPaymetDate() {
		return paymetDate;
	}

	public void setPaymetDate(Date paymetDate) {
		this.paymetDate = paymetDate;
	}

	public PaymetVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public double getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}

	private double totalAmt;
}
