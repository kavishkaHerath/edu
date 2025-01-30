package com.dp.edu.service;

import com.dp.edu.model.output.PCsDetails;
import com.dp.edu.model.request.CenterInChargeDTO;
import com.dp.edu.model.tables.*;
import com.dp.edu.model.request.CenterRequestDTO;
import com.dp.edu.repository.*;
import com.dp.edu.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DpStaffService {
    @Autowired
    private final CenterRepository centerRepository;

    @Autowired
    private final ProvinceRepository provinceRepository;

    @Autowired
    private final DistrictRepository districtRepository;

    @Autowired
    private final PCRepository pcRepository;

    @Autowired
    private final CenterInChargeRepository centerInChargeRepository;

    public DpStaffService(CenterRepository centerRepository, ProvinceRepository provinceRepository, DistrictRepository districtRepository, PCRepository pcRepository, CenterInChargeRepository centerInChargeRepository) {
        this.centerRepository = centerRepository;
        this.provinceRepository = provinceRepository;
        this.districtRepository = districtRepository;
        this.pcRepository = pcRepository;
        this.centerInChargeRepository = centerInChargeRepository;
    }
    public ResponseEntity<ResponseMessage> addCenterWithPCs(CenterRequestDTO centerRequestDTO){
        try{
            if(centerRepository.existsById(centerRequestDTO.getCenterCode())){
                return ResponseEntity.ok().body(new ResponseMessage(
                        "-1",
                        "THE CENTER CODE HAS ALREADY BEEN USED.",
                        ""
                ));
            }
            if(centerRepository.existsByCenterName(centerRequestDTO.getCenterName())){
                return ResponseEntity.ok().body(new ResponseMessage(
                        "-1",
                        "THE CENTER NAME HAS ALREADY BEEN USED.",
                        ""
                ));
            }
            // Fetch Province and District entities
            Province province = provinceRepository.findById(centerRequestDTO.getProvinceID())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Province ID"));

            District district = districtRepository.findById(centerRequestDTO.getDistrictID())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid District ID"));

            Center center = new Center();

            center.setCenterCode(centerRequestDTO.getCenterCode());
            center.setCenterName(centerRequestDTO.getCenterName());
            center.setProvince(province);
            center.setDistrict(district);
            center.setAddress(centerRequestDTO.getAddress());
            center.setUserCode("ADM000");
            center.setCenterAddDate(new Date());

            center = centerRepository.save(center);

            List<PC> pcs = new ArrayList<>();

            for (int i = 1; i < centerRequestDTO.getPcCount(); i++) {
                PC pc = new PC();
                var pcCode = "PC" + center.getCenterCode() + String.format("%02d", i);
                pc.setPcCode(pcCode);
                pc.setCenter(center);
                pc.setStatus(true);
                pc.setRegistrationDate(new Date());
                pcs.add(pc);
            }
            pcRepository.saveAll(pcs);

            return ResponseEntity.ok(new ResponseMessage(
                    "0",
                    "Insert the center successfully.",
                    center.getCenterCode()
            ));
        }
        catch (Exception e) {
            return ResponseEntity.ok().body(new ResponseMessage(
                    "-1",
                    "Failed to insert center: " + e.getMessage(),
                    ""
            ));
        }
    }

    public ResponseEntity<ResponseMessage> addCenterInCharge(CenterInChargeDTO requestDTO){
        try{
            Center center = centerRepository.findById(requestDTO.getCenterCode())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Center Code"));
            
            if(centerInChargeRepository.existsByEmail(requestDTO.getEmail())){
                return ResponseEntity.ok().body(new ResponseMessage(
                        "-1",
                        "CENTER IN CHARGE IS ALREADY INSERT",
                        ""
                        ));
            }

            var count = centerInChargeRepository.countByCenterCode(requestDTO.getCenterCode()) + 1;

            CenterInCharge centerInCharge = getCenterInCharge(requestDTO, count, center);
            centerInChargeRepository.save(centerInCharge);

            return ResponseEntity.ok(new ResponseMessage(
                    "0",
                    "success",
                    centerInCharge.getCenterInChargeCode()
            ));
        }
        catch (Exception e){
            return ResponseEntity.ok().body(new ResponseMessage(
                    "-1",
                    "Could not insert center in charge details: " + e.getMessage(),
                    ""
            ));
        }
    }

    private static CenterInCharge getCenterInCharge(CenterInChargeDTO requestDTO, int count, Center center) {
        var centerInChargeCode = "CIC" + requestDTO.getCenterCode() + String.format("%02d", count);

        CenterInCharge centerInCharge = new CenterInCharge();


        centerInCharge.setCenterInChargeCode(centerInChargeCode);
        centerInCharge.setName(requestDTO.getName());
        centerInCharge.setEmail(requestDTO.getEmail());
        centerInCharge.setPhoneNumber(requestDTO.getPhoneNumber());
        centerInCharge.setAddress(requestDTO.getAddress());
        centerInCharge.setCenter(center);
        centerInCharge.setUserCode("ADM000");
        return centerInCharge;
    }

    public List<PCsDetails> getAllPCsInCenter(String centerCode){
        Center center = centerRepository.findById(centerCode)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Center Code"));
        List<PCsDetails> pcsDetails = new ArrayList<>();
        List<PC> pcs = pcRepository.findByCenter(center);
        for (PC pc : pcs) {
            PCsDetails pc1 = new PCsDetails();
            pc1.setPcsCode(pc.getPcCode());
            pc1.setRegisterDate(String.valueOf(pc.getRegistrationDate()));
            pc1.setCenterCode(centerCode);
            pcsDetails.add(pc1);
        }
        return pcsDetails;
    }


}
