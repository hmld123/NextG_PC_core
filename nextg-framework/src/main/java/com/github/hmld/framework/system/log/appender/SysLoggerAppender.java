package com.github.hmld.framework.system.log.appender;

import java.util.Vector;

import com.github.hmld.framework.system.log.util.ILogObserver;
import com.github.hmld.framework.system.log.util.ILogSubject;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
/**
 * 自定义LoggerAppender
 * @author hmld
 *
 */
public class SysLoggerAppender extends ConsoleAppender<ILoggingEvent> implements ILogSubject  {
	/**
	 * 观察者
	 */
	private static Vector<ILogObserver> logObservers = new Vector<ILogObserver>();
	/**
	 * 当前日志信息
	 */
	private String logmsg = "";
	
	@Override
	protected void append(ILoggingEvent event) {
		super.append(event);
		this.logmsg = new String(getEncoder().encode(event));
		this.notifyLogObServer();
	}
	/**
	 * 通知所有观察者
	 */
	@Override
	public void notifyLogObServer() {
		for (ILogObserver iLogObserver : logObservers) {
			iLogObserver.update(this.logmsg);
		}
	}
	/**
	 * 添加观察者
	 * @param observer
	 */
	public static void regisObServer(ILogObserver observer) {
		logObservers.add(observer);
	}
	/**
	 * 移除观察者
	 * @param observer
	 */
	public static void removeObServer(ILogObserver observer) {
		logObservers.remove(observer);
	}
	
}
