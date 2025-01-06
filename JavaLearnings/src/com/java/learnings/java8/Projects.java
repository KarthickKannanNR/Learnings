package com.java.learnings.java8;

public class Projects {

	private String projectName;

	public String getProjectName() {
		return projectName;
	}

	@Override
	public String toString() {
		return "Projects [projectName=" + projectName + ", getProjectName()=" + getProjectName() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public Projects(String projectName) {
		super();
		this.projectName = projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
