package nus.iss.sdf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {

    private String first_name;
    private String last_name;
    private String address;
    private String years;
    private List<String> template;
    private List<String[]> output;

    public List<String[]> readCSVFile(String filepath) throws IOException {
        output = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] strArr = line.split(",");
            output.add(strArr);
        }
        output.remove(0);
        return output;
    }

    public List<String> readTemplateFile(String filepath) throws IOException {
        template = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        String line;
        while ((line = br.readLine()) != null) {
            template.add(line);
        }
        return template;
    }

    public List<String> mailMerge(String[] output, List<String> template) {
        List<String> merged = new ArrayList<>();

        for (int k = 0; k < template.size(); k++) {
            String line = template.get(k);
            //System.out.println(Arrays.toString(output));
            String address = output[2];
            address = address.replace("\\n", "\n" );
            //System.out.println(address);
            //System.out.println(line);
            //System.out.println(personInfo[k]);
            if (line.contains("address")) {
                line = line.replace("__address__", address);
            }
            if (line.contains("first_name")) {
                line = line.replace(" __first_name__", (" " + output[0]));
            }
            if (line.contains("years")) {
                line = line.replace(" __years__", (" " + output[3] + " years"));
            }
            merged.add(line);
            //System.out.println(line);
        }
        return merged;
    }
    
    
}
