package com.example.service.business;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("mysrv")
public class ConstantService {
	public int fun(int x) {
		return 2 * x;
	}
}
