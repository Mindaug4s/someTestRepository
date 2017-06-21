package data.providers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDataFileReader {

//	 public static void main(String[] args) {
//	 Object[][] someList =
//	 fillArrayWithDataFromFile(LinksToDataFiles.listOfDistrictCandidates);
//	
//	 System.out.println(Arrays.deepToString(someList));
//	 }

	public static Object[][] fillArrayWithDataFromFile(String fileName) {

		String thisLine;

		BufferedReader myInput = null;

		try {
			myInput = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		List<Object[]> lines = new ArrayList<Object[]>();

		try {
			while ((thisLine = myInput.readLine()) != null) {
				lines.add(thisLine.split(","));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		lines.remove(0);
		String[][] array = new String[lines.size()][0];

		try {
			myInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lines.toArray(array);
	}

}
