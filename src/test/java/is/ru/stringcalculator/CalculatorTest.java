package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

 
 public class CalculatorTest {
  
 	@Test
 	public void testEmptyString() 
    {
    	assertEquals(0, Calculator.add(""));
    }

    @Test
 	public void testOneNumber() 
    {
    	assertEquals(1, Calculator.add("1"));
    }

    @Test
 	public void testTwoNumber() 
    {
    	assertEquals(3, Calculator.add("1,2"));
    }

    @Test
 	public void testMultiplesNumbers() 
    {
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
	public void testNewLinesBetweenNumbers() 
	{
		assertEquals(6, Calculator.add("1\n2,3"));
		
	}

	@Test
 	public void testNegativeNumber()
 	{
 		try
 		{
 		Calculator.add("-1,2");
 		}
 		catch (RuntimeException ex)
 		{
 		assertEquals("Negatives not allowed: -1", ex.getMessage());
 		}
 	}

 	@Test
 	public void testMultipleNegativeNumbers()
 	{
 		try
 		{
 		Calculator.add("2,-4,3,-5");
 		}
 		catch(IllegalArgumentException exception)
 		{
 		assertEquals("Negatives not allowed: -4,-5", exception.getMessage());
 		}
 	}

 	@Test
 	public void testNumbersBiggerThan1000()
 	{
 		assertEquals(2, Calculator.add("1001,2"));
 	}


 	@Test
 	public void TestanotherNumbersBiggerThan1000()
 	{
 		assertEquals(16, Calculator.add("6,2,8,5003,9843"));
 	}

 	@Test
    public void testHandleDifferentdelimiter() 
    {
 		assertEquals(3, Calculator.add("//;\n1;2"));
 	}

 	@Test
    public void testanotherHandleDifferentdelimiter() 
    {
 		assertEquals(30, Calculator.add("//;\n1;9;10;4;6"));
 	}
 
 
    
}