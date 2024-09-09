package change;

import java.util.List;

public interface ChangeMaker {

	public List<Integer> getDenominations();

	public boolean canMakeExactChange(int valueInCents);

	public List<Integer> getExactChange(int valueInCents);

	public int calculateValueOfChangeList(List<Integer> changeList);
}
