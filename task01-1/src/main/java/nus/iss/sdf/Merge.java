package nus.iss.sdf;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Merge {
    
    public List<Person> csvReader(String csvFile) {
        List<Person> personList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            String line;
            while ((line = br.readLine())!= null) {
                String[] fields = line.split(",");
                String firstName = fields[0];
                String lastName = fields[1];
                String address = fields[2];
                String years = fields[3];

                Person person = new Person(firstName, lastName, address, years);
                personList.add(person);   
            }
            personList.remove(0);
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e.getMessage());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        return personList;
        
    }

    public synchronized String templateReader(String templateFile) throws IOException {
        Path p = Paths.get(templateFile);
        List<String> allLines = Files.readAllLines(p);
        StringBuilder sb = new StringBuilder();
        for (String i : allLines) {
            sb.append(i);
        }
        return sb.toString();   
    }

    // public List<String> templateReader(String templateFile) {
    //     List<String> template = new ArrayList<>();
    //     try {
    //         BufferedReader br = new BufferedReader(new FileReader(templateFile));
    //         String line;
    //         while ((line = br.readLine()) != null) {
    //             template.add(line);
    //         }
            
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }

    //     return template;
    // }
}
