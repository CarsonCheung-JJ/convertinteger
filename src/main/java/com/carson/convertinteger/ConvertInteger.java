package com.carson.convertinteger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertInteger {
	
	private static final Map<Integer,Letters> map = new HashMap<>(8);
	static {
		map.put(2, new Letters(new char[]{'a','b','c'}));
		map.put(3, new Letters(new char[]{'d','e','f'}));
		map.put(4, new Letters(new char[]{'g','h','i'}));
		map.put(5, new Letters(new char[]{'j','k','l'}));
		map.put(6, new Letters(new char[]{'m','n','o'}));
		map.put(7, new Letters(new char[]{'p','q','r','s'}));
		map.put(8, new Letters(new char[]{'t','u','v'}));
		map.put(9, new Letters(new char[]{'w','x','y','z'}));
	}

	public static void main(String[] args) {
		if(args.length<1) {
			return;
		}
		Integer[] intArray = new Integer[args.length];
		for (int i=0;i<args.length;i++) {
			intArray[i] = Integer.valueOf(args[i]); 
		}
		List<String> listStr = convert(intArray);
		listStr.forEach(str->{
			System.out.print(str+" ");
		});
	}
	
	public static List<String> convert(Integer[] intArray) {
		List<Integer> integerList = new ArrayList<>();
		for (int i=0;i<intArray.length;i++) {
			Integer digit = intArray[i];
			if(digit<0||digit>99) {
				throw new RuntimeException("digit not betwee 0-99");
			} else {
				if(digit/10!=0) {
					integerList.add(digit/10);
				}
				if(digit%10!=0) {
					integerList.add(digit%10);
				}
			}
		}
		List<String> listStr = new ArrayList<>();
		for (Integer digit : integerList) {
			listStr = addLetter(listStr, digit);
		}
		return listStr;
	}


	public static List<String> addLetter(List<String> listStr,Integer digit) {
		if(digit==1||digit==0) {
			return listStr;
		}
		char[] letters = map.get(digit).getLetters();
		if(listStr.isEmpty()) {
			for(int j = 0;j<letters.length;j++) {
				listStr.add(String.valueOf(letters[j]));
			}
			return listStr;
		} else {
			List<String> newListStr = new ArrayList<>();
			listStr.forEach(str->{
				for(int j = 0;j<letters.length;j++) {
					newListStr.add(str+letters[j]);
				}
			});
			return newListStr;
		}
	}
	
}

class Letters {
	
	private char[] letters;
	
	public Letters(char[] letters) {
		this.letters = letters;
	}
	
	public char[] getLetters() {
		return letters;
	}
	
	public void setLetters(char[] letters) {
		this.letters = letters;
	}
	
}