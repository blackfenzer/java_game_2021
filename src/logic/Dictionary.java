package logic;

import java.io.*;
import java.util.*;

public class Dictionary {
	Scanner listScanner;
	public ArrayList<String> wordList;

	public Dictionary(String path) throws FileNotFoundException {

		listScanner = new Scanner(getClass().getClassLoader().getResourceAsStream(path));
		this.wordList = new ArrayList<String>();
		while (listScanner.hasNextLine()) {
			wordList.add(listScanner.nextLine());
		}
		listScanner.close();

	}

	public ArrayList<String> getWordList() {
		return wordList;
	}

	public void setWordList(ArrayList<String> wordList) {
		this.wordList = wordList;
	}

}
