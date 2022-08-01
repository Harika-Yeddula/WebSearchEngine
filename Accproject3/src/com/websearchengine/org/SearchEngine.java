package com.websearchengine.org;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class SearchEngine {
			
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to the web search engine");
		System.out.println();
		System.out.println("Press 1 to crawl the web \nPress 2 to search the word \nPress 3 to find Edit distance \nPress 4 to convert files from HTML To Text \nPress 5 to rank the files \nPress 6 to  ");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		switch(number) {
			case 1: 
				Scanner sc2 = new Scanner(System.in);
				WebCrawler webCrawler = new WebCrawler();
				System.out.println("Please enter the link:");
				String link = sc2.nextLine();
				webCrawler.getPageLinks(link);
				System.out.println("Link is searched and done");
				HTMLtoText.generateTextFiles();
				System.out.println("---------------------");
				WebSearch.searchWords();
				break;
			case 2:
				System.out.println("Please enter the words to search them in the files present:");
				WebSearch.searchWords();
				break;
			case 3:
				System.out.println("Please enter the words for finding Edit distance between words:");
				String word1=sc.nextLine();
				String word2=sc.nextLine();
				int distance= EditDistance.minDistance(word1,word2);
                System.out.println("The distance between the words is " +distance);
                break;
			case 4:
				System.out.println("Converting the files from HTML to Text");
				HTMLtoText.generateTextFiles();
				break;
			case 5: 
				System.out.println("Displays the files according to the search appearances");
				WebSearch.searchWords();
				break;
			case 6:
		sc.close();
	}
}
}