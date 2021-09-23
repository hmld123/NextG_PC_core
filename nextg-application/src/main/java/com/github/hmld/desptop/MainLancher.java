package com.github.hmld.desptop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;

import com.github.hmld.common.pwm.enigine.bastdata.Materials;
import com.github.hmld.common.utils.LoggerUtil;
import com.github.hmld.desptop.view.MainView;

/**
 * 启动类
 * @author hmld
 *
 */
public class MainLancher {
  public static void main(String[] args) {
  	if (args.length>10) {
  		initApp();
		}
  	MainView.launch(MainView.class, args);
  }
  /**
   * 初始化配置文件
   */
  private static void initApp() {
		File dbFile = new File("./data.db");
		if (!dbFile.exists()) {
			InputStream fileIn = Materials.class.getClassLoader().getResourceAsStream("data.db");
			try {
				FileUtils.copyInputStreamToFile(fileIn, dbFile);
			} catch (IOException e) {
				LoggerUtil.errorMsgI18n(MainLancher.class, "system.log.error",e.getMessage());
			}
		}
  }
}
