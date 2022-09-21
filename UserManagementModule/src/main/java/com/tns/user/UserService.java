package com.tns.user;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
	@Autowired List<User> listAll()
	{
		return repo.findAll();
	}
	public void save(User user)
	{
		repo.save(user);
	}
	public User get(int id)
	{
		return repo.findById(id).get();
		
	}
	public void delete(int id)
	{
		repo.deleteById(id);
	}
	
}
