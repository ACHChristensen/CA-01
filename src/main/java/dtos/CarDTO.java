/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Car;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tha
 */
public class CarDTO {

    private Integer id;
    private int produced;
    private String make;
    private String model;
    private int price;
    

    public CarDTO(int produced, String make, String model, int price) {
        this.produced = produced;
        this.make = make;
        this.model = model;
        this.price = price;
    }

    public static List<CarDTO> getDtos(List<Car> crs) {
        List<CarDTO> crdtos = new ArrayList();
        crs.forEach(cr -> crdtos.add(new CarDTO(cr)));
        return crdtos;
    }

    public CarDTO(Car cr) {
        this.id = cr.getId();
        this.produced = cr.getProduced();
        this.make = cr.getMake();
        this.model = cr.getModel();
        this.price = cr.getPrice();
    }

    public Integer getId() {
        return id;
    }

    public int getProduced() {
        return produced;
    }

    public void setProduced(int produced) {
        this.produced = produced;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CarDTO{id=").append(id);
        sb.append(", produced=").append(produced);
        sb.append(", make=").append(make);
        sb.append(", model=").append(model);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }



}
