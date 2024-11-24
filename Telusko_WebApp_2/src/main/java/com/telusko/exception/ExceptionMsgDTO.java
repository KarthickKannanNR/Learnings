package com.telusko.exception;

import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ExceptionMsgDTO {

	private String status;
	public ExceptionMsgDTO(String status, String message, HttpStatusCode statusCode) {
		super();
		this.status = status;
		this.message = message;
		this.statusCode = statusCode;
	}
	private String message;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatusCode getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(HttpStatusCode statusCode) {
		this.statusCode = statusCode;
	}
	private HttpStatusCode statusCode; 
}
