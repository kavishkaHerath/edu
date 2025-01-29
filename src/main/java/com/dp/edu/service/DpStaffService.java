package com.dp.edu.service;

import com.dp.edu.model.Center;
import com.dp.edu.model.District;
import com.dp.edu.model.PC;
import com.dp.edu.model.Province;
import com.dp.edu.model.request.CenterRequestDTO;
import com.dp.edu.repository.CenterRepository;
import com.dp.edu.repository.DistrictRepository;
import com.dp.edu.repository.PCRepository;
import com.dp.edu.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void addCenterWithPCs(CenterRequestDTO centerRequestDTO){
        // Fetch Province and District entities
        Province province = provinceRepository.findById(centerRequestDTO.getProvinceId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Province ID"));

        District district = districtRepository.findById(centerRequestDTO.getDistrictId())
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
    }



}
