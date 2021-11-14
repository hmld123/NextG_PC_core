package com.github.hmld.framework.system.log;

import java.io.File;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;

import com.github.hmld.common.utils.LoggerUtil;
import com.github.hmld.framework.system.log.util.ILogObserver;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class LoggerContoller implements ILogObserver,Initializable{
	@FXML 
	private TextArea loggerView;
	@FXML
	private Button dolog;
	static PrintStream advancedStream;
	public void dologAction(ActionEvent event) throws Exception {
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
    fileChooser.getExtensionFilters().add(extFilter);
    File file = fileChooser.showOpenDialog(stage);
    LoggerUtil.infoMsg(getClass(), file.getPath());
    
	}
	
	@Override
	public void update(String logmsg) {
		this.loggerView.appendText(logmsg);
	}

	public LoggerContoller() {
		SysLoggerAppender.regisObServer(this);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
