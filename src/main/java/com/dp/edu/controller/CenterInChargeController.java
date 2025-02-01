package com.dp.edu.controller;

import com.dp.edu.model.output.LoginDetails;
import com.dp.edu.service.CenterInChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("centerInCharge")
@CrossOrigin("*")
public class CenterInChargeController {
    @Autowired
    private final CenterInChargeService centerInChargeService;

    public CenterInChargeController(CenterInChargeService centerInChargeService) {
        this.centerInChargeService = centerInChargeService;
    }

    @RequestMapping(path = "/login/{email}/{psw}", method = RequestMethod.GET)
    @ResponseBody
    public LoginDetails login(@PathVariable String email, @PathVariable String psw){
        return centerInChargeService.login(email, psw);
    }
}
