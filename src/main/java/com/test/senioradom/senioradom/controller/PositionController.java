package com.test.senioradom.senioradom.controller;

import com.test.senioradom.senioradom.dao.Position;
import com.test.senioradom.senioradom.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PositionController {
    @Autowired
    PositionService service;

    @GetMapping()
    public ResponseEntity<List<Position>> getAllPositions() {
        List<Position> positions = service.findAllPositions();
        if (positions != null && !positions.isEmpty()) {
            return new ResponseEntity<>(positions, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Position> createPosition(@RequestBody Position position) {
        try {
            Position result = service.createPosition(position);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{latitude}/{longitude}")
    public ResponseEntity<HttpStatus> deletePosition(@PathVariable("latitude") long latitude, @PathVariable("longitude") long longitude) {
        try {
            service.deletePosition(latitude, longitude);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
