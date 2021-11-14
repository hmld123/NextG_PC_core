package com.github.hmld.framework.system.log.util;
/**
 * 日志观察者接口
 * @author hmld
 *
 */
public interface ILogObserver {
	/**
	 * 更新观察内容
	 * @param logmsg
	 */
	public void update(String logmsg);
}
