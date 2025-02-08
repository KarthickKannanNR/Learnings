package com.springboot.scheduler.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {

	@Scheduled(cron = "0 30 21 * * *")
	public void scheduleCheck() {
		System.out.println("scheduled method called");
	}
	 
}
