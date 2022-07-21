package me.np99.excellerator.generator;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class DataGenerator {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    JsonNode jsonNode;

    public DataGenerator(XSSFWorkbook workbook, XSSFSheet sheet, JsonNode jsonNode){
        this.workbook = workbook;
        this.sheet = sheet;
        this.jsonNode = jsonNode;
    }

    public void populateData(AtomicInteger rowNumber){

    }


}
