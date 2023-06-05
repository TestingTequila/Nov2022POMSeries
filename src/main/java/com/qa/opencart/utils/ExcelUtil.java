package com.qa.opencart.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtil {
    private static Workbook book;
    private static Sheet sheet;

    public static Object[][] getTestData(String sheetName) {
        System.out.println("Reading data from sheet : " + sheetName);
        Object data[][] = null;
        try {
            FileInputStream ip = new FileInputStream(Constants.TEST_DATA_SHEET_PATH);
            book = WorkbookFactory.create(ip);
            sheet = book.getSheet(sheetName);
            data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
                for (int i = 0; i < sheet.getLastRowNum(); i++) {
                    for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                        data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        return data;
        }


    }

