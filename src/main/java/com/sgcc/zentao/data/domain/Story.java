/**
 * 
 */
package com.sgcc.zentao.data.domain;

import org.apache.ibatis.type.Alias;

/**
 * @author tangliang
 *
 */
@Alias("STORY")
public class Story {
	private int id;
	private int product;
	private int branch;
	private int module;
	private int plan;
	private String source;
	private String sourceNote;
	private int fromBug;
	private String title;
	private String keywords;
	private String type;
	private int pri;
	private Float estimate;
	private String status;
	private String color;
	private String stage;
	private String mailto;
	private String openedBy;
	private String openedDate;
	private String assignedTo;
	private String assignedDate;
	private String lastEditedBy;
	private String lastEditedDate;
	private String reviewedBy;
	private String reviewedDate;
	private String closedBy;
	private String closedDate;
	private String closedReason;
	private int toBug;
	private String childStories;
	private String linkStories;
	private int duplicateStory;
	private int version;
	private String deleted;
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
	public int getPlan() {
		return plan;
	}
	public void setPlan(int plan) {
		this.plan = plan;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getSourceNote() {
		return sourceNote;
	}
	public void setSourceNote(String sourceNote) {
		this.sourceNote = sourceNote;
	}
	public int getFromBug() {
		return fromBug;
	}
	public void setFromBug(int fromBug) {
		this.fromBug = fromBug;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPri() {
		return pri;
	}
	public void setPri(int pri) {
		this.pri = pri;
	}
	public Float getEstimate() {
		return estimate;
	}
	public void setEstimate(Float estimate) {
		this.estimate = estimate;
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
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
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
	public String getClosedReason() {
		return closedReason;
	}
	public void setClosedReason(String closedReason) {
		this.closedReason = closedReason;
	}
	public int getToBug() {
		return toBug;
	}
	public void setToBug(int toBug) {
		this.toBug = toBug;
	}
	public String getChildStories() {
		return childStories;
	}
	public void setChildStories(String childStories) {
		this.childStories = childStories;
	}
	public String getLinkStories() {
		return linkStories;
	}
	public void setLinkStories(String linkStories) {
		this.linkStories = linkStories;
	}
	public int getDuplicateStory() {
		return duplicateStory;
	}
	public void setDuplicateStory(int duplicateStory) {
		this.duplicateStory = duplicateStory;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	
}
