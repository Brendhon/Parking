package com.brendhon.parking.api.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Brendhon
 */
public class CarDTO {

    private Long id;
    
    @NotEmpty(message = "Nome não pode ser vazio")
    @NotNull(message = "Nome não pode ser NULL")
    private String name;
    
    @NotEmpty(message = "Placa não pode ser vazio")
    @NotNull(message = "Placa não pode ser NULL")
    private String plaque;
    private String color;
    private String mark;

    public CarDTO() {
    }

    public CarDTO(Long id, String name, String color, String plaque, String mark) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.plaque = plaque;
        this.mark = mark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "CarDTO{" + "id=" + id + ", name=" + name + ", color=" + color + ", plaque=" + plaque + ", mark=" + mark + '}';
    }

}
