package com.example.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.example.controller.LotteryController;

@ApplicationPath("/api/v1")
public class RestConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		return new HashSet<>(Arrays.asList(LotteryController.class));
	}

}
