package com.front.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-01-31 16:00:30
 */
public class TAlgotithmsInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer pkId;
	//
	private String algotithmsTitle;
	//
	private String algotithmsDescription;
	//
	private String inputExpression;
	//
	private String outputExpression;
	//
	private String sampleInput;
	//
	private String sampleOut;
	//
	private String author;
	//
	private String funcName;
	//
	private long funcIndex;
	//
	private String algotithmsCode;
	//
	private Date gmtCreate;
	//
	private Date gmtModified;
	//
	private String controllerCode;
	//
	private Integer algotithmsType;

	
	public Integer getAlgotithmsType() {
		return algotithmsType;
	}
	public void setAlgotithmsType(Integer algotithmsType) {
		this.algotithmsType = algotithmsType;
	}
	public String getControllerCode() {
		return controllerCode;
	}
	public void setControllerCode(String controllerCode) {
		this.controllerCode = controllerCode;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setPkId(Integer pkId) {
		this.pkId = pkId;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Integer getPkId() {
		return pkId;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setAlgotithmsTitle(String algotithmsTitle) {
		this.algotithmsTitle = algotithmsTitle;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getAlgotithmsTitle() {
		return algotithmsTitle;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setAlgotithmsDescription(String algotithmsDescription) {
		this.algotithmsDescription = algotithmsDescription;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getAlgotithmsDescription() {
		return algotithmsDescription;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setInputExpression(String inputExpression) {
		this.inputExpression = inputExpression;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getInputExpression() {
		return inputExpression;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setOutputExpression(String outputExpression) {
		this.outputExpression = outputExpression;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getOutputExpression() {
		return outputExpression;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setSampleInput(String sampleInput) {
		this.sampleInput = sampleInput;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getSampleInput() {
		return sampleInput;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setSampleOut(String sampleOut) {
		this.sampleOut = sampleOut;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getSampleOut() {
		return sampleOut;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getFuncName() {
		return funcName;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setFuncIndex(long funcIndex) {
		this.funcIndex = funcIndex;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public long getFuncIndex() {
		return funcIndex;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setAlgotithmsCode(String algotithmsCode) {
		this.algotithmsCode = algotithmsCode;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getAlgotithmsCode() {
		return algotithmsCode;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Date getGmtModified() {
		return gmtModified;
	}
}
