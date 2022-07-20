package me.np99.excellerator.apis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class InputApi {

    @GetMapping("/excel")
    public String getExcelFromJson(@RequestBody String json){
        log.info(json);
        return json;
    }
}
