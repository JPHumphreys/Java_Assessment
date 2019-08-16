package com.qa.javaAssessment;

public class Assessment {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i< input.length(); i++) {
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
		}
		return word;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""

	public String getBert(String input) {
		
		String returnString = "";
		int instancesOfBert = 0;
		int inBetweenBertIndex = 0;
		String bert = "bert";
		input.toLowerCase();//fixes case issue
		
		for(int i = 0; i < input.length(); i++)
		{
			if(input.substring(i, i + bert.length()).equals(bert))
			{
				//checks to see if there is an instance of bert
				instancesOfBert++;
				//saves the index of the end of bert
				inBetweenBertIndex = i + bert.length() + 1;
				//
			}
			else if(inBetweenBertIndex >= i)
			{
				returnString += input.subSequence(i, i + 1);
			}
			
			
		}
		
		if(instancesOfBert == 2)
		{
			return returnString;
		}
		else
		{
			return "";
		}
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false

	public boolean evenlySpaced(int a, int b, int c) {
		
		if(a - b == c || a - b == -c)
		{
			return true;
		}
		else if(a + b == c)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public String nMid(String input, int a) {
		
		String returnString = "";
		int middle = (input.length() / 2) - 1;
		int b = (a + 1)/2;
		
		for(int i = 0; i < input.length(); i++)
		{
			if( i <= middle - b || i > middle + b)
			{
				returnString += input.substring(i, i + 1);
			}
			else
			{
				
			}
		}
		
		
		
		return returnString;
	}


	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	public int superBlock(String input) {
		
		String c = "z";
		int counter = 0;
		int highCounter = 0;
		
		for(int i = 0; i < input.length(); i++)
		{
			if(input.substring(i, i + 1).equals(c))
			{
				counter++;
			}
			else
			{
				c = (String) input.subSequence(i, i + 1);
				if(highCounter < counter)
				{
					highCounter = counter;
					counter = 0;
				}
			}
		}
		
		
		return highCounter;

	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") ==> 1
	//amISearch("I am in Amsterdam am I?") ==> 2
	//amISearch("I have been in Amsterdam") ==> 0

	public int amISearch(String arg1) {
		
		String newString = arg1.toLowerCase();
		String am = "am";
		int counter = 0;
		
		for(int i = 0; i < newString.length(); i++)
		{
			if(i < newString.length() - 3)
			{
				if(newString.substring(i, i + am.length()).equals(am))
				{
					//is am
					if(newString.substring(i, i + (am.length() + 1)).equals(" "))
					{
						System.out.println("hits");//not hitting this why??
						//nothing after
						if( i > 1)
							{
								if(newString.substring(i - 1, i).equals(" "))
								{
									//not surrounded
									System.out.println("huits");
									counter++;
								}
							}
						else
						{
							//at start
							counter++;
						}
					}
				}
			}
			else 
			{
				//out of range
			}
		}
		
		return counter;
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) ==> "fizz"
	//fizzBuzz(10) ==> "buzz"
	//fizzBuzz(15) ==> "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		
		if(arg1 % 3 == 0 && arg1 % 5 == 0)
		{
			//return fizzbuzz
			return "fizzbuzz";
		}
		else if(arg1 % 3 == 0)
		{
			return "fizz";
		}
		else if(arg1 % 5 == 0)
		{
			return "buzz";
		}
		else
		{
			return null;
		}

		
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") ==> 14
	//largest("15 72 80 164") ==> 11
	//largest("555 72 86 45 10") ==> 15
	
	public int largest(String arg1) {
		
		int num = 0;
		int currentHighest = 0;
		
		for(int i = 0; i < arg1.length(); i++)
		{
			if(arg1.substring(i, i + 1).equals(" "))
			{
				num = 0;
			}
			else
			{
				String temp = arg1.substring(i, i + 1);
				
				if(temp.equals("1"))
				{
					num += 1;
				}
				else if(temp.equals("2"))
				{
					num += 2;
				}
				else if(temp.equals("3"))
				{
					num += 3;
				}
				else if(temp.equals("4"))
				{
					num += 4;
				}
				else if(temp.equals("5"))
				{
					num += 5;
				}
				else if(temp.equals("6"))
				{
					num += 6;
				}
				else if(temp.equals("7"))
				{
					num += 7;
				}
				else if(temp.equals("8"))
				{
					num += 8;
				}
				else if(temp.equals("9"))
				{
					num += 9;
				}
				else
				{
					
				}
				
			}
			if(num > currentHighest)
			{
				currentHighest = num;
			}
		}
		
		return currentHighest;
	}
}
