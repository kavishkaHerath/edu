package com.dp.edu.service;

import com.dp.edu.model.output.LoginDetails;
import com.dp.edu.model.tables.Center;
import com.dp.edu.model.tables.User;
import com.dp.edu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CenterInChargeService {
    @Autowired
    private final UserRepository userRepository;

    public CenterInChargeService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoginDetails login(String email, String psw){
        if(userRepository.existsByEmail(email)){
            if (userRepository.existsByPasswordAndEmail(psw, email)){
                User user = userRepository.findByEmail(email);
                var userType = user.getUserType();
                if(userType.equals("CIC")){

                    return new LoginDetails(
                            user.getUserCode(),
                            user.getUsername(),
                            user.getUserType(),
                            user.getCenterInCharge().getCenter().getCenterCode(),
                            "adsd",
                            "0",
                            "success"
                    );
                }
                else{
                    return new LoginDetails(
                            user.getUserCode(),
                            user.getUsername(),
                            user.getUserType(),
                            "",
                            "",
                            "0",
                            "success"
                    );
                }
            }
            else{
                return new LoginDetails(
                        "", "", "", "", "",
                        "-1",
                        "INVALID PASSWORD"
                );
            }
        }else{
            return new LoginDetails(
                    "", "", "", "", "",
                    "-1",
                    "INVALID EMAIL"
            );
        }
    }

}
