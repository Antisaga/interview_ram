package test.core;

import javax.persistence.criteria.CriteriaBuilder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;
import java.util.Map.Entry;


public class App {

	public static boolean sameanagr(String w1, String w2){

		char [] a1 = w1.toCharArray();
		char [] a2 = w2.toCharArray();
		Arrays.sort(a1);
		Arrays.sort(a2);
		return Arrays.equals(a1,a2);
	}

	public static void put(Map<String, List<String>> map, String key, String value){
		if(map.get(key) == null) {
			List<String> list = new ArrayList<>();
			list.add(value);
			map.put(key,list);
		}else{
			map.get(key).add(value);
		}
	}




	public static void main(String[] args) throws AWTException, InterruptedException {

		//Strings s = new Strings();


		Robot localRobot = new Robot();
		for(int i=1;i<10;i++){
			localRobot.keyPress(KeyEvent.VK_CAPS_LOCK);
			Thread.sleep(1000);
			localRobot.keyPress(KeyEvent.VK_COMMA);
			Thread.sleep(1000);
			localRobot.keyPress(KeyEvent.VK_BACK_SPACE);
			Thread.sleep(1000);
			localRobot.keyPress(KeyEvent.VK_CAPS_LOCK);
			Thread.sleep(600000);
			localRobot.keyPress(KeyEvent.VK_F15);
		}

		//s.zip("1112200000000000000000000005555");    // 1(3)2(2)0(22)5(4)
		//s.parse_tags("<p>sometext</p><b>sddddd</b>");
		//s.check_ip(".255.222.23.32");
		List list1= new LinkedList();
		list1.add("1");
		list1.add("2");
		list1.add("3");

		List list2 = new ArrayList();
		list2.add("5");
		list2.add("4");
		list2.add("3");

		System.out.println(Collections.disjoint(list1, list2));


		int sum = 5;
		int[] a= {1,2,3,4,5,6,6};

		Map <Integer, Integer> map;
		map = new HashMap<>();

		for(int i : a){
			map.put(i, sum-i);
		}

		for(Entry<Integer, Integer> entry : map.entrySet()){
			int key = entry.getKey();
			int value = entry.getValue();

			if (map.containsKey(map.get(value))){
				System.out.println("key = " + key + " value = " + value);
			}

		}



		// = FALSE  ne peresikayutsya, Not !retainAll

		int[] arr = {1,2,3,2,3,1,4,6,2,6,3};

		HashMap<Integer, Integer> map = new HashMap<>();

		for(Integer i : arr) {
			if (map.containsKey(i) && map.get(i) >= 1) {
				int key = map.get(i); map.put(i, key += 1);
			} else {
				map.put(i,1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : "  + entry.getValue());
		}



		//System.out.println(sameanagr("abc","cba"));

		//Scanner sc=new Scanner(System.in);
		String A="mada";//sc.next();
		StringBuilder B = new StringBuilder();

		B.append(A).reverse();

		System.out.println(A.equals(B.toString()) ? "Yes" : "No");*/

		//	 Scanner sc = new Scanner(System.in);
//	 String fullline = sc.nextLine();
//	 String[] arr = fullline.split(" ");
//	 int elem =  Integer.parseInt(arr[0]);
//	 String[] array_clean = Arrays.copyOfRange(arr, 1, arr.length);

//	 int sum[] = new int[array_clean.length];
//	 for(int i=0;i<sum.length;i++){
//		 sum[i] = Integer.parseInt(array_clean[i]);
//	 }

	int sum[] = {7, -3, -10, 4, 2, 8, -2, 4, -5, -6};
	int elem = 10;

	System.out.println(maxSubArray(sum,elem));


//	sc = new Scanner(System.in);
//	int digit = sc.nextInt();
	//int digit = 1331234;
//	System.out.println(convert_number_to_words(digit));
	}
	
	static String convert_number_to_words(long number) {
		if (number == 0) { return "0"; }
		    String snumber = Long.toString(number);
		    String mask = "000000000000";
		    DecimalFormat df = new DecimalFormat(mask);
		    snumber = df.format(number);

		    int billions = Integer.parseInt(snumber.substring(0,3));
		    int millions  = Integer.parseInt(snumber.substring(3,6));
		    int hundredThousands = Integer.parseInt(snumber.substring(6,9));
		    int thousands = Integer.parseInt(snumber.substring(9,12));

		    String tradBillions;

		    switch (billions) {
		    case 0: tradBillions = ""; break;
		    case 1: tradBillions = lesshundred(billions) + " Billion "; break;
		    default:tradBillions = lesshundred(billions) + " Billion ";
		    }
		    String result =  tradBillions;

		    String tradMillions;
		    switch (millions) {
		    case 0: tradMillions = ""; break;
		    case 1 : tradMillions = lesshundred(millions) + " Million "; break;
		    default : tradMillions = lesshundred(millions) + " Million ";
		    }
		    result =  result + tradMillions;

		    String tradHundredThousands;
		    switch (hundredThousands) {
		    case 0: tradHundredThousands = ""; break;
		    case 1 :tradHundredThousands = "One Thousand "; break;
		    default :tradHundredThousands = lesshundred(hundredThousands) + " Thousand ";
		    }
		    result =  result + tradHundredThousands;

		    String tradThousand;
		    tradThousand = lesshundred(thousands);
		    result =  result + tradThousand;

		    return result.replaceAll("^\\s+", " ").replaceAll("\\b\\s{2,}\\b", " ")+" Dollars";
		  }
	 static String lesshundred(int number) {
     String[] tensNames = {""," Ten"," Twenty"," Thirty"," Forty"," Fifty"," Sixty"," Seventy"," Eighty"," Ninety" };
     String[] numNames = { ""," One"," Two"," Three"," Four"," Five"," Six"," Seven"," Eight"," Nine"," Ten",
    		 " Eleven"," Twelve"," Thirteen"," Fourteen"," Fifteen"," Sixteen"," Seventeen"," Eighteen"," Nineteen"};
     String soFar;
		    if (number % 100 < 20) {
		      soFar = numNames[number % 100]; number /= 100;
		    } else {
		      soFar = numNames[number % 10]; number /= 10;
		      soFar = tensNames[number % 10] + soFar; number /= 10;
		    } if (number == 0) return soFar;
		    return numNames[number] + " Hundred" + soFar;
		  }
	 static int maxSubArray(int arr[], int size) {
			int i, maxSum, maxGlobalSum;
		    maxSum = maxGlobalSum = arr[0];
		    for (i = 1; i < size; ++i) {
		        maxSum = arr[i] > arr[i] + maxSum ? arr[i] : arr[i] + maxSum;
		        maxGlobalSum = maxSum > maxGlobalSum ? maxSum : maxGlobalSum;
		    }

		    return maxGlobalSum;
		}
}  	
