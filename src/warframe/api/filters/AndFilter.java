package warframe.api.filters;

import java.util.ArrayList;
import java.util.List;

public class AndFilter implements Filter {
	private List<Filter> firstFilters;
	private List<Filter> secondFilters;

	public AndFilter(Filter firstFilter, Filter secondFilter) {
		this.setFirstFilter(firstFilter);
		this.setSecondFilter(secondFilter);
	}

	public AndFilter(Filter firstFilter, List<Filter> secondFilters) {
		this.setFirstFilter(firstFilter);
		this.setSecondFilters(secondFilters);
	}

	public AndFilter(List<Filter> firstFilters, Filter secondFilter) {
		this.setFirstFilters(firstFilters);
		this.setSecondFilter(secondFilter);
	}

	public AndFilter(List<Filter> firstFilter, List<Filter> secondFilter) {
		this.setFirstFilters(firstFilter);
		this.setSecondFilters(secondFilter);
	}

	@Override
	public boolean doesPass(Object o) {
		// TODO Auto-generated method stub
		boolean firstPasses = false;
		boolean secondPasses = false;
		for (Filter filter : firstFilters) {
			if (filter.doesPass(o)) {
				firstPasses = true;
			}
		}
		for (Filter filter : secondFilters) {
			if (filter.doesPass(o)) {
				secondPasses = true;
			}
		}
		return firstPasses && secondPasses;
	}

	public List<Filter> getFirstFilters() {
		return firstFilters;
	}

	public void setFirstFilters(List<Filter> firstFilters) {
		this.firstFilters = firstFilters;
	}

	public List<Filter> getSecondFilters() {
		return secondFilters;
	}

	public void setSecondFilters(List<Filter> secondFilters) {
		this.secondFilters = secondFilters;
	}

	public void setFirstFilter(Filter firstFilter) {
		this.firstFilters = new ArrayList<Filter>();
		this.firstFilters.add(firstFilter);
	}

	public void setSecondFilter(Filter secondFilter) {
		this.secondFilters = new ArrayList<Filter>();
		this.secondFilters.add(secondFilter);
	}

}
