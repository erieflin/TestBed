package warframe.notifier.notification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import warframe.api.filters.ClassFilterConfig;
import warframe.api.filters.Filter;
import warframe.api.templates.Alert;
import warframe.api.templates.CetusCycle;
import warframe.api.templates.Event;
import warframe.api.templates.Invasion;
import warframe.api.templates.WorldState;

public class FilteringEngine {
	private HashMap<String,String> miscToNotify = new HashMap<String,String>();
	private HashMap<Class<?>, ClassFilterConfig> filters = new  HashMap<Class<?>, ClassFilterConfig>();
	private HashMap<Class<?>, List<Object>> data = new  HashMap<Class<?>, List<Object>>();
	

	public FilteringEngine(){
		filters.put(Alert.class, new ClassFilterConfig());
		filters.put(Invasion.class, new ClassFilterConfig());
		filters.put(CetusCycle.class, new ClassFilterConfig());
		filters.put(Event.class, new ClassFilterConfig());
	}
	
	public HashMap<String, String> getMiscToNotify() {
		return miscToNotify;
	}




	public void setMiscToNotify(HashMap<String, String> miscToNotify) {
		this.miscToNotify = miscToNotify;
	}




	public HashMap<Class<?>, ClassFilterConfig> getFilters() {
		return filters;
	}

	public void setFilters(HashMap<Class<?>, ClassFilterConfig> filters) {
		this.filters = filters;
	}

	public ClassFilterConfig getFilter(Class<?> queryClass) {
		return filters.get(queryClass);
	}
	public void setFilterConfig(Class<?> queryClass, ClassFilterConfig filterConfig) {
		filters.put(queryClass, filterConfig);
	}


	public void applyFilters(WorldState ws) {
		data.clear();
		applyFilters(ws.getAlerts(), filters.get(Alert.class));

		applyFilters(ws.getInvasions(), filters.get(Invasion.class));
		applyFilters(ws.getEvents(),filters.get(Event.class));
		applyFilters(ws.getCetusCycle(),filters.get(CetusCycle.class));
		
//		CetusCycle cetus = ws.getCetusCycle();
////		if (fufillsFilters(cetus, filters.get(CetusCycle.class))) {
////			miscToNotify.put("Cetus Status", cetus.toString());
//		}
	}

//	public boolean fufillsFilters(Object o, ClassFilterConfig filterConfig) {
//		boolean matches = false;
//		for (Filter filter : filterConfig)) {
//			if (filter.doesPass(o)) {
//				matches = true;
//			}
//		}
//		return matches;
//
//	}
	
	public void applyFilters(Object object,  ClassFilterConfig filterConfig){
		List<Object> wrapper = new ArrayList<Object>();
		wrapper.add(object);
		applyFilters(wrapper, filterConfig);
	}
	
	public void applyFilters(List<?> list,  ClassFilterConfig filterConfig) {
		Iterator<?> i = list.iterator();
		while (i.hasNext()) {
			Object o = i.next();

			if (filterConfig.doesPass(o)) {
				Class<?> objectClass = o.getClass();
				if(data.containsKey(objectClass)){
					data.get(objectClass).add(o);
				}else{
					List<Object> objectList = new ArrayList<Object>();
					objectList.add(o);
					data.put(o.getClass(), objectList);
				}
			}
		}
	}

	public void ignoreId(Class<?> targetClass, String id){
		List<String> ignored = filters.get(targetClass).getIdFilter().getIgnoredIds();
		if(!ignored.contains(id)){
			ignored.add(id);
		}
	}
	public HashMap<Class<?>, List<Object>> getData() {
		return data;
	}

	public void setData(HashMap<Class<?>, List<Object>> data) {
		this.data = data;
	}
	
	public void addFilter(Class<?> targetClass, Filter filter){
		if(this.filters.containsKey(targetClass)){
			this.filters.get(targetClass).getBaseFilters().add(filter);
		}
	}

}
