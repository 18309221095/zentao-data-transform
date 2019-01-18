/**
 * 
 */
package com.sgcc.zentao.data.domain;

import org.apache.ibatis.type.Alias;

/**
 * @author tangliang
 *
 */
@Alias("BUG")
public class Bug {
	private int id; 
	private int product; 
	private int branch; 
	private int module; 
	private int project; 
	private int plan; 
	private int story; 
	private int storyVersion; 
	private int task; 
	private int toTask; 
	private int toStory; 
	private String title; 
	private String keywords; 
	private int severity; 
	private int pri; 
	private String type; 
	private String os; 
	private String browser; 
	private String hardware; 
	private String found; 
	private String steps; 
	private String status; 
	private String color; 
	private String confirmed; 
	private String activatedCount; 
	private String mailto; 
	private String openedBy; 
	private String openedDate; 
	private String openedBuild; 
	private String assignedTo; 
	private String assignedDate; 
	private String deadline; 
	private String resolvedBy; 
	private String resolution; 
	private String resolvedBuild; 
	private String resolvedDate; 
	private String closedBy; 
	private String closedDate; 
	private String duplicateBug; 
	private String linkBug; 
	private int case_s; 
	private int caseVersion; 
	private int result; 
	private int testtask; 
	private String lastEditedBy; 
	private String lastEditedDate; 
	private String deleted; 
	private String testEdit; 
	private String testCommentDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getModule() {
		return module;
	}
	public void setModule(int module) {
		this.module = module;
	}
	public int getProject() {
		return project;
	}
	public void setProject(int project) {
		this.project = project;
	}
	public int getPlan() {
		return plan;
	}
	public void setPlan(int plan) {
		this.plan = plan;
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
	public int getTask() {
		return task;
	}
	public void setTask(int task) {
		this.task = task;
	}
	public int getToTask() {
		return toTask;
	}
	public void setToTask(int toTask) {
		this.toTask = toTask;
	}
	public int getToStory() {
		return toStory;
	}
	public void setToStory(int toStory) {
		this.toStory = toStory;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public int getSeverity() {
		return severity;
	}
	public void setSeverity(int severity) {
		this.severity = severity;
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
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getHardware() {
		return hardware;
	}
	public void setHardware(String hardware) {
		this.hardware = hardware;
	}
	public String getFound() {
		return found;
	}
	public void setFound(String found) {
		this.found = found;
	}
	public String getSteps() {
		return steps;
	}
	public void setSteps(String steps) {
		this.steps = steps;
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
	public String getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}
	public String getActivatedCount() {
		return activatedCount;
	}
	public void setActivatedCount(String activatedCount) {
		this.activatedCount = activatedCount;
	}
	public String getMailto() {
		return mailto;
	}
	public void setMailto(String mailto) {
		this.mailto = mailto;
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
	public String getOpenedBuild() {
		return openedBuild;
	}
	public void setOpenedBuild(String openedBuild) {
		this.openedBuild = openedBuild;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getAssignedDate() {
		return assignedDate;
	}
	public void setAssignedDate(String assignedDate) {
		this.assignedDate = assignedDate;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getResolvedBy() {
		return resolvedBy;
	}
	public void setResolvedBy(String resolvedBy) {
		this.resolvedBy = resolvedBy;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public String getResolvedBuild() {
		return resolvedBuild;
	}
	public void setResolvedBuild(String resolvedBuild) {
		this.resolvedBuild = resolvedBuild;
	}
	public String getResolvedDate() {
		return resolvedDate;
	}
	public void setResolvedDate(String resolvedDate) {
		this.resolvedDate = resolvedDate;
	}
	public String getClosedBy() {
		return closedBy;
	}
	public void setClosedBy(String closedBy) {
		this.closedBy = closedBy;
	}
	public String getClosedDate() {
		return closedDate;
	}
	public void setClosedDate(String closedDate) {
		this.closedDate = closedDate;
	}
	public String getDuplicateBug() {
		return duplicateBug;
	}
	public void setDuplicateBug(String duplicateBug) {
		this.duplicateBug = duplicateBug;
	}
	public String getLinkBug() {
		return linkBug;
	}
	public void setLinkBug(String linkBug) {
		this.linkBug = linkBug;
	}
	public int getCase_s() {
		return case_s;
	}
	public void setCase_s(int case_s) {
		this.case_s = case_s;
	}
	public int getCaseVersion() {
		return caseVersion;
	}
	public void setCaseVersion(int caseVersion) {
		this.caseVersion = caseVersion;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public int getTesttask() {
		return testtask;
	}
	public void setTesttask(int testtask) {
		this.testtask = testtask;
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
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public String getTestEdit() {
		return testEdit;
	}
	public void setTestEdit(String testEdit) {
		this.testEdit = testEdit;
	}
	public String getTestCommentDate() {
		return testCommentDate;
	}
	public void setTestCommentDate(String testCommentDate) {
		this.testCommentDate = testCommentDate;
	}
}
