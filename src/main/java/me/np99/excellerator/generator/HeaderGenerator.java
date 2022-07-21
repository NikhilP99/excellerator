package me.np99.excellerator.generator;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import me.np99.excellerator.utils.CellStyleUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class HeaderGenerator {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    JsonNode jsonNode;

    public HeaderGenerator(XSSFWorkbook workbook, XSSFSheet sheet, JsonNode jsonNode){
        this.workbook = workbook;
        this.sheet = sheet;
        this.jsonNode = jsonNode;
    }

    public void generateHeaders(AtomicInteger rowNumber){
        JsonNode headerNode = jsonNode.isArray() ? jsonNode.get(0) : jsonNode;
        log.info("Generating headers for headerNode - {}", headerNode);

        generateHeaderRow(headerNode, sheet, rowNumber);
    }

    private void generateHeaderRow(JsonNode jsonNode, XSSFSheet sheet, AtomicInteger rowNumber){
        int col = 0;
        int row = rowNumber.getAndIncrement();

        log.info("Generating row number - {}", row);
        Row headerRow = sheet.createRow(row);

        CellStyle headerCellStyle = CellStyleUtil.getHeaderCellStyle(workbook);

        Iterator<String> it = jsonNode.fieldNames();
        while(it.hasNext()){
            log.info("Generating Cell on row - {}, col - {}", row, col);
            Cell headerCell = headerRow.createCell(col++);

            headerCell.setCellValue(it.next());
            headerCell.setCellStyle(headerCellStyle);
        }
    }

}
