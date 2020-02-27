

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Developer extends User {
    private Integer Department;

    public static void writeDev(String filePath) {

        File file = new File(filePath);
        Random x = new Random();
        ArrayList<Developer> DeveloperList = new ArrayList<>();

        try {
            FileWriter outputfile = new FileWriter(file);

            CSVWriter writer = new CSVWriter(outputfile);

            String[] header = {"Name", "Surname", "Phone", "Department"};
            writer.writeNext(header);

            for (int i = 0; i < 1000; i++) {
                Developer aDeveloper = new Developer();
                aDeveloper.Name = generateString(x, "abcdfdqqw", 5);
                aDeveloper.Surname = generateString(x, "abcdfdqqw", 5);
                aDeveloper.Phone = ThreadLocalRandom.current().nextInt(1000, 2000);
                aDeveloper.Department = ThreadLocalRandom.current().nextInt(0, 2);
                DeveloperList.add(aDeveloper);
                String[] data1 = {DeveloperList.get(i).Name, DeveloperList.get(i).Surname, DeveloperList.get(i).Phone.toString(), DeveloperList.get(i).Department.toString()};
                writer.writeNext(data1);
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
