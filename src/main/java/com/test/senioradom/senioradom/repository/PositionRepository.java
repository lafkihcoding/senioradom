package com.test.senioradom.senioradom.repository;

import com.test.senioradom.senioradom.dao.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    void deleteByLatitudeAndLongitude(double latitude , double longitude);
    Position findByLatitudeAndLongitude(double latitude , double longitude);



}
