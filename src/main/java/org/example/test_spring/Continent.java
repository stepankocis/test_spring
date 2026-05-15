package org.example.test_spring;

public class Continent {
    private String name;
    private int year;
    private int countryCount;
    private int totalPopulation;
    private double lifeExp;
    private double avgGDP;
    private String highestLifeExp;
    private String lowestLifeExp;

    public Continent(String name, int year, int countryCount, int totalPopulation, double lifeExp, double avgGDP, String highestLifeExp, String lowestLifeExp) {
        this.name = name;
        this.year = year;
        this.countryCount = countryCount;
        this.totalPopulation = totalPopulation;
        this.lifeExp = lifeExp;
        this.avgGDP = avgGDP;
        this.highestLifeExp = highestLifeExp;
        this.lowestLifeExp = lowestLifeExp;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getCountryCount() {
        return countryCount;
    }

    public int getTotalPopulation() {
        return totalPopulation;
    }

    public double getLifeExp() {
        return lifeExp;
    }

    public double getAvgGDP() {
        return avgGDP;
    }

    public String getHighestLifeExp() {
        return highestLifeExp;
    }

    public String getLowestLifeExp() {
        return lowestLifeExp;
    }
}
