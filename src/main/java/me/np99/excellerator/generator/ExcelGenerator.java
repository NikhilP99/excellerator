package me.np99.excellerator.generator;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import me.np99.excellerator.utils.CellStyleUtil;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class ExcelGenerator {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    JsonNode jsonNode;
    String workbookName;
    AtomicInteger rowNumber;
    CellStyle headerCellStyle;

    public ExcelGenerator(String workbookName, JsonNode jsonNode){
        this.jsonNode = jsonNode;
        this.workbookName = workbookName;

        this.workbook = new XSSFWorkbook();
        this.sheet = workbook.createSheet();
        rowNumber = new AtomicInteger(0);
        headerCellStyle = CellStyleUtil.getHeaderCellStyle(workbook);
    }

    public Workbook generateExcel() {
        log.info("Generating Excel - {}", workbookName);

        HeaderGenerator.generateHeaders(jsonNode, sheet, rowNumber, headerCellStyle);

        return workbook;
    }

}
