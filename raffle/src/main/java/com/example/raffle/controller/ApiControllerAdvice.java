package com.example.raffle.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice(basePackages = {"com.example.raffle.controller"})
public class ApiControllerAdvice {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiControllerAdvice.class);
	
	@Autowired
	ObjectMapper objectMapper;
	
	@ExceptionHandler({IllegalArgumentException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String handleMissingParameterException(HttpServletRequest httpServletRequest, IllegalArgumentException exception) throws JsonProcessingException {
		LOGGER.debug("Request Failure: "+exception.getMessage(),exception);
		return objectMapper.writeValueAsString(exception.getMessage());
	}
	
	@ExceptionHandler({JpaObjectRetrievalFailureException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String handleMissingDependentObject(HttpServletRequest httpServletRequest, JpaObjectRetrievalFailureException exception) throws JsonProcessingException {
		LOGGER.debug("Request Failure.  Please insure any referenced resources exist: "+exception.getMessage(),exception);
		return objectMapper.writeValueAsString(exception.getMessage());
	}
	
	@ExceptionHandler({Exception.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public String handleException(HttpServletRequest httpServletRequest, Exception exception) {
		LOGGER.error("Request Failure: "+exception.getMessage(),exception);
		return "Internal Server Error. Please contact support for details.";
	}
}