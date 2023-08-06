package project.swithme.auth.web.district;

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
import org.xml.sax.XMLReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ExcelReadUtils {

    private ExcelReadUtils() {
    }

    public static SheetHandler readFileByExcel(String excelFileName) {
        File excelFile;
        try {
            excelFile = ResourceUtils.getFile("classpath:docs/" + excelFileName +".xlsx");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        SheetHandler sheetHandler = new SheetHandler();
        excelDataParser(excelFile, sheetHandler);
        return sheetHandler;
    }

    private static void excelDataParser(
        File file,
        SheetHandler sheetHandler
    ) {
        try {
            OPCPackage pkg = OPCPackage.open(file);
            XSSFReader xssfReader = new XSSFReader(pkg);
            InputStream sheetStream = xssfReader.getSheetsData().next();
            StylesTable styles = xssfReader.getStylesTable();
            ReadOnlySharedStringsTable data = new ReadOnlySharedStringsTable(pkg);
            ContentHandler handler = new XSSFSheetXMLHandler(styles, data, sheetHandler, false);

            XMLReader sheetParser = SAXHelper.newXMLReader(new XmlOptions());
            sheetParser.setContentHandler(handler);
            sheetParser.parse(new InputSource(sheetStream));
            sheetStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
