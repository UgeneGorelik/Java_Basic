package JavaBasics;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

public class GenericsStudy {
	
	public static void BoxesTest() {
		ArrayList<Box<String>> list= new ArrayList<>();
		Box<String> box= new Box<String>();
		box.setObj("a");
		Box<String> box1= new Box<String>();
		box1.setObj("123");
		//Compile time checking the below wont work
		///box1.setObj(123);
		list.add(box1);
		list.add(box);
		box.inspect(123);
		//Compile time checking the below wont work
		///box1.setObj(123);
		//box.inspect("123");
	}

    public void UsingPairs(){
    	Pair<String, String> p1= new OrderPair<String, String>("k1","v1");
    	//works without second diamond filled
    	Pair<Integer, String> p2= new OrderPair<>(1,"v1");
    	 	
    	
    	
    }
    
  //Generic Method
    public static <T> void printMe(T[] arr) {
    	for (T x :arr) {
    		System.out.println(x);
    	}
    	
    }
    
	public static void main(String[] args) {
		
		Integer[] iray= {1,2,3};
		Character[] aray= {'a','b','c'};
		printMe(iray);
		
//		ArrayList<String> list= new ArrayList<>();
//		
//		list.add("a");
//		list.add("d");
//		String s=list.get(0);
//		BoxesTest();
		

	}

}
