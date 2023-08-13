package com.hotelraing.JwtAuth.auth;

import com.hotelraing.JwtAuth.externlservice.UserValidationService;
import com.hotelraing.JwtAuth.jwtSecurity.JwtService;
import com.hotelraing.JwtAuth.model.User;
import com.hotelraing.JwtAuth.model.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationService {
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private  AuthenticationManager authenticationManager;

    @Autowired
    private UserValidationService userValidationService;
    public AuthenticationResponse register(RegisterRequest request){
        var user = UserRequest
                .builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        System.out.println("User "+user.toString());
        try{

            UserRequest savedUser =  userValidationService.addUser(user).getBody();
         System.out.println("savedUser"+savedUser.toString()+savedUser.getName());
         var userDetails = User.builder()
                 .email(savedUser.getEmail())
                 .name(savedUser.getName())
                 .password(savedUser.getPassword())
                 .build();
            var jwtToken = jwtService.generateToken(userDetails);
            return AuthenticationResponse
                    .builder()
                    .token(jwtToken)
                    .build();
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
      return null;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){

        authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getEmail(),
                                request.getPassword()));

        var user = userValidationService.userExists(request.getEmail()).getBody();
        System.out.println("User "+user.toString());
        var userDetails = User.builder()
                .email(user.getEmail())
                .name(user.getName())
                .password(user.getPassword())
                .build();
        var jwtToken = jwtService.generateToken(userDetails);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

}
