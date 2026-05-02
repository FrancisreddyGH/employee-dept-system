package com.example.employeemanagementsystem.Service;

import com.example.employeemanagementsystem.Dto.UserRequestDto;
import com.example.employeemanagementsystem.Dto.UserResponseDto;
import com.example.employeemanagementsystem.Entity.User;
import com.example.employeemanagementsystem.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = new User();

        user.setEmail(userRequestDto.getEmail());
        user.setName(userRequestDto.getName());
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));

        if(userRequestDto.getRole()==null){
            user.setRole("USER");
        }else{
           user.setRole(userRequestDto.getRole());
        }

        User savedUser = userRepository.save(user);
        UserResponseDto response = new UserResponseDto(savedUser.getId(), "successfully created");
        return response;
    }
}
