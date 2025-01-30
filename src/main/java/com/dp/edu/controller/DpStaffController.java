package com.dp.edu.controller;

import com.dp.edu.model.output.PCsDetails;
import com.dp.edu.model.request.CenterInChargeDTO;
import com.dp.edu.model.request.CenterRequestDTO;
import com.dp.edu.model.tables.PC;
import com.dp.edu.response.ResponseMessage;
import com.dp.edu.service.DpStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dpStaff")
@CrossOrigin("*")
public class DpStaffController {
    @Autowired
    private final DpStaffService dpStaffService;

    public DpStaffController(DpStaffService dpStaffService) {
        this.dpStaffService = dpStaffService;
    }

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
    @GetMapping(value = "/get/allPCsInCenter/{centerCode}")
    @ResponseBody
    public ResponseEntity<List<PCsDetails>> getPCDetailsByCenterCode(@PathVariable String centerCode) {
        List<PCsDetails> pcDetails = dpStaffService.getAllPCsInCenter(centerCode);
        return ResponseEntity.ok(pcDetails);
    }
    @PostMapping(value = "/insert/pcsInCenter")
    @ResponseBody
    public ResponseEntity<ResponseMessage> addNewPc(@RequestBody PCsDetails pCsDetails) {
        return dpStaffService.addNewPCForCenter(pCsDetails);
    }
}
