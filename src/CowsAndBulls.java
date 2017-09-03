import java.util.*;

public class CowsAndBulls {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int[] randomNumbers = Generate4RandomDigits();
		System.out.println(numberToString(randomNumbers));
		
		int inputNumber = Integer.parseInt(scan.nextLine());
		int[] inputNumbers = InputNumberToArray(inputNumber);
		while(!Compare(inputNumbers, randomNumbers))
		{
			int cowsCount = 0;
			int bullsCount = 0;
			
			for(int i = 0; i < 4; i++)
			{
				
				if(inputNumbers[i] == randomNumbers[i]) bullsCount++;
				else if(contains(randomNumbers, inputNumbers[i]))cowsCount++;
			}
			
			if(bullsCount > 0 && cowsCount>0)System.out.printf("%d bulls and %d cows",bullsCount, cowsCount);
			else if(bullsCount>0)System.out.printf("%d bulls",bullsCount);
			else if(cowsCount>0)System.out.printf("%d cows",cowsCount);
			System.out.println();
			inputNumber = Integer.parseInt(scan.nextLine());
			inputNumbers = InputNumberToArray(inputNumber);
		}
		
		System.out.println("You won!");
	}

	public static String numberToString(int[] numbers)
	{
		String result = "";
		for(int i = 0; i < numbers.length; i++)
		{
			result += numbers[i];
		}
			
			return result;
	}
	
	public static boolean Compare (int[] Array1, int[] Array2)
	{
		for(int i = 0; i < 4; i++)
		{
			if(Array1[i] != Array2[i]) return false;
		}
		
		return true;
	}
	
	public static int[] InputNumberToArray(int inputNumber)
	{
		int[] inputNumbers = new int[4];
		
		for(int i = 3; i >=0; i--)
		{
			int currentDigit = inputNumber % 10;
			inputNumbers[i] = currentDigit;
			inputNumber /= 10;
		}
		
		return inputNumbers;
	}
	
	public static boolean contains(int[] array, int key) {
	    for(int i =0; i < array.length;i++)
	    {
	    	if(array[i] == key) return true;
	    }
	    return false;
	}
	
	public static int[] Generate4RandomDigits()
	{
		int[] randomNumbers = new int[4];
		
		for(int i = 0; i < 4; i++)
		{
			int currentRandomNumber = GenerateRandomFrom0To9();
			
			if(CheckRepeat(randomNumbers, currentRandomNumber, i))
			{
				i--;
			}
			
			else
			{
				randomNumbers[i] = currentRandomNumber;
			}
		}
		return randomNumbers;
	}
	public static int GenerateRandomFrom0To9()
	{
		int result = (int)(Math.random() * 10);
		return result;
	}
	
	public static boolean CheckRepeat(int[] randomNumbers, int currentRandomNumber, int i)
	{
		boolean repeat = false;
		for(int j = 0; j < i; j++)
		{
			if(randomNumbers[j] == currentRandomNumber)
			{
				repeat = true;
				break;
			}
		}
		
		return repeat;
	}
}
