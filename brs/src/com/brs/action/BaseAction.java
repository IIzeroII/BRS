package com.brs.action;

import java.sql.Timestamp;
import java.util.Date;

import com.brs.utils.GActionUtils;
import com.brs.utils.GReturnJSON;

/**
 * 项目基础action类
 * @author zero
 *
 */

public class BaseAction extends GActionUtils{
	/**
	 * 获取服务器现在的时间
	 */
	public void getServerNowTime(){
		GReturnJSON retJSON = new GReturnJSON();
		try {
			Timestamp now = new Timestamp(new Date().getTime());
			retJSON.setObj(now);
			//设置返回信息
			retJSON.setMsg("获取服务器时间成功。");
			retJSON.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
		}finally{
			writeJSON(retJSON);
		}
	}
}
