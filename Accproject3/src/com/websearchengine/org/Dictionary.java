package com.websearchengine.org;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.TreeMap;

public class Dictionary {
	public static TreeMap<String,String> dictionary(String filename,TreeMap<String,String> aListWords) throws Exception {
		File file = new File(filename);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String str;
		String words[] = null;		 
		while((str = br.readLine()) != null) {
				String tempStr = str.replaceAll("[^a-zA-Z]", "-").toLowerCase();
				words=tempStr.split("-");
				for(int i=0;i<words.length;i++)
					aListWords.put(words[i],words[i]);
		}
		return aListWords;
	}
	
	public static void createDictionary() {
		File directory = new File("/Users/harika/Desktop/ACC-WebSearchEngine-GROUP4/text-files/");
		String[] children = directory.list();
		TreeMap<String,String> aListWords = new TreeMap<String,String>();
		for (String str:children)
		{
			String strx = str.substring(str.lastIndexOf(".")+1);
			if (strx.equals("txt"))
			{
				try {
					dictionary("/Users/harika/Desktop/ACC-WebSearchEngine-GROUP4/text-files/" + "/"+ str,aListWords);
					FileWriter writer = new FileWriter("dictionary.txt"); 
					for(String s: aListWords.values()) {
					  writer.write(s + System.lineSeparator());
					}
					writer.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}