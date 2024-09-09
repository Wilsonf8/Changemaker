package change;

import java.util.HashSet;
import java.util.Set;

public class DenominationsTest {

	public static void main(String[] args) {
		Set<Integer> s = new HashSet<Integer>();
		s.add(11);
		s.add(7);
		ChangeMakerImpl_Flores t = new ChangeMakerImpl_Flores(s);
		
		System.out.println(t.canMakeExactChange(3));

	}

}
