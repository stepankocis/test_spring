package org.example.test_spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

@RestController
public class ContinentStatsController {
    @GetMapping("cont/{continent}/stats")
    public Continent task2(@PathVariable String continent, @RequestParam int year) throws IOException {
        System.out.println("kks");
        ArrayList<Country> list = new ArrayList<>();
        ArrayList<String> inp = new ArrayList<>();
        Scanner sc = new Scanner(Paths.get("input.csv"));
        sc.nextLine();
        while(sc.hasNext()) {
            String line = sc.nextLine();
            inp.add(line);
        }
        for(int i = 0; i < inp.size(); i++) {
            String line = inp.get(i);
            String[] lineSplt = line.split(",");
            try {
                boolean contains = !(line.contains("Congo") || line.contains("Hong") || line.contains("Yemen") || line.contains("Korea"));
                if (contains = true) {
                    list.add(new Country(lineSplt[0], Integer.parseInt(lineSplt[1]), Integer.parseInt(lineSplt[2]), lineSplt[3], Double.parseDouble(lineSplt[4]), Double.parseDouble(lineSplt[5])));
                } else {
                    list.add(new Country(lineSplt[0] + lineSplt[1], Integer.parseInt(lineSplt[2]), Integer.parseInt(lineSplt[3]), lineSplt[4], Double.parseDouble(lineSplt[5]), Double.parseDouble(lineSplt[6])));
                }
            } catch(Exception e) {
                System.out.println(e + " " + line);
            }
        }

        int totalPopulation = 0;
        int countryCount = 0;
        int totalLifeExp = 0;
        int totalGdpPC = 0;
        String lowestLifeExpectancy = new String();
        double lowestLE = 0;
        double highestLE = 0;
        String highestLifeExpectancy = new String();
        for(int i = 0; i < list.size(); i++) {
            String continent2 = list.get(i).getContinent();
            if(continent2 == continent) {
                countryCount++;
                totalPopulation += list.get(i).getPopulation();
                totalLifeExp += list.get(i).getLifeExp();
                totalGdpPC += list.get(i).getGdpPerCapita();
                if(list.get(i).getLifeExp() < lowestLE) {
                    lowestLE = list.get(i).getLifeExp();
                    lowestLifeExpectancy = list.get(i).getName();
                }
                if (list.get(i).getLifeExp() > highestLE) {
                    highestLE = list.get(i).getLifeExp();
                    highestLifeExpectancy = list.get(i).getName();
                }
            }
        }
        Continent continentStat = new Continent(continent, year, countryCount, totalPopulation, totalLifeExp/countryCount, totalGdpPC/countryCount, highestLifeExpectancy, lowestLifeExpectancy);
        return continentStat;
    }

}
