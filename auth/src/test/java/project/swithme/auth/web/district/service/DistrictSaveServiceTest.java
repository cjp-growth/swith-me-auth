package project.swithme.auth.web.district.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import project.swithme.auth.domain.district.entity.District;
import project.swithme.auth.domain.district.service.DistrictService;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("[UnitTest] 엑셀로 주소를 저장하는 서비스 테스트")
class DistrictSaveServiceTest {

    @Autowired
    private DistrictSaveService districtSaveService;
    @Autowired
    private DistrictService districtService;

    @Test
    @DisplayName("전국시군구 엑셀에 있는 데이터로 주소를 저장한다.")
    @Transactional
    void saveDistrictsByExcel() {
        List<District> saveDistrictList = districtSaveService.saveDistrictsByExcel().stream()
            .sorted(Comparator.comparing(District::getDong))
            .toList();


        List<District> allDistrictList = districtService.findAll().stream()
            .sorted(Comparator.comparing(District::getDong))
            .toList();

        assertEquals(3, allDistrictList.size());
        assertEquals(allDistrictList.size(), saveDistrictList.size());

        for (int index = 0; index < allDistrictList.size(); index++) {
            assertEquals(saveDistrictList.get(index), allDistrictList.get(index));
        }
    }
}
