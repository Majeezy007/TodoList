package com.majeezy.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping("say-hello")
	@ResponseBody
	private String sayHello() {
		return "HELLO, what are you learning today";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	private String sayHelloHtml() {
		
		return "<html>\r\n"
				+ "	<head>\r\n"
				+ "		<title>My First HTML Page</title>\r\n"
				+ "	</head>\r\n"
				+ "	<body>\r\n"
				+ "		My first HTML page with body - changed\r\n"
				+ "	</body>\r\n"
				+ "</html>";
	}
	
	@RequestMapping("say-hello-jsp")
	private String sayHelloJsp() {
		return "sayHello";
	}
}
