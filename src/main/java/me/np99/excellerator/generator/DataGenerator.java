package me.np99.excellerator.generator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Iterator;
import java.util.Map;
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
        log.info("Populating data from jsonNode - {}", jsonNode);
        if(jsonNode.isArray()){
            for(JsonNode node : jsonNode){
                populateRow(node, rowNumber);
            }
        }else{
            populateRow(jsonNode, rowNumber);
        }
    }

    private void populateRow(JsonNode node, AtomicInteger rowNumber){
        int col = 0;
        int row = rowNumber.getAndIncrement();
        Row dataRow = sheet.createRow(row);

        ObjectNode objectNode = (ObjectNode) node;
        Iterator<Map.Entry<String, JsonNode>> it = objectNode.fields();
        while(it.hasNext()){
            Map.Entry<String, JsonNode> entry = it.next();
            String key = entry.getKey();
            JsonNode data = entry.getValue();

            log.info("Generating Cell on row - {}, col - {}", row, col);
            Cell cell = dataRow.createCell(col++);

            if(data.isTextual()){
                cell.setCellValue(data.textValue());
            }else if(data.isInt()){
                cell.setCellValue(data.intValue());
            }else if(data.isNumber()){
                cell.setCellValue(data.doubleValue());
            }else if(data.isNull()){
                cell.setCellValue("-");
            }else{
                log.error("No parser found for value - {}", data);
            }
        }
    }


}
