package project.swithme.auth.web.district;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

@DisplayName("엑셀 파일 읽기 테스트")
class ExcelReadUtilsTest {

    private static SheetHandler excelHandler;
    private static int headerCount;

    @BeforeAll
    static void readFileByExcel() {
        excelHandler = ExcelReadUtils.readFileByExcel("testReadExcelData");
        headerCount = 0;
    }

    @Test
    @DisplayName("파일을 못읽어 오면 에러가 발생한다.")
    void exceptionByNoneReadFile() {
        assertThrowsExactly(RuntimeException.class, () -> ExcelReadUtils.readFileByExcel("noneTestExcelData"));
    }

    @DisplayName("엑셀 헤더를 검증한다.")
    @ParameterizedTest
    @ValueSource(strings = {"우편번호", "시도", "시도영문", "시군구", "시군구영문", "법정동명", "행정동명"})
    void excelHeaderValidate(String headerName) {
        assertEquals(headerName, excelHandler.getHeader().get(headerCount));
        headerCount++;
    }

    @Test
    @DisplayName("엑셀 데이터의 row 수를 검증한다.")
    void excelRowCountValidate() {
        assertEquals(excelHandler.getRows().size(), 2);
    }

    @Test
    @DisplayName("엑셀 헤더와 데이터개수가 동일한지 검증한다. (빈셀은 빈값으로 들어가는지)")
    void excelRowEqualsHeaderCount() {
        for (List<String> row : excelHandler.getRows()) {
            assertEquals(excelHandler.getHeader().size(), row.size());
        }
    }
}
