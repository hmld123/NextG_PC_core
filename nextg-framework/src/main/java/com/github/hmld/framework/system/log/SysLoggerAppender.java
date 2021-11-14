package com.github.hmld.framework.system.log;

import java.util.ArrayList;
import java.util.List;

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
	
	private static List<ILogObserver> logObservers = new ArrayList<ILogObserver>();
	private String logmsg = "";
	@Override
	protected void append(ILoggingEvent event) {
		super.append(event);
		this.logmsg = new String(getEncoder().encode(event));
		this.notifyLogObServer();
	}

	@Override
	public void regisLogObServer(ILogObserver observer) {
		logObservers.add(observer);
	}

	@Override
	public void removeLogObServer(ILogObserver observer) {
		logObservers.remove(observer);
	}

	@Override
	public void notifyLogObServer() {
		for (ILogObserver iLogObserver : logObservers) {
			iLogObserver.update(this.logmsg);
		}
	}
	
	public static void regisObServer(ILogObserver observer) {
		logObservers.add(observer);
	}
	
	public static void removeObServer(ILogObserver observer) {
		logObservers.remove(observer);
	}
	
}
