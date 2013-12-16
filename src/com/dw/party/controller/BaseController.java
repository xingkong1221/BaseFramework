package com.dw.party.controller;

import javax.annotation.Resource;

import com.dw.party.base.data.support.dto.UserPreferences;

public class BaseController {
	
	@Resource(name = "userPreferences")
	public UserPreferences userPreferences;
}
