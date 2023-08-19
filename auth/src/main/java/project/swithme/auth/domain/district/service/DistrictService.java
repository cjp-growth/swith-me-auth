package project.swithme.auth.domain.district.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.swithme.auth.domain.district.entity.District;
import project.swithme.auth.domain.district.repository.DistrictJpaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DistrictService {

    private final DistrictJpaRepository districtJpaRepository;

    public List<District> saveAll(List<District> districtList) {
        return districtJpaRepository.saveAll(districtList);
    }

    public List<District> findAll() {
        return districtJpaRepository.findAll();
    }
}
