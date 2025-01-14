package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

/**
 * Anything that will read symptom data from a source The important part is, the
 * return value from the operation, which is a list of strings, that may contain
 * many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates
	 *         are possible/probable
	 */
	List<String> getSymptoms();

	/**
	 * This mnethod filters the duplicates and returns in a list all the symptoms
	 * read from the source. if there is no data, returns an empty list.
	 * 
	 * @param list A list of all symptoms read from the files, possibly containing
	 *             duplicates
	 * @return A Map of all symptoms read from the files and the number of times
	 *         they occur.
	 */
	TreeMap<String, Integer> getUniqueSymptomNames(List<String> list);
}
