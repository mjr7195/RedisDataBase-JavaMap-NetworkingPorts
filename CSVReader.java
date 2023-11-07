import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class CSVReader {
    public static void main(String[] args) {
        String pathToCsv = "service-names-port-numbers.csv"; // replace with your CSV file path
        String line;
        Map<String, String> portDescriptions = new TreeMap<>(); //Sorted

        try (BufferedReader br = new BufferedReader(new FileReader(pathToCsv))) {

            while ((line = br.readLine()) != null) {
                // Use comma as separator
                String[] columns = line.split(",");
                // Print the content on the console
                // for (String column : columns) {
                try {
                    portDescriptions.put(columns[1], columns[3]);
                }catch (Exception e){
                    // dont care
                }
                //}
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // do nothing
        }

        portDescriptions.forEach((key, value) -> System.out.println(key+ " " + value));
        System.out.println("program was able to finish");
    }
}
