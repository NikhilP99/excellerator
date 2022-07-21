package me.np99.excellerator.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Slf4j
public class CellStyleUtil {

    public static CellStyle getHeaderCellStyle(XSSFWorkbook workbook){
        log.info("Creating header cell style");
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setLocked(true);

        cellStyle.setFont(getHeaderFont(workbook));
        cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);

        cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());

        return cellStyle;
    }

    private static Font getHeaderFont(Workbook workbook){
        Font font = workbook.createFont();
        font.setBold(true);
        font.setColor(IndexedColors.BLACK.getIndex());
        return font;
    }

}
