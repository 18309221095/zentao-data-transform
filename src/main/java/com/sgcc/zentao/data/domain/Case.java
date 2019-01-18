/**
 * 
 */
package com.sgcc.zentao.data.domain;

import org.apache.ibatis.type.Alias;

/**
 * @author tangliang
 *
 */
@Alias("CASE")
public class Case {
	private int id; 
	private String casemark; 
	private int product; 
	private int branch; 
	private int lib; 
	private int module; 
	private int path; 
	private int story; 
	private int storyVersion; 
	private String title; 
	private String precondition; 
	private String keywords; 
	private int pri; 
	private String type; 
	private String stage; 
	private String howRun; 
	private String scriptedBy; 
	private String scriptedDate; 
	private String scriptStatus; 
	private String scriptLocation; 
	private String status; 
	private String color; 
	private String frequency; 
	private int order; 
	private String openedBy; 
	private String openedDate; 
	private String reviewedBy; 
	private String reviewedDate; 
	private String lastEditedBy; 
	private String lastEditedDate; 
	private int version; 
	private String linkCase; 
	private int fromBug; 
	private int fromCaseID; 
	private String deleted; 
	private String lastRunner; 
	private String lastRunDate; 
	private String lastRunResult; 
	private String testData;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCasemark() {
		return casemark;
	}
	public void setCasemark(String casemark) {
		this.casemark = casemark;
	}
	public int getProduct() {
		return product;
	}
	public void setProduct(int product) {
		this.product = product;
	}
	public int getBranch() {
		return branch;
	}
	public void setBranch(int branch) {
		this.branch = branch;
	}
	public int getLib() {
		return lib;
	}
	public void setLib(int lib) {
		this.lib = lib;
	}
	public int getModule() {
		return module;
	}
	public void setModule(int module) {
		this.module = module;
	}
	public int getPath() {
		return path;
	}
	public void setPath(int path) {
		this.path = path;
	}
	public int getStory() {
		return story;
	}
	public void setStory(int story) {
		this.story = story;
	}
	public int getStoryVersion() {
		return storyVersion;
	}
	public void setStoryVersion(int storyVersion) {
		this.storyVersion = storyVersion;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrecondition() {
		return precondition;
	}
	public void setPrecondition(String precondition) {
		this.precondition = precondition;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public int getPri() {
		return pri;
	}
	public void setPri(int pri) {
		this.pri = pri;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getHowRun() {
		return howRun;
	}
	public void setHowRun(String howRun) {
		this.howRun = howRun;
	}
	public String getScriptedBy() {
		return scriptedBy;
	}
	public void setScriptedBy(String scriptedBy) {
		this.scriptedBy = scriptedBy;
	}
	public String getScriptedDate() {
		return scriptedDate;
	}
	public void setScriptedDate(String scriptedDate) {
		this.scriptedDate = scriptedDate;
	}
	public String getScriptStatus() {
		return scriptStatus;
	}
	public void setScriptStatus(String scriptStatus) {
		this.scriptStatus = scriptStatus;
	}
	public String getScriptLocation() {
		return scriptLocation;
	}
	public void setScriptLocation(String scriptLocation) {
		this.scriptLocation = scriptLocation;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getOpenedBy() {
		return openedBy;
	}
	public void setOpenedBy(String openedBy) {
		this.openedBy = openedBy;
	}
	public String getOpenedDate() {
		return openedDate;
	}
	public void setOpenedDate(String openedDate) {
		this.openedDate = openedDate;
	}
	public String getReviewedBy() {
		return reviewedBy;
	}
	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}
	public String getReviewedDate() {
		return reviewedDate;
	}
	public void setReviewedDate(String reviewedDate) {
		this.reviewedDate = reviewedDate;
	}
	public String getLastEditedBy() {
		return lastEditedBy;
	}
	public void setLastEditedBy(String lastEditedBy) {
		this.lastEditedBy = lastEditedBy;
	}
	public String getLastEditedDate() {
		return lastEditedDate;
	}
	public void setLastEditedDate(String lastEditedDate) {
		this.lastEditedDate = lastEditedDate;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getLinkCase() {
		return linkCase;
	}
	public void setLinkCase(String linkCase) {
		this.linkCase = linkCase;
	}
	public int getFromBug() {
		return fromBug;
	}
	public void setFromBug(int fromBug) {
		this.fromBug = fromBug;
	}
	public int getFromCaseID() {
		return fromCaseID;
	}
	public void setFromCaseID(int fromCaseID) {
		this.fromCaseID = fromCaseID;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public String getLastRunner() {
		return lastRunner;
	}
	public void setLastRunner(String lastRunner) {
		this.lastRunner = lastRunner;
	}
	public String getLastRunDate() {
		return lastRunDate;
	}
	public void setLastRunDate(String lastRunDate) {
		this.lastRunDate = lastRunDate;
	}
	public String getLastRunResult() {
		return lastRunResult;
	}
	public void setLastRunResult(String lastRunResult) {
		this.lastRunResult = lastRunResult;
	}
	public String getTestData() {
		return testData;
	}
	public void setTestData(String testData) {
		this.testData = testData;
	}
}
