package com.generic.application.aop;

import org.apache.logging.log4j.util.Strings;
import org.apache.tomcat.util.json.JSONParser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
public class ItemAspect {

	private static final Logger log = LoggerFactory.getLogger(ItemAspect.class);

	final ObjectMapper objectMapper = new ObjectMapper();

	@Around(value = "execution(* com.generic.application.controller.*.*(..))") //Pointcut expression
	public ResponseEntity<Object> beforeLog(ProceedingJoinPoint joinPoint) throws Throwable {
		 
		

		HttpServletRequest request =
				((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		HttpServletResponse httpResponse =
				((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
		
		JSONParser parser = new JSONParser(request.toString());  
		JSONPObject jsonObj = (JSONPObject) parser.parse();
		
		Object response = null;

		log.info(String.format("[REQUEST] Method: %s || URL: %s ",request.getMethod(), request.getRequestURL()));
		try {
			response = joinPoint.proceed();

			String responseBody = objectMapper.writeValueAsString(response);

			log.info(String.format("[RESPONSE] Status: %s || Response Body: %s",httpResponse.getStatus(), 
					(response != null ? objectMapper.writeValueAsString(response) : "No Response Body Available")));

			return new ResponseEntity<Object>(new JSONParser(responseBody).parse(), HttpStatusCode.valueOf(httpResponse.getStatus()));
		}catch(Exception e) {
			return new ResponseEntity<Object>(objectMapper.writeValueAsString(response), HttpStatusCode.valueOf(httpResponse.getStatus()));
		}
		
	}

}
