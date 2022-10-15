package uz.data.codingbat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.data.codingbat.entities.Test;
import uz.data.codingbat.services.TestService;
import uz.data.codingbat.templates.Result;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService service;

    @GetMapping
    private ResponseEntity<List<Test>> getTestList() {
        return ResponseEntity.ok(service.getTestList());
    }

    @GetMapping("/{testId}")
    private ResponseEntity<Test> getTestByID(@PathVariable Integer testId) {
        return ResponseEntity.ok(service.getTest(testId));
    }

    @PostMapping
    private ResponseEntity<Result> addTest(@Valid @RequestBody Test test) {
        return ResponseEntity
                .status(service.addTest(test).getStatus())
                .body(service.addTest(test));
    }

    @PutMapping("/{testId}")
    private ResponseEntity<Result> updateTest(@PathVariable Integer testId,
                                              @Valid @RequestBody Test test) {
        return ResponseEntity
                .status(service.updateTest(test, testId).getStatus())
                .body(service.updateTest(test, testId));
    }

    @DeleteMapping("/{testId}")
    private ResponseEntity<Result> deleteTest(@PathVariable Integer testId) {
        return ResponseEntity
                .status(service.deleteTest(testId).getStatus())
                .body(service.deleteTest(testId));
    }

}