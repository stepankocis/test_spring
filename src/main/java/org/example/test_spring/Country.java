package org.example.test_spring;

public class Country {
    private String name;
    private int year;
    private int population;
    private String continent;
    private double lifeExp;
    private double gdpPerCapita;
    public Country(String name, int year, int population, String continent, double lifeExp,  double gdpPerCapita) {
        this.name = name;
        this.year = year;
        this.population = population;
        this.continent = continent;
        this.lifeExp = lifeExp;
        this.gdpPerCapita = gdpPerCapita;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public double getLifeExp() {
        return lifeExp;
    }

    public double getGdpPerCapita() {
        return gdpPerCapita;
    }

    public String getContinent() {
        return continent;
    }

    public int getPopulation() {
        return population;
    }
}
