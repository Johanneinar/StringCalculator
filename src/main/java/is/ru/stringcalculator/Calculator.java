package is.ru.stringcalculator;

public class Calculator 
{
 
	public static int add(String text)
 	{
 		if(text.equals(""))
 			return 0;
 		else
 		{
 			if(text.contains(","))
 			{
 				String numbers[] = text.split(",|\n");
 				return sum(numbers);
 			}
 			return 1;
 		}
 	}

 	private static int toInt(String number)
 	{
 		return Integer.parseInt(number);
 	}



	private static int sum(String [] numbers)
	{
  		int total = 0;
 		String negativeNumbers = "";
 		boolean isNegative = false;
  		for(String number : numbers)
  		{
 			if(NegativeNumberfound(toInt(number)))
 			{
 				negativeNumbers = returnNegatives(negativeNumbers, number);
 				isNegative = true;
 			}
 			else
 			{
 				total += toInt(number);
 			}
 		}
 
 		if(isNegative)
 		{
 			throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
		}
  		return total;
  	}

  	private static boolean NegativeNumberfound(int number)
  	{
 		return number < 0;
 	}

 	private static String returnNegatives(String negativeNumbers, String number)
 	{
 		
 		if(negativeNumbers.isEmpty())
 		{
 			negativeNumbers += number;
 		}
		else
		{
 			negativeNumbers += "," + number;
 		}
 		return negativeNumbers;
 	}

}

