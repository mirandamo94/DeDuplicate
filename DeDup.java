import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.List;
import java.util.Map;

class DeDup { 
      
    // function to find the element occurring more than 3 times	
    static void get2Occurrences(ArrayList<Integer> arr) 
    { 
    	for(int i=0; i<arr.size(); i++){	
    	    int count=0;
    	    for(int j=0; j<i; j++){	
    	       if(arr.get(j)==arr.get(i)){
    	       count++;
    	       }
    	}
    	if (count>=2){
    	    arr.remove(i);
    	        i--;
    		}
    	}
    	System.out.println("Output Method 1: "+arr);;
    }
    //method 2: using hashset
    static void get2Occurrances2(ArrayList<Integer> arr){
    	
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();
    System.out.print("Output Method 2: ");
    for (Integer a : arr) {
      if (set1.add(a) || set2.add(a)) {
        System.out.print(a + ", ");
      }
    }
    }
    //method 3: using an insert filter add the 2 occurances into a new arraylist
    static void get2Occurrances3(ArrayList<Integer> arr){
	    List<Integer> lst = new ArrayList<>();
	    for (int i : arr) {
	       if (lst.lastIndexOf(i) == lst.indexOf(i)) {
	               lst.add(i);
	       }
	     }
	    System.out.println("Output method 3: "+lst);
    }
    //method 4: using HashMap and .compute() method
    static void get2Occurrances4(ArrayList<Integer> arr){
	    Map<Integer, Integer> counting = new HashMap<>();
	    System.out.println("Output method 4: ");
	    for (Integer current : arr) {
	        int count = counting.compute(current, (x, n) -> n == null ? 1 : n);
	        if (count < 3) {
	            System.out.print(current + ", ");
	        }
	    }
    }
    //method 5: using HashMap and Iterator
    static void get2Occurrances5(ArrayList<Integer> arr){
    	Map<Integer, Integer> control = new HashMap<>();

    	Iterator<Integer> iterator = arr.iterator();
    	System.out.println("Output method 5: ");
    	while(iterator.hasNext()) {
    	   Integer element = iterator.next();
    	   Integer occurrences = control.getOrDefault(element, 0);

    	   if (occurrences >= 2) {
    	       iterator.remove();
    	   } else {
    	       control.put(element, occurrences + 1);
    	       System.out.print(element+ ", ");
    	   }
    	}
    }
    // driver code  
    public static void main(String[] args) 
    { 
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList( 2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2, 10));
        //expected output: 2, 3, 5, 4, 5, 2, 4, 3, 10
        //int n = arr.length; 
        System.out.println("Input: "+arr);
        get2Occurrences(arr); 
        get2Occurrances2(arr);
        get2Occurrances3(arr);
        get2Occurrances4(arr);
        get2Occurrances5(arr);
    } 
} 
