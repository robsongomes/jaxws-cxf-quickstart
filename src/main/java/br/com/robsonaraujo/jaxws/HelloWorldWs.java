package br.com.robsonaraujo.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWorldWs {

	@WebMethod
	public String sayHello() {
		return "Hello World";
	}
}
