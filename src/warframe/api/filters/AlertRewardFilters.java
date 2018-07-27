package warframe.api.filters;

import java.util.ArrayList;
import java.util.List;

import warframe.api.templates.Alert;

public class AlertRewardFilters implements Filter {
	List<Filter> internalFilters;
	public AlertRewardFilters(Filter internalFilter) {
		ArrayList<Filter> internalFilters = new ArrayList<Filter>();
		internalFilters.add(internalFilter);
		this.internalFilters = internalFilters;

	}
	public AlertRewardFilters(List<Filter> internalFilters) {
		this.internalFilters = internalFilters;
	}
	
	@Override
	public boolean doesPass(Object o) {
		if(!(o instanceof Alert)){
			return false;
		}
		Alert a = (Alert) o;
		for(Filter filter: internalFilters){
			if(filter.doesPass(a.getMission().getReward())){
				return true;
			}
		}
		return false;
	}

}
