package gubenko.aleksey.words;

import java.io.FileNotFoundException;

public class App {
	public static void main(String[] args) {

		
		System.out.println(System.getProperty("user.dir"));
		
		try {
			MyFileReader.pickOfConcatenatedWords(MyFileReader
					.addListFromResource(".\\src\\main\\resources\\words.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
