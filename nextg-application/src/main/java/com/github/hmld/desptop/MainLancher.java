package com.github.hmld.desptop;

import com.github.hmld.desptop.view.MainView;

/**
 * 启动类
 * @author hmld
 *
 */
public class MainLancher {
  public static void main(String[] args) {
  	MainView.launch(MainView.class, args);
  }
}
