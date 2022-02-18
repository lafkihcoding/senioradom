package com.test.senioradom.senioradom.service;

import com.test.senioradom.senioradom.dao.Position;
import com.test.senioradom.senioradom.repository.PositionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class PositionServiceTest {

    @InjectMocks
    PositionService service;

    @Mock
    PositionRepository repository;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllPositionTest() {
        List<Position> list = new ArrayList<>();
        list.add(new Position(1L, 48.736278, 48.736278, true));
        list.add(new Position(2L, 48.736278, 48.736278, true));
        list.add(new Position(3L, 48.736278, 48.736278, true));
        Mockito.when(repository.findAll()).thenReturn(list);
        //test
        List<Position> empList = service.findAllPositions();

        Assertions.assertEquals(3, empList.size());
    }

    @Test
    public void createPositionTest() {

        Mockito.when(repository.save(new Position())).thenReturn(new Position());
        Position result = service.createPosition(new Position());
        Assertions.assertNotNull(result);

    }

    @Test
    public void deletePositionTest() {

        double latitude = 4.89989;
        double longitude = 4.89989;
        service.deletePosition(latitude, longitude);
        Mockito.verify(repository, times(1)).deleteByLatitudeAndLongitude(latitude, longitude);

    }

    @Test
    public void calculatedistancePositionTest() {

        double result = service.calculateDistance(48.736278, 2.297318, 34.711434, -1.887641);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1597050.941721957, result);


    }
}
