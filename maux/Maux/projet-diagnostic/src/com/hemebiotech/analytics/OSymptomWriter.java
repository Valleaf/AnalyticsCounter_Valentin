package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will extract data from Maps and will use that data to output a
 * result file after analysing the data
 */
public interface OSymptomWriter {

    /**
     * If there is no data, will alert the user.
     * 
     * @param Map Extracts the text result of the symptoms and occurences into an
     *            .out file
     */
    boolean generateOutputFile(Map<String, Integer> sortedSymptomsAndOccurences);

}