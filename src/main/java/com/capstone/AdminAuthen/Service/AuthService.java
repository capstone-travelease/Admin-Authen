package com.capstone.AdminAuthen.Service;


import com.capstone.AdminAuthen.DTO.LoginRequestDTO;
import com.capstone.AdminAuthen.DTO.SignUpDTO;
import com.capstone.AdminAuthen.DTO.UserLoginDTO;
import com.capstone.AdminAuthen.Entity.Users;
import com.capstone.AdminAuthen.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthService(JwtService jwtService, UserRepository userRepository, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
    }

    public UserLoginDTO Login(LoginRequestDTO user){
        try {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
            if(authenticate.isAuthenticated()){
                HashMap<String,Object> map = new HashMap<>();
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                UserLoginDTO userData = userRepository.generateUser(user.getEmail(),3);
                return userData;
            }
            else{
                return null;
            }
        }catch (Exception err){
            System.err.println(err);
            return null;
        }

    }

    public boolean signUp(SignUpDTO user){
        try {
            Optional<Users> users =  userRepository.findByEmail(user.getEmail());
            if(users.isEmpty()){
                String passEncode = new BCryptPasswordEncoder().encode(user.getPassword());
                userRepository.addUser(user.isGender(),3,user.getEmail(),user.getName(),passEncode,user.getPhonenumber(),user.getBirthday());
                return true;
            }
            return false;
        }catch (Exception err){
            System.err.println(err);
            return false;
        }
    }



}
