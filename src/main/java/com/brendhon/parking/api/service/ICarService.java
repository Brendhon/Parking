package com.brendhon.parking.api.service;

import com.brendhon.parking.api.entities.Car;
import java.util.List;

/**
 *
 * @author administradorti
 */
public interface ICarService {

    public boolean save(Car car);

    public boolean delete(Long id);
    
    public boolean deleteByName(String name);

    public List<Car> read();
}
