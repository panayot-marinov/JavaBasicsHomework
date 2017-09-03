import java.util.*;
public class StringContainsSubstring {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String[] inputLine = scan.nextLine().split(" ");
		 
		String S = inputLine[0];
		String P = inputLine[1];
		
		System.out.println(Contain(S,P));
	}
	
	public static boolean Contain(String S, String P)
	{
		char[] pArray = new char[P.length()];
		pArray = P.toCharArray();
		
		char[] sArray = new char[S.length()];
		sArray = S.toCharArray();
		
		for(int i = 0; i < P.length(); i++)
		{
			if(pArray[i] == '?')
			{
				return MatchStringWithQuestionMark(sArray, pArray, i);
			}
			
			//else if(pArray[i] == '*')
			//{
				
			//}
			
			else
			{
				for(int j = 0; j < S.length(); j++)
				{
					if(sArray[j] == pArray[i]) {
						return MatchNormal(sArray, pArray, i, j);
					}
				}
				
			}
		}
		return false;
	}
	
	
	public static boolean MatchQuestionMark(char[] sArray, char[] pArray, int i)
	{
		for(int j = 0; j < sArray.length; j++)
		{
			 if(pArray[i] == sArray[j]) return true;
		}
		
		return false;
	}
	
	public static boolean MatchNormal(char[] sArray, char[] pArray, int i, int j)
	{
		boolean result = true;
		
		if(pArray[i] == '?')
			result = MatchQuestionMark(sArray, pArray, i);
		
		else
		{
			try 
			{
				int counter = 0;
				for(int a = j; a < pArray.length + j; a++)
				{			
					if(sArray[a] != pArray[counter] ) return false;
					counter++;
				}
				
				return true && result;
			}
			
			catch(Exception e)
			{
				return false;
			}
			
		}
		
		return false;
	}
	
	public static boolean MatchStringWithQuestionMark(char[] sArray, char[] pArray, int i)
	{
		boolean result = true;
		
		if(pArray[i] == '?')
			result = MatchQuestionMark(sArray, pArray, i);
		
		else
		{
			try 
			{
				int counter = 0;
				for(int a = j; a < pArray.length + j; a++)
				{			
					if(sArray[a] != pArray[counter] ) return false;
					counter++;
				}
				
				return true && result;
			}
			
			catch(Exception e)
			{
				return false;
			}
			
		}
	}
}
