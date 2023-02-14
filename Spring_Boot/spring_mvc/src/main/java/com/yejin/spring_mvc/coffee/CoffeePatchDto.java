package com.yejin.spring_mvc.coffee;

public class CoffeePatchDto {
    private long coffeeId;
    private String korname;
    private String price;

    public long getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(long coffeeId) {
        this.coffeeId = coffeeId;
    }

    public String getKorname() {
        return korname;
    }

    public void setKorname(String korname) {
        this.korname = korname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
