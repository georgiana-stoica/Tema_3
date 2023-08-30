package com.later.calculator.controllers;

import com.later.calculator.Math;
import com.later.calculator.services.MathService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MathController {

    private final MathService mathService;

    @PostMapping("/do-math")
    public String doMath(@RequestBody List<Math> mathList){
        String fileName = "results.txt";
        mathService.performMathOperations(mathList, fileName);
        return fileName;
    }
    @GetMapping("/check-finished")
    public boolean isFinished(@RequestParam("filename") String fileName){
        return mathService.isFinished(fileName);
    }

    @GetMapping("/results")
    public List<String> showResults(@RequestParam("filename") String fileName){
        return mathService.showResults(fileName);
    }
}
