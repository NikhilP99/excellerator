package me.np99.excellerator.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;

@Slf4j
public class FileUtils {

    public static void saveExcelFile(Workbook workbook, String filename){
        try (FileOutputStream outputStream = new FileOutputStream(filename)){
            log.info("Saving file - {}", filename);
            workbook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
