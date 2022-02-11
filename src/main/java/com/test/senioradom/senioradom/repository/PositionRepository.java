package com.test.senioradom.senioradom.repository;

import com.test.senioradom.senioradom.dao.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Long> {
    boolean deleteByLatitudeAndLongitude(double latitude , double longitude);


}
