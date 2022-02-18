package com.test.senioradom.senioradom.service;

import com.test.senioradom.senioradom.dao.Position;
import com.test.senioradom.senioradom.repository.PositionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class PositionService {

    @Autowired
    PositionRepository repository;

    public List<Position> findAllPositions() {
        log.info("getting all position from database ");
        return repository.findAll();
    }

    @Transactional
    public void deletePosition(double lat, double lng) {
        log.info("deleting position from database based on lat on lng ");

        repository.deleteByLatitudeAndLongitude(lat, lng);
    }

    @Transactional
    public Position createPosition(Position position) {
        log.info("Create position");

        return repository.save(position);
    }

    public double calculateDistance(double latitude, double longitude, double latitude1, double longitude1) {
        log.info("Calculate distance between two positions  ");

        // Radius of the earth
        final int R = 6371;

        double latDistance = Math.toRadians(latitude1 - latitude);
        double lonDistance = Math.toRadians(longitude1 - longitude);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(latitude1))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        // convert to meters
        double distance = R * c * 1000;

        distance = Math.pow(distance, 2);

        return Math.sqrt(distance);
    }
}
