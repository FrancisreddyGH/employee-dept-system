package com.example.employeemanagementsystem.Controller;


import com.example.employeemanagementsystem.Dto.UserRequestDto;
import com.example.employeemanagementsystem.Dto.UserResponseDto;
import com.example.employeemanagementsystem.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto){
        return authService.createUser(userRequestDto);
    }
}
