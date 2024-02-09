package nus.iss.sdf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        String csvFile;
        String templateFile;

        csvFile = args[0];
        templateFile = args[1];

        Merge m = new Merge();
        List<Person> persons = m.csvReader(csvFile);

        try{
            String template = m.templateReader(templateFile);
            for (Person p : persons) {
                String address = p.getAddress().replace("\\n", "\n");
                String firstName = p.getFirstName();
                String years = p.getYears();
                String newTemplate = template;
                newTemplate = newTemplate.replace("__address__" , address + "\n");
                newTemplate = newTemplate.replace("__first_name__" , firstName);
                newTemplate = newTemplate.replace("," , ",\n");
                newTemplate = newTemplate.replace("__years__" , years);

                System.out.println(newTemplate);
                System.out.println("---------------LINE BREAK------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        


        //List<String> template = m.templateReader(templateFile);
        //List<String> newTemplate = new ArrayList<String>();


        // for (Person p : persons) {

        //     String address = p.getAddress().replace("\\n", "\n");
        //     String firstName = p.getFirstName();
        //     String years = p.getYears();

        //     for (String l : template) {
        //         String newLine = "";
        //         if (l.contains("__address__")) {
        //             newLine = l.replace("__address__" , address);
        //         } 
        //         if (l.contains("__first_name__")) {
        //             newLine = l.replace("__first_name__", firstName);
        //         } 
        //         if (l.contains("__years__")) {
        //             newLine = l.replace("__years__", years);
        //         }
                
        //         newTemplate.add(newLine);  
        //     }
        // }
        // for (String l : newTemplate) {
        //     System.out.println(l);
        // }
        
    }
}
