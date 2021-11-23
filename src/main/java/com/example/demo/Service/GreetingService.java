package com.example.demo.Service;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repository.IGreetingRepository;
import com.example.demo.model.Greeting;
import org.modelmapper.ModelMapper;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import java.util.Optional;

@Service
public class GreetingService implements IGreetingService{
	private static final String template = "Hello world";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    IGreetingRepository iGreetingRepository;
    
	@Override
	public Greeting greetingMessage() {
		return new Greeting(counter.incrementAndGet(), String.format(template));
	}
	
	@Override
    public String greetingMessageByName(UserDto userDto) {
        User user = new User();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(userDto, user);
        iGreetingRepository.save(user);
        return ("Hello " + user.getFirstName() + " " + user.getLastName());
    }
	
	@Override
    public Optional<User> getById(long id) {
        Optional<User> greetById = iGreetingRepository.findById(id);
        return greetById;
    }
}