package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will extract data from text or Lists and will use that data to
 * output a result file after analysing the data
 */
public interface OSymptomWriter {

    /**
     * If there is no data, will alert the user.
     * 
     * @param text Extracts the text result of the occurences of each symptom into
     *             an .out file
     */
    boolean generateOutputFile(Map<String, Integer> sortedSymptomsAndOccurences);

}