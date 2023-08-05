package com.swithmeauth.web.district;

import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFComment;

import java.util.ArrayList;
import java.util.List;

public class SheetHandler implements XSSFSheetXMLHandler.SheetContentsHandler {

    private List<List<String>> rows = new ArrayList<>();

    private List<String> row = new ArrayList<>();

    private List<String> header = new ArrayList<>();

    private int currentCol = -1;

    private int currentRowNum = 0;

    public List<String> getHeader() {
        return header;
    }

    public List<List<String>> getRows() {
        return rows;
    }

    public void startRow(int rowNum) {
        this.currentCol = -1;
        this.currentRowNum = rowNum;
    }

    public void endRow(int rowNum) {
        if(rowNum ==0) {
            header = new ArrayList(row);
            row.clear();
            return;
        }
        for (int i = row.size(); i < header.size(); i++) {
            row.add("");
        }
        rows.add(new ArrayList(row));
        row.clear();
    }

    public void cell(String cellName, String value, XSSFComment comment) {
        int iCol = (new CellReference(cellName)).getCol();
        int emptyCol = iCol - currentCol - 1;

        for(int i = 0 ; i < emptyCol ; i++) {
            row.add("");
        }
        currentCol = iCol;
        row.add(value);
    }

    public void headerFooter(String text, boolean isHeader, String tagName) {

    }

}
