package com.dp.edu.service;

import com.dp.edu.model.tables.Center;
import com.dp.edu.model.tables.District;
import com.dp.edu.model.tables.PC;
import com.dp.edu.model.tables.Province;
import com.dp.edu.model.request.CenterRequestDTO;
import com.dp.edu.repository.CenterRepository;
import com.dp.edu.repository.DistrictRepository;
import com.dp.edu.repository.PCRepository;
import com.dp.edu.repository.ProvinceRepository;
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

    public DpStaffService(CenterRepository centerRepository, ProvinceRepository provinceRepository, DistrictRepository districtRepository, PCRepository pcRepository) {
        this.centerRepository = centerRepository;
        this.provinceRepository = provinceRepository;
        this.districtRepository = districtRepository;
        this.pcRepository = pcRepository;
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
        } catch (Exception e) {
            return ResponseEntity.ok().body(new ResponseMessage(
                    "-1",
                    "Failed to insert center: " + e.getMessage(),
                    ""
            ));
        }
    }



}
