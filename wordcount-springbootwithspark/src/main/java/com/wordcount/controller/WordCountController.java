package com.wordcount.controller;

import com.wordcount.service.WordCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WordCountController {

    @Autowired
    WordCountService service;

    @RequestMapping(method = RequestMethod.POST, path = "/topX/{numberOfWords}")
    public Map<String, Long> count(@PathVariable Integer numberOfWords, @RequestParam(required = true) String fileName) {
        return service.getCount(numberOfWords, fileName);
    }
}