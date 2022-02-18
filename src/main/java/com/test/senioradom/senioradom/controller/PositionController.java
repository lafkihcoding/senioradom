package com.test.senioradom.senioradom.controller;

import com.test.senioradom.senioradom.dao.Position;
import com.test.senioradom.senioradom.service.PositionService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
@Slf4j
public class PositionController {
    @Autowired
    PositionService service;

    @GetMapping("/all")
    public ResponseEntity<List<Position>> getAllPositions() {
        log.info("getting all position from database ");
        List<Position> positions = service.findAllPositions();
        return new ResponseEntity<>(positions, HttpStatus.OK);

    }

    @PostMapping("/save")
    public ResponseEntity<Position> createPosition(@RequestBody Position position) {
        try {
            log.info("create position  ");
            position.setChecked(false);
            Position result = service.createPosition(position);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{latitude}/{longitude}")
    public ResponseEntity<HttpStatus> deletePosition(@PathVariable("latitude") String latitude, @PathVariable("longitude") String longitude) {
        try {
            log.info("Deleting position from database ");
            service.deletePosition(Double.valueOf(latitude), Double.valueOf(longitude));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/calculate/{latitude}/{longitude}/{latitude1}/{longitude1}")
    public ResponseEntity<Double> calculate(@PathVariable("latitude") double latitude, @PathVariable("longitude") double longitude,
                                            @PathVariable("latitude1") double latitude1, @PathVariable("longitude1") double longitude1) {
        log.info("calculate distance between two position ");
        double distance = service.calculateDistance(latitude, longitude, latitude1, longitude1);
        return new ResponseEntity<>(distance, HttpStatus.OK);
    }
}