/**
 * RemindItemEntity.java
 * vincent.feng.demo.entity
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2015年2月3日 		FengZhe
 *
 * Copyright (c) 2015, Shanghai Changxing Information Technology Co., Ltd. All Rights Reserved.
 */

package vincent.feng.demo.entity;

/**
 * ClassName:RemindItemEntity Function: 安全警报、安全自检提醒、保养提醒中歌ListView item 实体类
 *
 * @author FengZhe
 * @version
 * @Date 2015年2月3日 下午4:41:28
 */
public class RemindItemEntity {

	/**
	 * 图片资源
	 */
	private int imageResource;

	/**
	 * 名称
	 */
	private String titleName;

	/**
	 * 详情设置
	 */
	private String detailedSetting = "详情设置";

	/**
	 * 开启状态
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
