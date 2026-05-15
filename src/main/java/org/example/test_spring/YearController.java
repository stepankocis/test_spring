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
public class YearController {
    //GET /api/gapminder/year/{year}?continent={continent}
    @GetMapping("/api/gapminder/year/{year}")
    public ArrayList<Country> year(@PathVariable int year, @RequestParam String continent) throws IOException {
        ArrayList<String> inp = new ArrayList<>();
        ArrayList<Country> list = new ArrayList<>();
        Scanner sc = new Scanner(Paths.get("input.csv"));
        sc.nextLine();
        while(sc.hasNext()) {
            String line = sc.nextLine();
            if(line.contains(continent) && line.contains(String.valueOf(year))) {
                inp.add(line);
            }
        }
        for(int i = 0; i < inp.size(); i++) {
            String line = inp.get(i);
            String[] lineSplt = line.split(",");
            list.add(new Country(lineSplt[0], Integer.parseInt(lineSplt[1]), Integer.parseInt(lineSplt[2]), lineSplt[3], Double.parseDouble(lineSplt[4]), Double.parseDouble(lineSplt[5])));
        }

        return list;
    }
}
