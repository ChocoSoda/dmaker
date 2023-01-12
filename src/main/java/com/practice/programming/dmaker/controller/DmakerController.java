package com.practice.programming.dmaker.controller;

import com.practice.programming.dmaker.dto.CreateDeveloper;
import com.practice.programming.dmaker.service.DMakerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j //log.info를 사용하기 위해 가져온 annotation
@RequiredArgsConstructor
public class DmakerController {
    private final DMakerService dMakerService;
    @GetMapping("/developers")
    public List<String> getAllDevelopers(){
        //GET /developers HTTP/1.1
        log.info("GET /developers HTTP/1.1");

        return Arrays.asList("Snow", "Elsa", "Olaf");
        // return을 통해 결과값을 받는 것.
    }
    @PostMapping("/create-developer")
    public CreateDeveloper.Response createDevelopers(
            @Valid @RequestBody CreateDeveloper.Request request
            ){
        log.info("request : {}", request);

        return dMakerService.createDeveloper(request);
    }
}
