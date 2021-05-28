package com.brendhon.parking.api;

import com.brendhon.parking.api.entities.Car;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @author Brendhon
 */
public interface ICarRepository extends JpaRepository<Car, Long>, JpaSpecificationExecutor {

    @Transactional
    Long deleteByName(String name);

}
