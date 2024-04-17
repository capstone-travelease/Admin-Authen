package com.capstone.AdminAuthen.Controller;

import com.capstone.AdminAuthen.DTO.LoginRequestDTO;
import com.capstone.AdminAuthen.DTO.ResponseStatusDTO;
import com.capstone.AdminAuthen.DTO.SignUpDTO;
import com.capstone.AdminAuthen.Service.AuthService;
import com.capstone.AdminAuthen.Service.JwtService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtService jwtService;

    public AuthController(AuthService authService, JwtService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;
    }

    @PostMapping(path = "/login")
    public ResponseStatusDTO signIn(@RequestBody @Valid LoginRequestDTO request, HttpServletResponse response) {
        HashMap<String,Object> userData = new HashMap<>();
        var isCheckResponse = authService.Login(request);
        if(isCheckResponse == null){
            response.setStatus(401);
            return new ResponseStatusDTO(response.getStatus(),null,"UNAUTHENTICATED");
        }
        userData.put("userId",isCheckResponse.getUserId());
        userData.put("fullName", isCheckResponse.getFullName());
        userData.put("token",jwtService.createToken(userData,isCheckResponse.getEmail()));
        return new ResponseStatusDTO(response.getStatus(),userData,"OK");
    }

    @PostMapping(path = "/sign")
    public ResponseStatusDTO signUp(@RequestBody @Valid SignUpDTO request, HttpServletResponse response){
        var isCheckRespone = authService.signUp(request);
        if(!isCheckRespone){
            response.setStatus(500);
            return new ResponseStatusDTO(response.getStatus(),null,"INTERNAL_SERVER_ERROR");
        }
        return new ResponseStatusDTO(response.getStatus(),null,"OK");
    }
}
