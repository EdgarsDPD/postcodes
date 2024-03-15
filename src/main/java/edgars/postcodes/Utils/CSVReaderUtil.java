package edgars.postcodes.Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CSVReaderUtil {
    public static List<String[]> readCSV(String inputFile) throws IOException, CsvException {

        List<String[]> postcodeRanges = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(inputFile))){
            postcodeRanges = reader.readAll();
        }
        return postcodeRanges;
    }
}
