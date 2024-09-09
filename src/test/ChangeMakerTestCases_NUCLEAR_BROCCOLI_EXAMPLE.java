package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import change.ChangeMaker;
import change.ChangeMakerImpl_Flores;
import test.ChangeMakerTestCases_STARTER.Points;

public class ChangeMakerTestCases_NUCLEAR_BROCCOLI_EXAMPLE
{
	protected static ChangeMaker changeMaker_STUDENT;
	
	private static Set<Integer> getDenominationSet(Integer[] values)
	{
		Set<Integer> denominationSet = new HashSet<Integer>(Arrays.asList(values));
		assert denominationSet.size() == values.length;
		//STUDENT: add check for null

		return denominationSet;
	}
	
	protected ChangeMaker getChangeMaker(Set<Integer> denominations)
	{
		return new ChangeMakerImpl_Flores(denominations);
	}
	
	@Points(value=5)
	@Test(expected=AssertionError.class)
	public void callConstructorWithNull()
	{
		Set<Integer> denominationSet = null;
		
		changeMaker_STUDENT = getChangeMaker(denominationSet);
	}
	
	@Points(value=5)
	@Test(expected=AssertionError.class)
	public void callConstructorWithNegative()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{1, 5, -6, 9});
		
		changeMaker_STUDENT = getChangeMaker(denominationSet);
	}
	
}

