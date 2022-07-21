package me.np99.excellerator.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Slf4j
public class CellStyleUtil {

    public static CellStyle getHeaderCellStyle(XSSFWorkbook workbook){
        log.info("Creating header cell style");
        CellStyle cellStyle = workbook.createCellStyle();

        return cellStyle;
    }

}
