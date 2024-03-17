package com.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Main {

	static final File input = new File("input.csv");
	static final File output = new File("output.csv");
	
	public static void main(String[] args) {
		
		Map<String, String> map =  readCsv(input);
	    Map<String, Double> ansMap = process(map);
		System.out.println(ansMap);
		writeToCsv(ansMap);
	}

	private static void writeToCsv(Map<String, Double> ansMap) {
		try (BufferedWriter bff = new BufferedWriter(new FileWriter(output))) {
			
			for(Map.Entry<String, Double> ent:ansMap.entrySet()) {
				bff.append(ent.getKey()).append(":").append(String.valueOf(ent.getValue())).append(",\n");
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	private static Map<String, Double> process(Map<String, String> map) {
		Map<String, Double> ansMap = new LinkedHashMap<>();
		
		for(Map.Entry<String, String> ent:map.entrySet()) {
			String key = ent.getKey();
			String value = ent.getValue();
			Set<String> visitedSet = new HashSet<>();
			if(value.startsWith("=")) {
				Double sum = calculate(value.substring(1), visitedSet, ansMap, map );
				ansMap.put(key, sum);
			}else {
				ansMap.put(key, Double.parseDouble(value));
			}
		}
		
		return ansMap;
	}

	/*
	        A1: =B1
			B1: =A1+C1
			C1: =B1+A1
			*/
	
	private static Double calculate(String substring, Set<String> visitedSet, Map<String, Double> ansMap,
			Map<String, String> map) {
		
		if(visitedSet.contains(substring)) {
			throw new IllegalArgumentException("Dependency Problem Occurred");
		}
		
		visitedSet.add(substring);
		String[] split = substring.split("\\+");
		System.out.println(Arrays.toString(split));
		double sum = 0;
		for(String v:split) {
			if(map.containsKey(v)) {
				if(ansMap.containsKey(v)) {
					sum+=ansMap.get(v);
				}else {
					sum+=calculate(substring, visitedSet, ansMap, map);
				}
			}else {
				sum+=Double.parseDouble(v);
			}
		}
		visitedSet.remove(substring);
		
		return sum;
	}

	private static Map<String, String> readCsv(File input) {
		Map<String, String> map = new LinkedHashMap<>();
		try ( BufferedReader bff = new BufferedReader(new FileReader(input))) {
			String line;
			while((line=bff.readLine())!=null) {
				String[] split = line.split(",")[0].split(":");
				map.put(split[0].trim(), split[1].trim());
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return map;
	}
	
}
