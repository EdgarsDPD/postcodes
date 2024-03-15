package edgars.postcodes.compareLists;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class PostcodeComparator {
    public static void main(String[] args) {
        String filename = "POSTALCODE_240401";
        String wNireAddressFile = "C:\\SourceCode\\vsCode\\wNireAddress_240314.csv";
        String rdbPostcodeFile = "C:\\SourceCode\\vsCode\\" + filename + "_sorted.csv";
        String inwNireFileNotInRdbFileResult = "C:\\SourceCode\\vsCode\\" + filename + "_missing.csv";
        try {
            Set<String> wNireAddressPostcode = readPostcodes(wNireAddressFile);
            Set<String> rdbPostcodeFilePostcodes = readPostcodes(rdbPostcodeFile);

            // Compare the sets of postcodes
            Set<String> inwNireFileNotInRdbFile = new HashSet<>(wNireAddressPostcode);
            inwNireFileNotInRdbFile.removeAll(rdbPostcodeFilePostcodes);

            System.out.println("Postcode in " + wNireAddressFile + " but not in " + rdbPostcodeFile + " result in:"
                    + inwNireFileNotInRdbFileResult);
            printPostcodes(inwNireFileNotInRdbFile, inwNireFileNotInRdbFileResult);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    private static void printPostcodes(Set<String> postcodes, String filename) throws IOException {
        // TODO Auto-generated method stub
        try (CSVWriter writer = new CSVWriter(new FileWriter(filename))) {
            for (String postcode : postcodes) {
                writer.writeNext(new String[] { postcode });
            }

        }
    }

    private static Set<String> readPostcodes(String filename)
            throws FileNotFoundException, IOException, CsvValidationException {
        Set<String> poscodes = new HashSet<>();
        try (CSVReader reader = new CSVReader(new FileReader(filename))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                poscodes.add(nextLine[0]);
            }
        }
        return poscodes;
    }
}
