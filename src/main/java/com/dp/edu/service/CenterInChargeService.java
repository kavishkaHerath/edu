package com.dp.edu.service;

import com.dp.edu.repository.CenterInChargeRepository;
import com.dp.edu.repository.UserRepository;
import com.dp.edu.response.ResponseMessage;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CenterInChargeService {
    @Autowired
    private final UserRepository UserRepository;

    public CenterInChargeService(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    public String login(String email, String psw){
        Gson gson = new Gson();
        if(UserRepository.existsByEmail(email)){
            ResponseMessage rs = new ResponseMessage(
                    "0",
                    "VALID EMAIL",
                    email
            );
            return gson.toJson(rs);

        }else{
            ResponseMessage rs = new ResponseMessage(
                    "-1",
                    "INVALID EMAIL",
                    email
            );
            return gson.toJson(rs);
        }
    }

}
