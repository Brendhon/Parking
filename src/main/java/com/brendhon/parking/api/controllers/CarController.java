package com.brendhon.parking.api.controllers;

import com.brendhon.parking.api.dtos.CarDTO;
import com.brendhon.parking.api.entities.Car;
import com.brendhon.parking.api.response.JResponseStatus;
import com.brendhon.parking.api.service.ICarService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Brendhon
 */
@RestController
@RequestMapping("api/v1/car")
@CrossOrigin(origins = "*")
public class CarController {

    @Autowired
    private ICarService service;

    @GetMapping
    public ResponseEntity<JResponseStatus<List<CarDTO>>> read() {
        System.out.println("Read Car");
        
        List<Car> list = service.read();
        List<CarDTO> listDTO = new ArrayList<>();

        JResponseStatus<List<CarDTO>> response = new JResponseStatus<>();
        
        // Parce Car to CarDTO
        // List<CarDTO> listDTO = list.stream().map(e -> getCarDTOByCar(e)).collect(Collectors.toList());
        list.forEach((value) -> listDTO.add(getCarDTOByCar(value)));

        response.setData(listDTO);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<JResponseStatus<String>> save(@Valid @RequestBody CarDTO entity) {
        System.out.println("Save Car: " + entity.toString());
        boolean ret = service.save(getCarByDTO(entity));

        JResponseStatus<String> response = new JResponseStatus<>();
        if (ret) {
            response.setData("Saved car success");
            return ResponseEntity.ok(response);
        } else {
            response.setData("Saved car error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(response);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JResponseStatus<String>> delete(@PathVariable("id") Long id) {
        System.out.println("Delete Car: " + id);

        boolean ret = service.delete(id);
        JResponseStatus<String> response = new JResponseStatus<>();

        if (ret) {
            response.setData("Deleted car success");
            return ResponseEntity.ok(response);
        } else {
            response.setData("Deleted car error");
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED)
                    .body(response);
        }

    }

    @DeleteMapping("/name/{name}")
    public ResponseEntity<JResponseStatus<String>> delete(@PathVariable("name") String name) {
        System.out.println("Delete Car by name: " + name);

        boolean ret = service.deleteByName(name);
        JResponseStatus<String> response = new JResponseStatus<>();

        if (ret) {
            response.setData("Deleted car by name success");
            return ResponseEntity.ok(response);
        } else {
            response.setData("Deleted car by name error");
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED)
                    .body(response);
        }

    }

    private Car getCarByDTO(CarDTO dto) {
        Car car = new Car();
        car.setColor(dto.getColor());
        car.setName(dto.getName());
        car.setPlaque(dto.getPlaque());
        car.setMark(dto.getMark());
        car.setId(dto.getId());
        return car;
    }

    private CarDTO getCarDTOByCar(Car car) {
        CarDTO dto = new CarDTO();
        dto.setColor(car.getColor());
        dto.setName(car.getName());
        dto.setPlaque(car.getPlaque());
        dto.setMark(car.getMark());
        dto.setId(car.getId());
        return dto;
    }

}
