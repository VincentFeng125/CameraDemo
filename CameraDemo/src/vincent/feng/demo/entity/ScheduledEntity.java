/**
 * ScheduledEntity.java
 * vincent.feng.demo.entity
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2015年1月30日 		FengZhe
 *
 * Copyright (c) 2015, Shanghai Changxing Information Technology Co., Ltd. All Rights Reserved.
 */

package vincent.feng.demo.entity;

/**
 * ClassName:ScheduledEntity Function: 已计划列表项实体类
 *
 * @author FengZhe
 * @version
 * @Date 2015年1月30日 下午4:45:18
 */
public class ScheduledEntity {

	private String title;
	private String date;
	private String content;

	public ScheduledEntity(String title, String date, String content) {
		this.title = title;
		this.date = date;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
