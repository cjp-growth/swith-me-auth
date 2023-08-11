package project.swithme.auth.web.district;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.SAXHelper;
import org.springframework.util.ResourceUtils;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
public final class ExcelReadUtils {

    private ExcelReadUtils() {
        throw new AssertionError("호출 하지 않으려던 생성자가 호출되었습니다.");
    }

    public static SheetHandler readFileByExcel(String excelFileName) {
        File excelFile;
        try {
            excelFile = ResourceUtils.getFile("classpath:docs/" + excelFileName + ExcelExtension.XLSX.getExtension());
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("해당 이름의 엑셀 파일을 찾을 수 없습니다.");
        }
        SheetHandler sheetHandler = new SheetHandler();
        excelDataParser(excelFile, sheetHandler);
        return sheetHandler;
    }

    private static void excelDataParser(
        File file,
        SheetHandler sheetHandler
    ) {
        InputStream rowInputStream = null;
        try (
            OPCPackage opcPackage = OPCPackage.open(file)
        ) {
            XSSFReader xssfReader = new XSSFReader(opcPackage);
            rowInputStream = xssfReader.getSheetsData().next();
            StylesTable styles = xssfReader.getStylesTable();
            ReadOnlySharedStringsTable data = new ReadOnlySharedStringsTable(opcPackage);
            ContentHandler handler = new XSSFSheetXMLHandler(styles, data, sheetHandler, false);

            XMLReader sheetParser = SAXHelper.newXMLReader(new XmlOptions());
            sheetParser.setContentHandler(handler);
            sheetParser.parse(new InputSource(rowInputStream));
        } catch (IOException e) {
            throw new IllegalArgumentException("파일 정보 읽기를 실패하였습니다.");
        } catch (SAXException e) {
            throw new IllegalArgumentException("XML 데이터 구문 분석에 실패하였습니다.");
        } catch (Exception e) {
            throw new RuntimeException("기타 사유로 엑셀 파일 읽기에 실패하였습니다.");
        } finally {
            try {
                if (rowInputStream != null) {
                    rowInputStream.close();
                }
            } catch (IOException e) {
                log.error("아직 파일이 닫히지 않았습니다.", e);
            }
        }
    }
}
