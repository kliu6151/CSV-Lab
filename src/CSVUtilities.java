import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class CSVUtilities {

    ArrayList<String> CSVData;
    int numColumns;

    CSVUtilities(File csv)
    {
        List<String> info = new ArrayList<>();
        Path pathToFile = Paths.get(csv.toString());

        try (BufferedReader br = Files.newBufferedReader(99pathToFile,StandardCharsets.US_ASCII))
        {
            String line = br.readLine();

            while(line != null)
            {
                String[] attributes = line.split(",");

                Data data = newData(attributes);

                info.add(data);

                line = br.readLine();
            }
        } catch (IOException ioe)
        {
            ioe.printStackTrace();
        }

        return info;
    }
    public List<String> getColumnHeaders()
    {

    }
    public List<String> getDataString(int column)
    {

    }
    public List<Integer> getDataInt(int column)
    {

    }
    public List<Double> getDataDouble(int column)
    {

    }
    private static Data newData(String[] data)
    {
        String dataa = data[15];
        return dataa;
    }

    class Data
    {
        private String School;
        private int amountOfTestTaken;
        private int english;
        private int math;
        private int writing;
        public Data(String School, int amountOfTestTaken, int english, int math,int writing)
        {
            this.School = School;
            this.amountOfTestTaken = amountOfTestTaken;
            this.english = english;
            this.math = math;
            this.writing = writing;
        }

        public String getSchool()
        {
            return School;
        }

        public int getAmountOfTestTaken()
        {
            return amountOfTestTaken;
        }

        public int getEnglish()
        {
            return english;
        }

        public int getMath()
        {
            return math;
        }

        public int getWriting()
        {
            return writing;
        }

        public String toString()
        {
            return "School: " + School + "Amount of test taken: " + amountOfTestTaken + "English Score: " + english + "Math Score: " + math + "Writing Score: " + writing;
        }
    }
}
