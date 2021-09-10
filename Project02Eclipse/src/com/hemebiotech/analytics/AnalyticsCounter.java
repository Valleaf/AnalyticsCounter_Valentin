package com.hemebiotech.analytics;

import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class AnalyticsCounter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Asking the user for the filename containing the symptoms
        System.out.println("Please enter the filsymptoms.txte name");
        String filename = scanner.nextLine();
        scanner.close();
        ReadSymptomDataFromFile rSymptomDataFromFile = new ReadSymptomDataFromFile(filename);

        // Analyse the file and store its content it in a List of String
        List<String> list = rSymptomDataFromFile.getSymptoms();

        // Get the different symptoms by removing the duplicates
        TreeMap<String, Integer> sortedSymptomsAndOccurences = rSymptomDataFromFile.getUniqueSymptomNames(list);

        // Output the results in a file
        ExtractDataFromText extractor = new ExtractDataFromText(sortedSymptomsAndOccurences);
        extractor.extractData();

    }

}
