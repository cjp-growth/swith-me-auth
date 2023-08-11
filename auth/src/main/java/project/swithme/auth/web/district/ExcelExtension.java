package project.swithme.auth.web.district;

import lombok.Getter;

@Getter
public enum ExcelExtension {
    XLSX(".xlsx", "Excel 통합 문서"),
    XLSM(".xlsm", "Excel 매크로 사용 통합 문서"),
    XLSB(".xlsb", "Excel 바이너리 통합 문서"),
    XLTM(".xltm", "Excel 매크로 사용 서식 파일"),
    XLAM(".xlam", "Excel 추가기능"),
    XLTX(".xltx", "Excel 서식 파일");

    private final String extension;
    private final String explanation;


    ExcelExtension(
        String extension,
        String content
    ) {
        this.extension = extension;
        this.explanation = content;
    }

}
