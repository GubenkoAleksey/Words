package gubenko.aleksey.words;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MyFileReader {

	public static List<String> addListFromResource(String path) throws FileNotFoundException {
		
		List<String> list = new LinkedList<>();
		FileReader fileReader = new FileReader(path);
		Scanner scanner = new Scanner(fileReader);
		while (scanner.hasNextLine()) {
			list.add(scanner.nextLine());
		}
		scanner.close();
		return list;
	}

	public static void pickOfConcatenatedWords(List<String> list) {
		
		String[] stringArray = list.toArray(new String[list.size()]);
		list.get(list.size() - 1);
		
		int countOfWords = 0;
		int lengthOfFirstWord = 0;
		int lengthOfSecondWord = 0;
		List<String> listOfFirstWords = new LinkedList<>();
		List<String> listOfSecondWords = new LinkedList<>();
		
		for (int i = 0; i < stringArray.length; i++) {
			Iterator<String> stringIterator = list.iterator();
			while (stringIterator.hasNext()) {
				String nextString = stringIterator.next();
				if (stringArray[i].length() < nextString.length()) {
					if (nextString.contains(stringArray[i])) {
							countOfWords++;
						if (nextString.length() > lengthOfFirstWord) {
							lengthOfFirstWord = nextString.length();
							listOfFirstWords.clear();
							listOfFirstWords.add(nextString);
						} else if (nextString.length() == lengthOfFirstWord) {
							listOfFirstWords.add(nextString);
						} else if(nextString.length() > lengthOfSecondWord){
							lengthOfSecondWord = nextString.length();
							listOfSecondWords.clear();
							listOfSecondWords.add(nextString);
						} else if(nextString.length() == lengthOfSecondWord) {
							listOfSecondWords.add(nextString);
						}
						stringIterator.remove();
					}
				}
			}
		}
		printAnswer(lengthOfFirstWord, listOfFirstWords, lengthOfSecondWord, listOfSecondWords, countOfWords);
		System.out.println("Count of simple words - " + list.size());
		System.out.println("List of simple words - " + list);
		System.out.println("Check of the total count of concatenated words in the file - " + (stringArray.length - list.size()));
	}
	
	public static void printAnswer(int lengthOfFirstWord, List<String> listOfFirstWords,
			int lengthOfSecondWord, List<String> listOfSecondWords, int countOfWords) {
		
		System.out.println("Length of the first word - " + lengthOfFirstWord);
		System.out.println("List of first words - " + listOfFirstWords);
		System.out.println("Length of the second word - " + lengthOfSecondWord);
		System.out.println("List of second words - " + listOfSecondWords);
		System.out.println("The total count of concatenated words in the file - " + countOfWords);
	}
}
