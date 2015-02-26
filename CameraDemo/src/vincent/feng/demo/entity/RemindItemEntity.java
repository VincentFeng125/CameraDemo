/**
 * RemindItemEntity.java
 * vincent.feng.demo.entity
 *
 * Function�� TODO 
 *
 *   ver     date      		author
 * ��������������������������������������������������������������������
 *   		 2015��2��3�� 		FengZhe
 *
 * Copyright (c) 2015, Shanghai Changxing Information Technology Co., Ltd. All Rights Reserved.
 */

package vincent.feng.demo.entity;

/**
 * ClassName:RemindItemEntity Function: ��ȫ��������ȫ�Լ����ѡ����������и�ListView item ʵ����
 *
 * @author FengZhe
 * @version
 * @Date 2015��2��3�� ����4:41:28
 */
public class RemindItemEntity {

	/**
	 * ͼƬ��Դ
	 */
	private int imageResource;

	/**
	 * ����
	 */
	private String titleName;

	/**
	 * ��������
	 */
	private String detailedSetting = "��������";

	/**
	 * ����״̬
	 */
	private boolean settingStatus;

	public int getImageResource() {
		return imageResource;
	}

	public void setImageResource(int imageResource) {
		this.imageResource = imageResource;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getDetailedSetting() {
		return detailedSetting;
	}

	public void setDetailedSetting(String detailedSettingString) {
		this.detailedSetting = detailedSettingString;
	}

	public boolean isSettingStatus() {
		return settingStatus;
	}

	public void setSettingStatus(boolean settingStatus) {
		this.settingStatus = settingStatus;
	}

}
