package edgars.postcodes.Utils;

import java.io.IOException;
import java.util.List;

import com.opencsv.CSVWriter;

public class CSVWriterUtil {
    public static void writeCSV(CSVWriter writer, List<String> postcodes) throws IOException {

        for (String postcode : postcodes) {
            writer.writeNext(new String[] { postcode });
        }

    }
}
