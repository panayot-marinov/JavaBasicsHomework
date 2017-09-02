import java.util.*;

public class CowsAndBulls {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int[] randomNumbers = Generate4RandomDigits();
		int randomNumber = Generate4DigitRandomNumber(randomNumbers);
		System.out.println(randomNumber);
		
		int inputNumber = Integer.parseInt(scan.nextLine());
		while(inputNumber != randomNumber)
		{
			int cowsCount = 0;
			int bullsCount = 0;
			
			for(int i = 3; i >= 0; i--)
			{
				int currentDigitInputNumber = inputNumber % 10;
				
				if(currentDigitInputNumber == randomNumbers[randomNumbers.length - i - 1]) bullsCount++;
				else if(contains(randomNumbers, currentDigitInputNumber))cowsCount++;
				inputNumber /= 10;
			}
			
			if(bullsCount > 0 && cowsCount>0)System.out.printf("%d bulls and %d cows",bullsCount, cowsCount);
			else if(bullsCount>0)System.out.printf("%d bulls",bullsCount);
			else if(cowsCount>0)System.out.printf("%d cows",cowsCount);
			System.out.println();
			inputNumber = Integer.parseInt(scan.nextLine());
		}
		
		System.out.println("You won!");
		
		scan.close();
	}

	public static boolean contains(int[] array, int key) {
	    for(int i =0; i < array.length;i++)
	    {
	    	if(array[i] == key) return true;
	    }
	    return false;
	}
	
	public static int Generate4DigitRandomNumber(int[] randomNumbers)
	{
		int randomNumber = 0;
		for(int i = 0; i < 4; i++)
		{
			int currentRandomNumber = randomNumbers[i];
			randomNumber = randomNumber + currentRandomNumber * (int)Math.pow(10, i);
		}
		return randomNumber;
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
		for(int j = 0; j <= i; j++)
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
