package com.github.hmld.framework.system.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.github.hmld.common.utils.LoggerUtil;
import com.github.hmld.common.utils.StringUtils;
import com.github.hmld.framework.system.log.appender.SysLoggerAppender;
import com.github.hmld.framework.system.log.util.ILogObserver;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
/**
 * Log日志窗口
 * @author hmld
 *
 */
public class LoggerContoller implements ILogObserver{
	@FXML 
	private TextArea logConsole;
	@FXML
	private Button exportlog;
	@FXML
	private Button clearlog;
	/**
	 * 保存日志数据
	 * @param event
	 * @throws Exception
	 */
	public void exportlogAction(ActionEvent event)  {
		for (int i = 0; i < 10; i++) {
			LoggerUtil.infoMsg(getClass(), new Exception("i->"+i));
		}
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
    fileChooser.getExtensionFilters().add(extFilter);
    File file = fileChooser.showSaveDialog(stage);
    try {
	    if (StringUtils.isNotNull(file)) {
	    	if (!file.exists()) {
					file.createNewFile();
				}
	    	FileWriter fileWriter = new FileWriter(file);
	    	fileWriter.write(logConsole.getText());
	    	fileWriter.close();
	    	LoggerUtil.infoMsg(getClass(), "日志文件保存成功");
			}
    } catch (IOException e) {
			LoggerUtil.infoMsg(getClass(), e);
		}
	}
	
	/**
	 * 清空日志信息
	 * @param event
	 */
	public void clearlogAction(ActionEvent event) {
		this.logConsole.clear();
	}
	
	/**
	 * 更新log日志内容
	 */
	@Override
	public void update(String logmsg) {
		this.logConsole.appendText(logmsg);
	}
	
	public LoggerContoller() {
		/**
		 * 注册 log日志 观察者
		 */
		SysLoggerAppender.regisObServer(this);
	}

}
