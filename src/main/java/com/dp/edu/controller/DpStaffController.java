package com.dp.edu.controller;

import com.dp.edu.model.request.CenterInChargeDTO;
import com.dp.edu.model.request.CenterRequestDTO;
import com.dp.edu.response.ResponseMessage;
import com.dp.edu.service.DpStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dpStaff")
@CrossOrigin("*")
public class DpStaffController {
    @Autowired
    private DpStaffService dpStaffService;

    @PostMapping(value = "/insert/center")
    @ResponseBody
    public ResponseEntity<ResponseMessage> createCenterWithPCs(@RequestBody CenterRequestDTO centerRequestDTO) {
        return dpStaffService.addCenterWithPCs(centerRequestDTO);
    }
    @PostMapping(value = "/insert/centerInCharge")
    @ResponseBody
    public ResponseEntity<ResponseMessage> addCenterInCharge(@RequestBody CenterInChargeDTO requestDTO) {
        return dpStaffService.addCenterInCharge(requestDTO);
    }
}
