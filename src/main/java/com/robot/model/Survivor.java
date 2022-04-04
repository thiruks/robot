package com.robot.model;

/*
This model holds the details of Survivor.
 */
public class Survivor {

    private Long id;
    private String name;
    private String age;
    private String gender;
    private String lastLatitude;
    private String lastLongitude;
    private String isInfected;

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastLatitude() {
        return lastLatitude;
    }

    public void setLastLatitude(String lastLatitude) {
        this.lastLatitude = lastLatitude;
    }

    public String getLastLongitude() {
        return lastLongitude;
    }

    public void setLastLongitude(String lastLongitude) {
        this.lastLongitude = lastLongitude;
    }

    public String getIsInfected() {
        return isInfected;
    }

    public void setIsInfected(String isInfected) {
        this.isInfected = isInfected;
    }
}
