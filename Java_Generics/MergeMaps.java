package JavaBasics;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MergeMaps {

	// a List of Valid Numerical Operations
	public static ArrayList<String> NumOperations = new ArrayList<String>(){{
		add("Sum");
		add("Multiply");
	}};

	// a List of Valid String  Operations
	public static ArrayList<String> StringOperations = new ArrayList<String>(){{
		add("Concat");
	}};	   

	//function to perform addition on Generic values
	public static <V extends Number> V add(V x, V y){
		Double sum;
		sum = x.doubleValue() + y.doubleValue();
		return (V) sum;
	}

	//function to perform multiplication on Generic values
	public static <V extends Number> V mult(V x, V y){
		Double sum;
		sum = x.doubleValue() * y.doubleValue();
		return (V) sum;
	}

	//function to perform Concatenation on Generic values
	public static <V extends String> V Conc(V x, V y){
		String sum;
		sum = x.toString().concat(y.toString()) ;
		return (V) sum;
	}

/// function to Merge a list of Hashmaps 
	public static <K, V> HashMap<K, V> ListMerge(ArrayList<HashMap<K, V>> ListOfMaps,String operation){

//declare result to be returned	
			HashMap<K, V> ResultsMap = new HashMap<K, V>();
//using streams and lambda to loop over the List  in parallel
			ListOfMaps.parallelStream().forEach((x-> {

//using streams and lambda to loop over each map   in parallel and merge to the result
//in case the operation is numeric
				if   (NumOperations.contains(operation))
				{	 
					x.entrySet().parallelStream().forEach((e) -> {
						if (ResultsMap.containsKey(e.getKey())){
							Integer val1 = (Integer) e.getValue();
							Integer val2=  (Integer) ResultsMap.get(e.getKey());
							if (operation.equals("Sum"))
								ResultsMap.put(e.getKey(), (V) add(val1,val2));
							if (operation.equals("Mult"))
								ResultsMap.put(e.getKey(), (V) mult(val1,val2));
						}
						else {
							ResultsMap.put(e.getKey(), e.getValue());
						}

					}); 

				}
//in case the operation is String releated
				if   (StringOperations.contains(operation))
				{	 
					x.entrySet().parallelStream().forEach((e) -> {
						if (ResultsMap.containsKey(e.getKey())){
							String val1 = (String) e.getValue();
							String val2=  (String) ResultsMap.get(e.getKey());
							if (operation.equals("Concat"))
								ResultsMap.put(e.getKey(), (V) Conc(val1,val2));}
						else{
							ResultsMap.put(e.getKey(), e.getValue());
						}
					}); 

				}
			})); 
//return result
			return ResultsMap;	
		}

	
//function that receives 2 maps and performs merge 
	public static   <K, V> HashMap<K, V> MapMerge(HashMap<K, V> h1,HashMap<K, V> h2,String operation) throws Exception {

		//Define Result to return from function 
		HashMap<K, V> ResultsMap = new HashMap<K, V>();

		//if one of the maps is empty return the other one
		if (h1.isEmpty()) {
			return h2;
		}

		if (h2.isEmpty()) {
			return h1;
		}


		//check if either:
		// the requested operation is Numerical and the Values of the Hashmaps are Integers
		// the requested operation should be performed on Strings and the Values of the Hashmaps are Strings

		K firstKey = h1.keySet().iterator().next();

		V firstvalue=h1.get(firstKey);

		K secKey = h2.keySet().iterator().next();

		V secvalue=h2.get(secKey);

		Boolean flag=(((NumOperations.contains(operation) && ((firstvalue instanceof  Integer)
				||(secvalue instanceof  Integer)))) ||
				((StringOperations.contains(operation)
						&& (firstvalue instanceof  String)
						||(secvalue instanceof  String))));

		//if the input is wrong Throw Exception that the input is incorrect and exit		
		if (!flag)
		{
			System.out.println("Wrong arguments were passed to the function");
			throw new Exception();
		}

		//loop over the Keyset of both Maps and put the values in a result map
		Set<K> keySet = new HashSet<K>();
		keySet.addAll(h1.keySet());
		keySet.addAll(h2.keySet());

		//if the operation is either Number releated
		if   (NumOperations.contains(operation))
		{	 
			Integer val1, val2;
			for (K key : keySet) {
				val1 = (Integer) h1.get(key);
				val1 = (val1 == null ? 0 : val1);
				val2 = (Integer) h2.get(key);
				val2 = (val2 == null ? 0 : val2);
				if (operation.equals("Sum"))
					ResultsMap.put(key, (V) add(val1,val2));
				if (operation.equals("Multiply"))
					ResultsMap.put(key, (V) mult(val1,val2));
			}
		}
		//if the operation is String releated
		else
		{
			String val1, val2;
			for (K key : keySet) {
				val1 = (String) h1.get(key);
				val1 = (val1 == null ? "" : val1);
				val2 = (String) h2.get(key);
				val2 = (val2 == null ? "" : val2);
				if (operation.equals("Concat"))
					ResultsMap.put(key, (V) Conc(val1,val2));
			}

		}
		return  ResultsMap;
	}

	

	public static void main(String[] args) throws Exception {
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();

		/*Adding elements to HashMap*/
		//		hmap.put(1, "Chaitanya");
		//
		//		HashMap<Integer, String> hmap2 = new HashMap<Integer, String>();
		//
		//		/*Adding elements to HashMap*/
		//		hmap2.put(1, "dick");
		//		hmap2.put(2, "alice");

		HashMap< String,Integer> hmap4 = new HashMap<String,Integer>();
		hmap4.put("A", 1);



		HashMap< String,Integer> hmap5 = new HashMap<String,Integer>();
		hmap5.put("A", 2);
		hmap5.put("B", 3);
		hmap5.put("C", 3);
		//
		////			HashMap< String,Integer> hmap3= printMe(hmap,hmap1,"Multiply");
		//		    HashMap<Integer, String> hmap4= MapMerge(hmap,hmap2,"Concat");
		//
		//				      Set<Integer> keySet = new HashSet<Integer>();
		//				      keySet.addAll(hmap4.keySet());
		//				      
		//				      
		//				      for (  Integer key : keySet) {
		//				            System.out.println(key + " :  "+hmap4.get(key));
		//				        }
		//					 

		ArrayList<HashMap<String, Integer>> l= new ArrayList<>();
		l.add(hmap4);
		l.add(hmap5);
		HashMap<String, Integer> l1=ListMerge(l,"Sum");

		Set<String> keySet = new HashSet<String>();
		keySet.addAll(l1.keySet());


		for (  String key : keySet) {
			System.out.println(key + " :  "+l1.get(key));
		}



	}

}
