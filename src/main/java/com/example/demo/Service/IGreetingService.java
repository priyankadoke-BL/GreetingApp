package com.example.demo.Service;

import com.example.demo.model.Greeting;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import java.util.Optional;

public interface IGreetingService {
	 Greeting greetingMessage();
	 String greetingMessageByName(UserDto userDto);
	 Optional<User> getById(long id);
}