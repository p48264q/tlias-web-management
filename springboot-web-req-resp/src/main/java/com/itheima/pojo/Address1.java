package com.itheima.pojo;

public class Address1 {
    private String province;
    private String city;

    public String getProvince() {
        return province;
    }

    public void setPiovince(String piovince) {
        this.province = piovince;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address1{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
