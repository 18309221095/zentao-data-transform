/**
 * 
 */
package com.sgcc.zentao.data.domain;

import org.apache.ibatis.type.Alias;

/**
 * @author tangliang
 *
 */
@Alias("STORYSPEC")
public class Storyspec {
	private int story; 
	private int version; 
	private String title; 
	private String spec; 
	private String verify;
	public int getStory() {
		return story;
	}
	public void setStory(int story) {
		this.story = story;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getVerify() {
		return verify;
	}
	public void setVerify(String verify) {
		this.verify = verify;
	}
}
