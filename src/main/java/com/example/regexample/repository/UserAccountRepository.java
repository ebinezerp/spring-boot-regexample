package com.example.regexample.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.regexample.model.UserAccount;

@Repository
@Transactional
public interface UserAccountRepository extends CrudRepository<UserAccount, String>{

	@Query("From UserAccount where email=:email and password=:password")
	public UserAccount login(@Param("email")String email,@Param("password")String password);
}
