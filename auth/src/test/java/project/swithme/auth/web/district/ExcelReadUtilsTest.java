package project.swithme.auth.web.district;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("[UnitTest] 엑셀 파일 읽기 테스트")
class ExcelReadUtilsTest {

    private final static SheetHandler excelHandler = ExcelReadUtils.readFileByExcel("testReadExcelData");

    @Test
    @DisplayName("파일을 못읽어 오면 에러가 발생한다.")
    void exceptionByNoneReadFile() {
        assertThatThrownBy(() -> ExcelReadUtils.readFileByExcel("noneTestExcelData"))
            .isExactlyInstanceOf(IllegalArgumentException.class)
            .hasMessage("해당 이름의 엑셀 파일을 찾을 수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("엑셀 헤더를 검증한다.")
    @ValueSource(strings = {"우편번호", "시도", "시도영문", "시군구", "시군구영문", "법정동명", "행정동명"})
    void excelHeaderValidate(String headerName, TestInfo testInfo) {
        assertEquals(headerName, excelHandler.getHeader().get(isNumber(testInfo)));
    }

    @Test
    @DisplayName("엑셀 데이터의 row 수를 검증한다.")
    void excelRowCountValidate() {
        assertEquals(2, excelHandler.getRows().size());
    }

    @Test
    @DisplayName("엑셀 헤더와 데이터개수가 동일한지 검증한다. (빈셀은 빈값으로 들어가는지)")
    void excelRowEqualsHeaderCount() {
        for (List<String> row : excelHandler.getRows()) {
            assertEquals(excelHandler.getHeader().size(), row.size());
        }
    }

    private int isNumber(TestInfo testInfo) {
        Pattern pattern = Pattern.compile("\\[(\\d+)]");
        Matcher matcher = pattern.matcher(testInfo.getDisplayName());
        if (matcher.find()) {
            String group = matcher.group(1);
            return Integer.parseInt(group) - 1;
        }
        return -1;
    }
}
