package edgars.postcodes.generateList;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import edgars.postcodes.Utils.CSVWriterUtil;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UkPostcodeGenerator {
    public static void main(String[] args) throws CsvException {
        String filename = "POSTALCODE_240401";
        String inputFile = "C:\\SourceCode\\vsCode\\" + filename + ".csv";
        String outputFile = "C:\\SourceCode\\vsCode\\" + filename + "_sorted.csv";

        try (CSVReader reader = new CSVReader(new FileReader(inputFile));
                CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                List<String> generatedPostcodes = GeneratePostcode.generatePostcodes(nextLine);
                CSVWriterUtil.writeCSV(writer, generatedPostcodes);

            }
            System.out.println("Generated postcodes saved in :" + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
