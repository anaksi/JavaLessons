import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import com.opencsv.CSVWriter;

public class User {

    protected String Name;
    protected String Surname;
    protected Integer Phone;



    public static String generateString(Random rng, String characters, int length)
    {
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }




    }

