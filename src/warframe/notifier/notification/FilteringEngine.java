package warframe.notifier.notification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import warframe.api.filters.Filter;
import warframe.api.templates.Alert;
import warframe.api.templates.CetusCycle;
import warframe.api.templates.Event;
import warframe.api.templates.Invasion;
import warframe.api.templates.WorldState;

public class FilteringEngine {
	private HashMap<String,String> miscToNotify = new HashMap<String,String>();
	private HashMap<Class<?>,List<Filter>> filters = new  HashMap<Class<?>,List<Filter>>();
	public FilteringEngine(){
		filters.put(Alert.class, new ArrayList<Filter>());
		filters.put(Invasion.class, new ArrayList<Filter>());
		filters.put(CetusCycle.class, new ArrayList<Filter>());
		filters.put(Event.class, new ArrayList<Filter>());
	}
	



	public HashMap<String, String> getMiscToNotify() {
		return miscToNotify;
	}




	public void setMiscToNotify(HashMap<String, String> miscToNotify) {
		this.miscToNotify = miscToNotify;
	}




	public HashMap<Class<?>, List<Filter>> getFilters() {
		return filters;
	}

	public void setFilters(HashMap<Class<?>, List<Filter>> filters) {
		this.filters = filters;
	}

	public List<Filter> getFilter(Class<?> queryClass) {
		return filters.get(queryClass);
	}
	public void setFilter(Class<?> queryClass, List<Filter> filterList) {
		filters.put(queryClass,filterList);
	}


	public void applyFilters(WorldState ws) {
		applyFilters(ws.getAlerts(), filters.get(Alert.class));

		applyFilters(ws.getInvasions(), filters.get(Invasion.class));
		applyFilters(ws.getEvents(),filters.get(Event.class));
		
		CetusCycle cetus = ws.getCetusCycle();
		if (fufillsFilters(cetus, filters.get(CetusCycle.class))) {
			miscToNotify.put("Cetus Status", cetus.toString());
		}
	}

	public boolean fufillsFilters(Object o, List<Filter> filters) {
		boolean matches = false;
		for (Filter filter : filters) {
			if (filter.doesPass(o)) {
				matches = true;
			}
		}
		return matches;

	}

	public void applyFilters(List<?> list, List<Filter> filters) {
		Iterator<?> i = list.iterator();
		while (i.hasNext()) {
			Object o = i.next();

			if (!fufillsFilters(o, filters)) {
				i.remove();
			}
		}
	}

}
