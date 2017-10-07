package br.com.robsonaraujo.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWorldWs {

	@WebMethod
	public String sayHello() {
		return "Hello World";
	}
}
