package com.onlineorder.onlineorder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller
public class SignInController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    //Only process the failed login request here
    //If login successfully, it will automatically redirect to home page
    @RequestMapping("/login")
    public void login(@RequestParam(value = "error") String error, HttpServletResponse response) throws IOException {
        //Return 400 Bad Request if error
        response.setStatus(HttpStatus.BAD_REQUEST.value());

        //Set the return message as : {"message":"bad credentials"}
        Map<String, Object> data = new HashMap<>();
        data.put("message", "bad credentials");
        response.getOutputStream()
                .println(objectMapper.writeValueAsString(data));
    }
}
