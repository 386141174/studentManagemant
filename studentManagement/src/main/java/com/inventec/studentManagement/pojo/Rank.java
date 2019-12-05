package com.inventec.studentManagement.pojo;

import java.io.Serializable;

public class Rank implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7046996755412911142L;
	private String id;
	private String YW;
	private String SX;
	private String YY;
	private String WL;
	private String HX;
	private String SW;
	private String LS;
	private String DL;
	private String ZZ;
	private String XX;
	private Student student;
	private Score score;
	public String getYW() {
		return YW;
	}
	public void setYW(String yW) {
		YW = yW;
	}
	public String getSX() {
		return SX;
	}
	public void setSX(String sX) {
		SX = sX;
	}
	public String getYY() {
		return YY;
	}
	public void setYY(String yY) {
		YY = yY;
	}
	public String getWL() {
		return WL;
	}
	public void setWL(String wL) {
		WL = wL;
	}
	public String getHX() {
		return HX;
	}
	public void setHX(String hX) {
		HX = hX;
	}
	public String getSW() {
		return SW;
	}
	public void setSW(String sW) {
		SW = sW;
	}
	public String getLS() {
		return LS;
	}
	public void setLS(String lS) {
		LS = lS;
	}
	public String getDL() {
		return DL;
	}
	public void setDL(String dL) {
		DL = dL;
	}
	public String getZZ() {
		return ZZ;
	}
	public void setZZ(String zZ) {
		ZZ = zZ;
	}
	public String getXX() {
		return XX;
	}
	public void setXX(String xX) {
		XX = xX;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
