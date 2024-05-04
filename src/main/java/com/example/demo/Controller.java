package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class Controller {
    @GetMapping("/external-call")
    public ResponseEntity<Object> externalCall(@RequestParam String message) {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setMessage("Message received");
        return new ResponseEntity<>(requestDTO, HttpStatus.OK);
    }

    @PostMapping("/external-call")
    public ResponseEntity<String> externalSecondCall(@RequestBody RequestDTO requestDTO) {

        return new ResponseEntity<>("Second Message received", HttpStatus.OK);
    }

}
