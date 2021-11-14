package com.github.hmld.framework.system.log.util;
/**
 * 观察对象
 * @author hmld
 *
 */
public interface ILogSubject {
	/**
	 * 通知所有观察者
	 */
	public void notifyLogObServer();
}
