package nus.iss.sdf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        String csvFile = args[0];
        String templateFile = args[1];

        
        //read CSV template
        try {
            Merge r = new Merge();
            ArrayList<String[]> dataArr = new ArrayList<>(r.readCSVFile(csvFile));
            // for (String[] i : dataArr) {
            //     System.out.println(Arrays.toString(i));

            List<String> templateData = r.readTemplateFile(templateFile);
            List<List<String>> mergedData = new ArrayList<>();
            for (String[] i : dataArr) {
                //System.out.println(Arrays.toString(i));
                List<String> mergeOutput = r.mailMerge(i, templateData);
                mergedData.add(mergeOutput);
            }

            for (List<String> l : mergedData) {
                System.out.println("\\-------------LINE BREAK-------------------\\");
                for (String line : l) {
                    System.out.println(line);
                }
                
            }
            
        } catch (IOException e) {
            System.out.println("File not found " + e.getMessage());
        }
        

    }
}
