package model;

public class Position {
    private int id;
    private String name;
    private String describe;
    private int quantityLimit;
    private int quantity;

    public Position(String name, String describe, int quantityLimit, int quantity) {
        this.name = name;
        this.describe = describe;
        this.quantityLimit = quantityLimit;
        this.quantity = quantity;
    }

    public Position(int id, String name, String describe, int quantityLimit, int quantity) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.quantityLimit = quantityLimit;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }


    public int getQuantityLimit() {
        return quantityLimit;
    }

    public void setQuantityLimit(int quantityLimit) {
        this.quantityLimit = quantityLimit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
