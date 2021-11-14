package com.github.hmld.framework.system.log.util;
/**
 * 观察对象
 * @author hmld
 *
 */
public interface ILogSubject {
	/**
	 * 添加观察者
	 * @param observer
	 */
	public void regisLogObServer(ILogObserver observer);
	/**
	 * 删除观察者
	 * @param observer
	 */
	public void removeLogObServer(ILogObserver observer);
	/**
	 * 通知所有观察者
	 */
	public void notifyLogObServer();
}
