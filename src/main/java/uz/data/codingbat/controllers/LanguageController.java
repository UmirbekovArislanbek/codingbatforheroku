package uz.data.codingbat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.data.codingbat.entities.Language;
import uz.data.codingbat.services.LanguageService;
import uz.data.codingbat.templates.Result;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    private LanguageService service;

    @GetMapping
    private ResponseEntity<List<Language>> getLanguages() {
        return ResponseEntity.ok(service.getLanguageList());
    }

    @GetMapping("/{languageId}")
    private ResponseEntity<Language> getLanguage(@PathVariable Integer languageId) {
        return ResponseEntity.ok(service.getLanguageById(languageId));
    }

    @PostMapping
    private ResponseEntity<Result> addLanguage(@Valid @RequestBody Language language) {
        return ResponseEntity
                .status(service.addLanguage(language).getStatus())
                .body(service.addLanguage(language));
    }

    @PutMapping("/{languageId}")
    private ResponseEntity<Result> updateLanguage(@Valid @RequestBody Language language,
                                                  @PathVariable Integer languageId) {
        return ResponseEntity
                .status(service.updateLanguage(language, languageId).getStatus())
                .body(service.updateLanguage(language, languageId));
    }

    @DeleteMapping("/{languageId}")
    private ResponseEntity<Result> deleteLanguage(@PathVariable Integer languageId) {
        return ResponseEntity
                .status(service.deleteLanguage(languageId).getStatus())
                .body(service.deleteLanguage(languageId));
    }

}