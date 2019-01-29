package com.eintrusty.sendemail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eintrusty.sendemail.model.TrackedEmailDto;
import com.eintrusty.sendemail.service.IServiceEmail;

@RestController
@RequestMapping("email")
public class EmailController {
	
	@Autowired
	IServiceEmail emailService;
	
	
	
	@GetMapping("send")
	public String test() {
		TrackedEmailDto dto = new TrackedEmailDto();
		
		dto.setTo("ruangmetafora@gmail.com");
		dto.setFrom("arimanehdamang@gmail.com");
		dto.setUsernameFrom("arimanehdamang@gmail.com");
		int result = emailService.sendEmail(dto);
		String resultS = result == 0? "OK":"Failed";  
		return resultS;
		
	}

}
