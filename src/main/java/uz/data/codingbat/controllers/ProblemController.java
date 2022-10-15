package uz.data.codingbat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.data.codingbat.entities.Problem;
import uz.data.codingbat.payloads.ProblemDTO;
import uz.data.codingbat.services.ProblemService;
import uz.data.codingbat.templates.Result;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemService service;

    @GetMapping
    private ResponseEntity<List<Problem>> getProblemList() {
        return ResponseEntity.ok(service.getProblemList());
    }

    @GetMapping("/{problemId}")
    private ResponseEntity<Problem> getProblemById(@PathVariable Integer problemId) {
        return ResponseEntity.ok(service.getProblem(problemId));
    }

    @PostMapping
    private ResponseEntity<Result> addProblem(@Valid @RequestBody ProblemDTO problemDTO) {
        return ResponseEntity
                .status(service.addProblem(problemDTO).getStatus())
                .body(service.addProblem(problemDTO));
    }

    @PutMapping("/{problemId}")
    private ResponseEntity<Result> updateProblem(@Valid @RequestBody ProblemDTO problemDTO,
                                                 @PathVariable Integer problemId) {
        return ResponseEntity
                .status(service.updateProblem(problemDTO, problemId).getStatus())
                .body(service.updateProblem(problemDTO, problemId));
    }

    @DeleteMapping("/{problemId}")
    private ResponseEntity<Result> deleteProblem(@PathVariable Integer problemId) {
        return ResponseEntity
                .status(service.deleteProblem(problemId).getStatus())
                .body(service.deleteProblem(problemId));
    }
}