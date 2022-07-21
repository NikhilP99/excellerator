package me.np99.excellerator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import me.np99.excellerator.generator.ExcelGenerator;
import me.np99.excellerator.utils.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;


@Slf4j
@Component
public class Runner implements CommandLineRunner {

    private final ObjectMapper objectMapper;

    public Runner(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws IOException {
        String workbookName = "textExcel";
        ExcelGenerator excelGenerator = new ExcelGenerator(workbookName, getTestData());
        Workbook workbook = excelGenerator.generateExcel();

        FileUtils.saveExcelFile(workbook, "test.xlsx");
    }

    private JsonNode getTestData() throws IOException {
        File dataFile = new File("testData.json");
        return objectMapper.readTree(dataFile);
    }
}
