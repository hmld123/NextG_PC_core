package com.github.hmld.desptop.common.core.enity.base;

import com.github.hmld.desptop.common.utils.LoginPool;
import com.github.hmld.desptop.core.enity.SysManagerEnity;
import com.github.hmld.desptop.view.passwordmanager.controller.AddViewController;

public class BaseController {
	protected static SysManagerEnity headerManager;
	
	protected static SysManagerEnity getManager() {
  	if (headerManager==null) {
    	headerManager = LoginPool.getLoginUser(AddViewController.class);
		}
  	return headerManager;
  }
}
