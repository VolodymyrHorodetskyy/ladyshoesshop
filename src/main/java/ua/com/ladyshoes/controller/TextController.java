package ua.com.ladyshoes.controller;

import org.springframework.web.bind.annotation.*;
import ua.com.ladyshoes.service.TextService;

@RestController
@CrossOrigin
@RequestMapping("/text")
public class TextController {

    private TextService textService;

    public TextController(TextService textService) {
        this.textService = textService;
    }

    @GetMapping("/itemDescription/{language}")
    private String getItemText(@PathVariable String language) {
        return textService.getItemDescription(language);
    }

    @GetMapping("/itemDescription")
    private String getItemText() {
        return textService.getItemDescription(null);
    }


}
