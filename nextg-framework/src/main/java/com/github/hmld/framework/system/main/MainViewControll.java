package com.github.hmld.framework.system.main;

import java.io.IOException;
import java.util.ResourceBundle;

import com.github.hmld.common.utils.LoggerUtil;
import com.github.hmld.common.utils.MsageUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

public class MainViewControll {
	@FXML
	private Button openview;
	@FXML
	private ScrollPane root;
	
	public void openviewAction(ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(loader.getClassLoader().getResource("view/logger.fxml"));
	    loader.setResources(ResourceBundle.getBundle(MsageUtils.getPropertiesUrl().replaceAll(".properties", "")));
	    AnchorPane panel = loader.load();
	    panel.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
	    root.setContent(panel);
	    LoggerUtil.infoMsgI18n(getClass(), "system.log.info","加载 [view/logger.fxml]");
	}
}
