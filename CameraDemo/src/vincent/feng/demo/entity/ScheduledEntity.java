/**
 * ScheduledEntity.java
 * vincent.feng.demo.entity
 *
 * Function�� TODO 
 *
 *   ver     date      		author
 * ��������������������������������������������������������������������
 *   		 2015��1��30�� 		FengZhe
 *
 * Copyright (c) 2015, Shanghai Changxing Information Technology Co., Ltd. All Rights Reserved.
 */

package vincent.feng.demo.entity;

/**
 * ClassName:ScheduledEntity Function: �Ѽƻ��б���ʵ����
 *
 * @author FengZhe
 * @version
 * @Date 2015��1��30�� ����4:45:18
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
