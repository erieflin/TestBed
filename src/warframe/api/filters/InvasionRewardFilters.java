package warframe.api.filters;

import java.util.ArrayList;
import java.util.List;

import warframe.api.templates.Alert;
import warframe.api.templates.Invasion;

public class InvasionRewardFilters implements Filter {
	List<Filter> internalFilters;
	public InvasionRewardFilters(Filter internalFilter) {
		ArrayList<Filter> internalFilters = new ArrayList<Filter>();
		internalFilters.add(internalFilter);
		this.internalFilters = internalFilters;

	}
	public InvasionRewardFilters(List<Filter> internalFilters) {
		this.internalFilters = internalFilters;
	}
	
	@Override
	public boolean doesPass(Object o) {
		if(!(o instanceof Invasion)){
			return false;
		}
		Invasion i = (Invasion) o;
		for(Filter filter: internalFilters){
			if(filter.doesPass(i.getAttackerReward()) || filter.doesPass(i.getDefenderReward())){
				return true;
			}
		}
		return false;
	}

}
