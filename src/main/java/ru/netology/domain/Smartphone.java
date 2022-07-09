package ru.netology.domain;
public class Smartphone extends Product{

    private String brand;

    public Smartphone(String id, int price, String name, String brand) {
        super(id, price, name);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
