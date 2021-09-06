package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.awt.Desktop;
import java.io.File;
import java.util.Map.Entry;

public class ExtractDataFromText implements OSymptomWriter {

    private Map<String, Integer> sortedSymptomsAndOccurences;

    /**
     * 
     * @param Map containing the symptoms and occurences.
     */
    public ExtractDataFromText(Map<String, Integer> sortedSymptomsAndOccurences) {
        this.sortedSymptomsAndOccurences = sortedSymptomsAndOccurences;
    }

    @Override
    public boolean generateOutputFile(Map<String, Integer> sortedSymptomsAndOccurences) {

        // If file is empty, we just return an error and false.
        if (!sortedSymptomsAndOccurences.isEmpty()) {

            try (FileWriter writer = new FileWriter("result.out")) {

                // We loop through the entries and write line by line the results.
                for (Entry<String, Integer> line : sortedSymptomsAndOccurences.entrySet()) {

                    writer.write(line.getKey() + " : " + line.getValue() + "\n");
                }
                System.out.println("\nOutput file generated successfully.");
                return true;

            } catch (IOException e) {
                System.err.println("Error generating output file, check your configuration and permissions.");
                return false;
            }
        } else
            System.err.println("No data");
        return false;
    }

    /**
     * Extracts the data from the lists to output a results file containing the
     * symptoms and the number of time they occur
     */
    public void extractData() {
        if (generateOutputFile(sortedSymptomsAndOccurences))
        // Opens the file in the user's default text viewer
        {
            try {
                File file = new File("result.out");
                Desktop desktop = Desktop.getDesktop();
                desktop.open(file);
            } catch (Exception e) {
                System.err.println("Error opening output file.");
            }
        }
    }

}
