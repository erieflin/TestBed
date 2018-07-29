package warframe.api.filters;

import java.util.ArrayList;
import java.util.List;

public class ClassFilterConfig implements Filter{
	private IgnoredFilter idFilter;
	private List<Filter> filters = new ArrayList<Filter>();
	
	public ClassFilterConfig(IgnoredFilter idFilter, List<Filter> filters) {
		this.idFilter = idFilter;
		this.filters = filters;
	}
	
	public ClassFilterConfig() {
		this.idFilter = new IgnoredFilter(new ArrayList<String>());
		this.filters = new ArrayList<Filter>();
	}

	public IgnoredFilter getIdFilter() {
		return idFilter;
	}
	public void setIdFilter(IgnoredFilter idFilter) {
		this.idFilter = idFilter;
	}
	public List<Filter> getBaseFilters() {
		return filters;
	}
	public void setBaseFilters(List<Filter> filters) {
		this.filters = filters;
	}
	
	public List<Filter> getFilters() {
		List<Filter> allFilters = new ArrayList<Filter>();
		return allFilters;
	}

	@Override
	public boolean doesPass(Object o) {
		AndFilter andFilter = new AndFilter(idFilter,this.filters);
		return andFilter.doesPass(o);
	}
	

	
	
	
}
