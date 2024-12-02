package com.example.demo.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("lap1")
public class Laptop {
	
	private int lapId = 1;
	
	private String modelName = "acer";

	public int getLapId() {
		return lapId;
	}

	public void setLapId(int lapId) {
		this.lapId = lapId;
	}

	@Override
	public String toString() {
		return "Laptop [lapId=" + lapId + ", modelName=" + modelName + "]";
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	

}
