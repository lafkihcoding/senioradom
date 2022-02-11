package com.test.senioradom.senioradom.service;

import com.test.senioradom.senioradom.dao.Position;
import com.test.senioradom.senioradom.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {

    @Autowired
    PositionRepository repository;

    public List<Position> findAllPositions(){
        return repository.findAll();
    }

    public boolean deletePosition(double lat , double lng){
        return repository.deleteByLatitudeAndLongitude(lat,lng);
    }

    public Position createPosition(Position position){
        return repository.save(position);
    }
}
