package com.niral.hashmapresponse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class HashMapResponseController {
    @GetMapping("/response")
    public Map<String, String> getHashMapResponse() {
        HashMap<String, String> map = new HashMap<>();
        map.put("key-1", "value-1");
        map.put("key-2", "value-2");
        return map;
    }
}
