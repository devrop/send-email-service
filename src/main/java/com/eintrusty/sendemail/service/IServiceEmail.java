package com.eintrusty.sendemail.service;

import java.util.Map;

import com.eintrusty.sendemail.model.TrackedEmailDto;

public interface IServiceEmail {
	
	public int sendEmail(TrackedEmailDto dto);

}
