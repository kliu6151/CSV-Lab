package sample;

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
        this.CSVData = new ArrayList<>();
        Path pathToFile = Paths.get(csv.toString());

        try (BufferedReader br = new BufferedReader(new FileReader(csv)))
        {
            String line = br.readLine();

            while(line != null)
            {
                String[] attributes = line.split(",(?!(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                for(String attr : attributes) this.CSVData.add(attr);
                this.numColumns = attributes.length;

                line = br.readLine();
            }
        } catch (IOException ioe)
        {
            ioe.printStackTrace();
        }

    }
    public List<String> getColumnHeaders()
    {
        return this.CSVData.subList(0, this.numColumns);
    }

    public List<String> getDataString(int column)
    {
        List<String> out = new ArrayList<>();
        int i = this.numColumns + column - 1;

        while(i<CSVData.size())
        {
            out.add(this.CSVData.get(i));
            i+=this.numColumns;
        }
        return out;
    }

    public List<Integer> getDataInt(int column)
    {
        List<Integer> out = new ArrayList<>();
        int i = this.numColumns + column - 1;

        while(i<CSVData.size())
        {
            if (this.CSVData.get(i).length() == 0) {
                out.add(0);
            } else {
                out.add(Integer.parseInt(this.CSVData.get(i)));
            }

            i+=this.numColumns;
        }
        return out;
    }

    public List<Double> getDataDouble(int column)
    {
        List<Double> out = new ArrayList<>();
        int i = this.numColumns + column - 1;

        while(i<CSVData.size())
        {
            if (this.CSVData.get(i).length() == 0) {
                out.add(0d);
            } else {
                out.add(Double.parseDouble(this.CSVData.get(i)));
            }

            i+=this.numColumns;
        }
        return out;
    }
}
