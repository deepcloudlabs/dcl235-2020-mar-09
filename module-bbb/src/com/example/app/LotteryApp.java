package com.example.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ServiceLoader;

import com.example.bbb.service.business.SimpleLotteryService;
import com.example.ccc.service.Quality;
import com.example.ccc.service.QualityLevel;
import com.example.ccc.service.RandomNumberService;

public class LotteryApp {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties props = new Properties();
		props.load(new FileInputStream(new File("src","application.properties")));
		QualityLevel level = QualityLevel.valueOf(props.getProperty("random.number.service.level"));
		SimpleLotteryService sls = new SimpleLotteryService();
		ServiceLoader<RandomNumberService> loader = ServiceLoader.load(RandomNumberService.class);
		sls.setRandomNumberService(extractService(loader,level));
		sls.draw(10).forEach(System.err::println);
	}

	private static RandomNumberService extractService(ServiceLoader<RandomNumberService> loader,QualityLevel level) {
		RandomNumberService randomNumberService = null;
		for (RandomNumberService rns : loader) {
			Class<?> clazz = rns.getClass();
			if(clazz.isAnnotationPresent(Quality.class)) {
				Quality quality = clazz.getAnnotation(Quality.class);
				if (quality.value() == level) {
					randomNumberService = rns;
					break;
				}
			}
		}
		return randomNumberService;
	}

}
