package com.slowio.beaninfo;


/**
 *
 */
public class TestBean {
    private String name;
    private int age;
    private Integer yearBorn;
    private Integer monthBorn;
    private Integer dayBorn;
    private String mothersHomeAddress;
    private boolean alive;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(Integer yearBorn) {
        this.yearBorn = yearBorn;
    }

    public Integer getMonthBorn() {
        return monthBorn;
    }

    public void setMonthBorn(Integer monthBorn) {
        this.monthBorn = monthBorn;
    }

    public Integer getDayBorn() {
        return dayBorn;
    }

    public void setDayBorn(Integer dayBorn) {
        this.dayBorn = dayBorn;
    }

    public String getMothersHomeAddress() {
        return mothersHomeAddress;
    }

    public void setMothersHomeAddress(String mothersHomeAddress) {
        this.mothersHomeAddress = mothersHomeAddress;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
