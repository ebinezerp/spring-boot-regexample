package com.example.regexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.regexample.model.UserAccount;
import com.example.regexample.repository.UserAccountRepository;

@Service
public class UserAccountService {
	
	@Autowired
	private UserAccountRepository userAccountRepository;
	
	public boolean saveAccount(UserAccount userAccount)
	{
		try {
			userAccountRepository.save(userAccount);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public UserAccount login(String email,String password)
	{
		
		System.out.println("Email :"+email+" Password :"+password);
		
		try {
			return userAccountRepository.login(email, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

}
