package com.springboot.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {

	@Autowired
	private JobLauncher joblauncher;
	@Autowired
	private Job job;
}
