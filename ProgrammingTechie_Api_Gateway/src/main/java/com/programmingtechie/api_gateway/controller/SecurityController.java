package com.programmingtechie.api_gateway.controller;

/*import org.springframework.security.web.csrf.CsrfToken;
*/import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletRequestAttributes;

import reactor.netty.http.server.HttpServerRequest;

@RestController("/api/apigateway/")
public class SecurityController {

	/*
	 * @GetMapping("getcsrftoken") public CsrfToken
	 * getCSRFToken(ServletRequestAttributes request) { return (CsrfToken)
	 * request.getAttribute("_csrf", 1); }
	 */
}
