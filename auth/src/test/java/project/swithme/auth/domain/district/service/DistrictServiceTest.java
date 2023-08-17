package project.swithme.auth.domain.district.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import project.swithme.auth.domain.district.entity.District;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("[UnitTest] 주소 서비스 테스트")
class DistrictServiceTest {

    @Autowired
    private DistrictService districtService;

    @Test
    @DisplayName("주소 저장하는 로직 테스트")
    @Transactional
    void saveAll() {
        List<District> districtList = new ArrayList<>();
        districtList.add(new District("사당동", "서울특별시"));
        districtList.add(new District("신림동", "서울특별시"));

        List<District> saveList = districtService.saveAll(districtList);

        assertEquals(2, saveList.size());
    }

    @Test
    @DisplayName("주소 전체 조회 하는 로직 테스트")
    @Transactional
    void findAll() {
        List<District> districtList = new ArrayList<>();
        districtList.add(new District("사당동", "서울특별시"));
        districtList.add(new District("신림동", "서울특별시"));

        List<District> saveDistrictList = districtService.saveAll(districtList).stream()
            .sorted(Comparator.comparing(District::getDong))
            .toList();


        List<District> allDistrictList = districtService.findAll().stream()
            .sorted(Comparator.comparing(District::getDong))
            .toList();

        assertEquals(2, allDistrictList.size());
        assertEquals(allDistrictList.size(), saveDistrictList.size());
        assertEquals(saveDistrictList.get(0), allDistrictList.get(0));
        assertEquals(saveDistrictList.get(1), allDistrictList.get(1));
    }
}
