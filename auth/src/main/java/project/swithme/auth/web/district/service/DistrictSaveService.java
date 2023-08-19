package project.swithme.auth.web.district.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.swithme.auth.domain.district.entity.District;
import project.swithme.auth.domain.district.service.DistrictService;
import project.swithme.auth.web.district.ExcelReadUtils;
import project.swithme.auth.web.district.SheetHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DistrictSaveService {

    private final DistrictService districtService;

    private static String DONG;
    private static String SIGUNGU;

    public List<District> saveDistrictsByExcel() {
        Set<District> hashSet = getDistrictsByExcel();
        return districtService.saveAll((hashSet.stream().toList()));
    }

    private Set<District> getDistrictsByExcel() {
        SheetHandler sheetHandler = ExcelReadUtils.readFileByExcel("전국시군구");
        Set<District> hashSet = new HashSet<>();
        for (List<String> row : sheetHandler.getRows()) {
            DONG = row.get(3);
            if ("".equals(DONG)) {
                continue;
            }
            SIGUNGU = row.get(2);
            hashSet.add(new District(DONG, SIGUNGU));
        }
        return hashSet;
    }

}
