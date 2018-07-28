package warframe.api.filters;

import java.util.ArrayList;
import java.util.List;

import warframe.api.templates.Event;
import warframe.api.templates.Reward;

public class EventRewardFilter implements Filter {
	List<Filter> internalFilters;
	public EventRewardFilter(Filter internalFilter) {
		ArrayList<Filter> internalFilters = new ArrayList<Filter>();
		internalFilters.add(internalFilter);
		this.internalFilters = internalFilters;

	}
	public EventRewardFilter(List<Filter> internalFilters) {
		this.internalFilters = internalFilters;
	}
	
	@Override
	public boolean doesPass(Object o) {
		if(!(o instanceof Event)){
			return false;
		}
		Event e = (Event) o;
		for(Filter filter: internalFilters){
			for(Reward r: e.getRewards()){
				if(filter.doesPass(r)){
					return true;
				}
			}
		}
		return false;
	}

}
