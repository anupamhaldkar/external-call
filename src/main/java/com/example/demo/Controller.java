package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
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

    @GetMapping("/notify-call")
    public ResponseEntity<String> notifyCall(@RequestParam String message){
        log.info("notification called");
        return new ResponseEntity<>("Notified", HttpStatus.ACCEPTED);
    }

    @GetMapping("/notifyDB-call")
    public ResponseEntity<String> notifyDBSave(@RequestParam String message){
        log.info("notification DB called");
        return new ResponseEntity<>("Saved in DB", HttpStatus.ACCEPTED);
    }

}
