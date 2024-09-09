package change;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ChangeMakerImpl_Flores implements ChangeMaker
{	
	private Set<Integer> denominations;

	public ChangeMakerImpl_Flores(Set<Integer> denominations)
	{
		assert denominations != null; assert !denominations.contains(null);
		assert !containsNegativeInSet(denominations);
		this.denominations = denominations;
	}
	
	public List<Integer> getDenominations()
	{
		List<Integer> denominationsArray = new ArrayList<Integer>();
		Iterator<Integer> it = denominations.iterator();
		while(it.hasNext()) {denominationsArray.add(it.next());}
		Collections.sort(denominationsArray); Collections.reverse(denominationsArray);
		return denominationsArray;
	}
	
	public boolean canMakeExactChange(int valueInCents)
	{	
		assert valueInCents >= 0;
		List<Integer> denominations = getDenominations();
		int[] changeArray = new int[denominations.size()];
		
		// For and while loop keeps subtracting valueInCents by the current denomination index coin
		for (int i = 0; i < denominations.size(); i++) {
			while (denominations.get(i) <= valueInCents) {valueInCents -= denominations.get(i); changeArray[i] += 1;}
		}
		if (valueInCents == 0) {return true;} else {return false;}
	}
	
	public int calculateValueOfChangeList(List<Integer> changeList)
	{
		assert changeList != null; assert !changeList.contains(null);
		assert !containsNegativeInList(changeList);
		List<Integer> denominations = getDenominations(); int valueOfChangeList = 0;
		for(int i = 0; i < changeList.size(); i++) {valueOfChangeList += denominations.get(i) * changeList.get(i);}
		return valueOfChangeList;
	}

	public List<Integer> getExactChange(int valueInCents)
	{
		List<Integer> denominations = getDenominations();
		
		if (denominations.size() == 0) {assert valueInCents == 0;}
		
		int[] changeArray = new int[denominations.size()];
		List<Integer> changeList = new ArrayList<Integer>();
		
		
		
		// For and while loop keeps subtracting valueInCents by the current denomination index coin
		for (int i = 0; i < denominations.size(); i++) {
			while (denominations.get(i) <= valueInCents) {valueInCents -= denominations.get(i); changeArray[i] += 1;}
		}
		for (int j = 0; j < changeArray.length; j++) {changeList.add(changeArray[j]);}
		return changeList;
	}
	
	public String toString()
	{
		return getDenominations().toString();
	}
	
	public boolean containsNegativeInSet(Set<Integer> set) {
		
		Iterator<Integer> it = set.iterator();
		
		while(it.hasNext()) {if(it.next() < 0) {return true;}}
		return false;
		
	}
	public boolean containsNegativeInList(List<Integer> set) {
		
		Iterator<Integer> it = set.iterator();
		
		while(it.hasNext()) {if(it.next() < 0) {return true;}}
		return false;
		
	}
	
}
