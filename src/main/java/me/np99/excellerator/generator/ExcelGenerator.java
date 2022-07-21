package me.np99.excellerator.generator;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class ExcelGenerator {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    JsonNode jsonNode;
    String workbookName;
    AtomicInteger rowNumber;
    final HeaderGenerator headerGenerator;
    final DataGenerator dataGenerator;

    public ExcelGenerator(String workbookName, JsonNode jsonNode){
        this.jsonNode = jsonNode;
        this.workbookName = workbookName;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet();
        rowNumber = new AtomicInteger(0);

        headerGenerator = new HeaderGenerator(workbook, sheet, this.jsonNode);
        dataGenerator = new DataGenerator(workbook, sheet, this.jsonNode);
    }

    public Workbook generateExcel() {
        log.info("Generating Excel - {}", workbookName);

        log.info("Generating headers");
        headerGenerator.generateHeaders(rowNumber);

        log.info("Populating data in workbook - {}", workbookName);
        dataGenerator.populateData(rowNumber);

        return workbook;
    }

}
