package com.brendhon.parking.api.service.impl;

import com.brendhon.parking.api.ICarRepository;
import com.brendhon.parking.api.entities.Car;
import com.brendhon.parking.api.service.ICarService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Brendhon
 */
@Service
public class JCarService implements ICarService {

    @Autowired
    private ICarRepository repository;

    public JCarService() {

    }

    @PostConstruct
    private void insertDB() {
        System.out.println("-----------Adicionando população no BD-----------");
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                list.add(new Car("Celta", "Grey", "MGB-7585", "GM"));
            } else {
                list.add(new Car("Ka", "Red", "KBH-7585", "Ford"));
            }
        }
        repository.saveAll(list);
    }

    @Override
    public boolean save(Car car) {
        if (car == null) {
            return false;
        }

        repository.save(car);

        return true;
    }

    @Override
    public boolean delete(Long id) {

        if (id == null) {
            return false;
        }

        repository.deleteById(id);

        return true;
    }

    @Override
    public List<Car> read() {
        return repository.findAll();
    }

    @Override
    public boolean deleteByName(String name) {
        if (name == null) {
            return false;
        }

        repository.deleteByName(name);

        return true;
    }

}
