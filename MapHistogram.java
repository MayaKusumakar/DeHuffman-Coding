//Team #3
//Histogram

import java.util.*;
import java.io.*;

public class MapHistogram
{
	private Map<Character, Integer> map;
	//Default Constructor for Histogram
	public MapHistogram()
	{
		map = new TreeMap<Character, Integer>();
	}


	//increments the count of character sent to it by one
	public void add(char c)
	{
		if(map.containsKey(c)){
         int num = map.get(c);
         num++;
         map.put(c, num);
      } else {
         int num = 1;
         map.put(c, num);
      }
  	}

	public Map<Character, Integer> getMap()
	{
		return map;
	}

	//returns the count of a specific character
	public int getCount(char c)
	{
		return map.get(c);
  	}

	//calculates the frequency of each character
	//and stores it in proper PIV
		//prints (SOPL) each character and their frequency;
	
	//prints out the Histogram in Frequency order.
	//DO NOT CHANGE THIS
		//Returns a string that has each character and its count
}
