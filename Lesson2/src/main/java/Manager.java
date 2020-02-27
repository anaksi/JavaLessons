import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Manager extends User {
    private Integer Salary;

    public static void writeMan(String filePath) {

        File file = new File(filePath);
        Random x = new Random();
        ArrayList<Manager> ManagerList = new ArrayList<Manager>();

        try {
            FileWriter outputfile = new FileWriter(file);

            CSVWriter writer = new CSVWriter(outputfile);

            String[] header = {"Name", "Surname", "Phone", "Salary"};
            writer.writeNext(header);

            for (int i = 0; i < 1000; i++) {
                Manager aManager = new Manager();
                aManager.Name = generateString(x, "abcdfdqqw", 5);
                aManager.Surname = generateString(x, "abcdfdqqw", 5);
                aManager.Phone = ThreadLocalRandom.current().nextInt(1000, 2000);
                aManager.Salary = ThreadLocalRandom.current().nextInt(30000, 50000);
                ManagerList.add(aManager);
                String[] data1 = {ManagerList.get(i).Name, ManagerList.get(i).Surname, ManagerList.get(i).Phone.toString(), ManagerList.get(i).Salary.toString()};
                writer.writeNext(data1);
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}