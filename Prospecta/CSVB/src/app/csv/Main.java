package app.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Main {

	public static final File input_path = new File("input.csv");
	public static final File output_path = new File("output.csv");
	
	public static void main(String[] args) {
		
		Map<String,String> map = readFile(input_path);
//		System.out.println(map);
		Map<String,Double> processded =  process(map);
		System.out.println(processded);
		write(processded);
		
	}

	private static void write(Map<String, Double> processded) {
		try( BufferedWriter bfWriter = new BufferedWriter(new FileWriter(output_path) ) ) {
			
			for(Map.Entry<String, Double> ent:processded.entrySet()) {
				bfWriter.append(ent.getKey()).append(":").append(String.valueOf(ent.getValue())).append(",\n");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static Map<String, Double> process(Map<String, String> map) {
		
		Map<String, Double> ansMap = new LinkedHashMap<>();
		
		for(Map.Entry<String, String> ent: map.entrySet()) {
//			System.out.println(ent);
			String key = ent.getKey();
			String value = ent.getValue();
			
			Set<String> visited = new HashSet<>();
			if(value.startsWith("=")) {
				Double cal = calculate(value.substring(1), ansMap, visited, map);
//				System.out.println(cal);
				ansMap.put(key, cal);
			}else {
				ansMap.put(key, Double.parseDouble(value));
			}
		}
		
		
		return ansMap;
	}

	private static Double calculate(String value, Map<String, Double> ansMap, Set<String> visited, Map<String, String> originalMap) {
		
	    if (visited.contains(value)) {
	        throw new IllegalArgumentException("Circular dependency detected for key: " + value);
	    }

	    visited.add(value);

	    String[] split = value.split("\\+");
	    double sum = 0;
	    for (String val : split) {
	        if (originalMap.containsKey(val)) {
	            if (ansMap.containsKey(val)) {
	                sum += ansMap.get(val);
	            } else {
	                sum += calculate(originalMap.get(val), ansMap, visited, originalMap);
	            }
	        } else {
	            sum += Double.parseDouble(val);
	        }
	    }

	    visited.remove(value);
	    return sum;
	}

	private static Map<String, String> readFile(File inputPath) {
	
		Map<String, String> map = new LinkedHashMap<>();
		
		try( BufferedReader bff = new BufferedReader(new FileReader(inputPath)) ){
			String read;
			while ((read=bff.readLine())!=null) {
				String[] split = read.split(",")[0].split(":");
				map.put(split[0].trim(), split[1].trim());
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return map;		
	}
	
}
