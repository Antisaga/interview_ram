package test.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Integers {

	
	public int find_maxsum_of_2_pair_totalmoney(int[] a, int[] b, int n){
		/* int [] a = {3,1};
		 int [] b = {5,2,8};
		 int n = 10;
*/
		 TreeSet<Integer> ts1 = new TreeSet<Integer>(); 
		  
		 	for(int i =0;i<a.length;i++){
			 for(int j=0;j<b.length;j++){
				 ts1.add( a[i]+b[j]); 
			 }
		 	}
		 	
		 	int sum=-1;
		 	for(int temp: ts1){
		 		if(n >=temp) {
		 		 sum =temp;
		 		} 
		 	}
		return sum;
	}

	public void findsum(int[] arr, int sum) {
		Arrays.sort(arr);
		int first = 0;
		int last = arr.length - 1;
		while (first < last) {
			
			int s = arr[first] + arr[last];
			
			if (s == sum) {
				System.out.println("first : " + arr[first] + " last : " + arr[last]);
				first++;
				last--;
			} else { 
				if (s < sum) first++;
				else last--;
			}
		}
	}

	public boolean findsum2(int[] arr, int sum) {
		boolean flag = false;
		Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			myMap.put(arr[i], sum - arr[i]);
		}
		for (Map.Entry<Integer, Integer> entry : myMap.entrySet()) {
			if (myMap.containsKey(entry.getValue()) && (entry.getKey() != entry.getValue())) {
		     flag = true; break;
			}
		}
		return flag;
	}

	long fibonacci_recur(int i) {
		if (i == 0) return 0;
		if (i <= 2) return 1;
		long fibTerm = fibonacci_recur(i - 1) + fibonacci_recur(i - 2);
		return fibTerm;
	}

	void fibonachi(int max) {
		long fibo = 0;
		long fibo2 = 1;
		System.out.println(1 + ": " + fibo);
		for (int i = 2; i < max; i++) {
			fibo = fibo + fibo2;
			fibo2 = fibo - fibo2;
			System.out.println(i + ": " + fibo);
		}
	}

	int calculator(String in) {

		String[] numb = in.split("[+-/*]");
		String[] oper = in.split("\\d+");

		for (String a : numb) {
			System.out.println("numbers " + a);
		}
		for (String a : oper) {
			System.out.println("oper " + a);
		}

		int sum = Integer.parseInt(numb[0]);

		for (int i = 0; i < oper.length; i++) {

			System.out.println("sum[" + i + "] =" + sum);

			if (oper[i].compareTo("*") == 0) {
				sum *= Integer.parseInt(numb[i + 1]);
				i++;

			}
			if (oper[i].compareTo("/") == 0) {
				sum /= Integer.parseInt(numb[i + 1]);
				i++;

			}
			if (oper[i].compareTo("-") == 0) {
				sum -= Integer.parseInt(numb[i + 1]);
				i++;

			}
			if (oper[i].compareTo("+") == 0) {
				sum += Integer.parseInt(numb[i + 1]);
				i++;

			}

		}

		System.out.println("Total sum : " + sum);
		return sum;
	}

	int calc(int num1, int num2, char operation) {
		int result;
		switch (operation) {
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		case '/':
			result = num1 / num2;
			break;
		default:
			System.out.println("Операция не распознана. Повторите ввод.");
			result = calc(num1, num2, operation);// рекурсия
		}
		return result;
	}

	boolean isArmStrong(int amstrong_number) {

		int result = 0;
		int orig = amstrong_number;
		if (amstrong_number < 100) {
			return false;
		}

		while (amstrong_number != 0) {
			int remainder = amstrong_number % 10;
			result = result + ((int) Math.pow(remainder, 3));
			amstrong_number = amstrong_number / 10;
		}

		if (orig == result) {
			return true;
		}

		return false;
	}

	boolean isPerfectNumber(int perfect_number) {
		int temp = 0;
		for (int i = 1; i <= perfect_number / 2; i++) {

			if (perfect_number % i == 0) {
				temp += i;
			}
		}

		if (temp == perfect_number)
			return true;
		else
			return false;
	}
	// find duplicates
	int twochar(int[] s) {
		Arrays.sort(s);
		int count=0;
		for(int i=s.length-1;i>=0;i--){
			if(s[i]==s[i+1]){
				count++;
			}
			System.out.println(s[i] +"  "+count);
		}
		return count;
	}

	//int[] arr = {10,20,20,10,10,30,50,10,20};
	public int find_pair_ofduplicates(int[] arr){
		// key
		//int[] arr = {10,20,20,10,10,30,50,10,20};
		// value
		// quantity of key
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i =0;i<arr.length;i++){
			if(map.containsKey(arr[i]) && map.get(arr[i])>=1){
				int key = map.get(arr[i]);
				map.put(arr[i],key+=1);
			} else {
				map.put(arr[i],1);
			}
		}
		//System.out.println(map.entrySet());
		int total = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() / 2 > 0 )  {
				total = total + entry.getValue() / 2;
			}
		}
		//System.out.println(total);
		return total;
	}
	
	int maxSubArray(int arr[], int size) {
		int i, maxSum, maxGlobalSum;
	    maxSum = maxGlobalSum = arr[0];
	    for (i = 1; i < size; ++i) {
	        maxSum = arr[i] > arr[i] + maxSum ? arr[i] : arr[i] + maxSum;
	        maxGlobalSum = maxSum > maxGlobalSum ? maxSum : maxGlobalSum;
	    }

	    return maxGlobalSum;
	}

	
}
