/**
 * 
 */
package com.sgcc.zentao.data.domain;

import org.apache.ibatis.type.Alias;

/**
 * @author tangliang
 *
 */
@Alias("TASK")
public class Task {
	private int id;
	private int project;
	private int module;
	private int story;
	private int storyVersion;
	private int fromBug;
	private String name;
	private String type;
	private int pri;
	private Float estimate;
	private Float consumed;
	private Float left;
	private String deadline;
	private String status;
	private String color;
	private String mailto;
	private String desc;
	private String openedBy;
	private String openedDate;
	private String assignedTo;
	private String assignedDate;
	private String estStarted;
	private String realStarted;
	private String finishedBy;
	private String finishedDate;
	private String canceledBy;
	private String canceledDate;
	private String closedBy;
	private String closedDate;
	private String closedReason;
	private String lastEditedBy;
	private String lastEditedDate;
	private String deleted;
	private String delayedTimes;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProject() {
		return project;
	}
	public void setProject(int project) {
		this.project = project;
	}
	public int getModule() {
		return module;
	}
	public void setModule(int module) {
		this.module = module;
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
	public int getFromBug() {
		return fromBug;
	}
	public void setFromBug(int fromBug) {
		this.fromBug = fromBug;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Float getConsumed() {
		return consumed;
	}
	public void setConsumed(Float consumed) {
		this.consumed = consumed;
	}
	public Float getLeft() {
		return left;
	}
	public void setLeft(Float left) {
		this.left = left;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
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
	public String getMailto() {
		return mailto;
	}
	public void setMailto(String mailto) {
		this.mailto = mailto;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
	public String getEstStarted() {
		return estStarted;
	}
	public void setEstStarted(String estStarted) {
		this.estStarted = estStarted;
	}
	public String getRealStarted() {
		return realStarted;
	}
	public void setRealStarted(String realStarted) {
		this.realStarted = realStarted;
	}
	public String getFinishedBy() {
		return finishedBy;
	}
	public void setFinishedBy(String finishedBy) {
		this.finishedBy = finishedBy;
	}
	public String getFinishedDate() {
		return finishedDate;
	}
	public void setFinishedDate(String finishedDate) {
		this.finishedDate = finishedDate;
	}
	public String getCanceledBy() {
		return canceledBy;
	}
	public void setCanceledBy(String canceledBy) {
		this.canceledBy = canceledBy;
	}
	public String getCanceledDate() {
		return canceledDate;
	}
	public void setCanceledDate(String canceledDate) {
		this.canceledDate = canceledDate;
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
	public String getDelayedTimes() {
		return delayedTimes;
	}
	public void setDelayedTimes(String delayedTimes) {
		this.delayedTimes = delayedTimes;
	}
	
}
