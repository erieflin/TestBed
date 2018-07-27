package warframe.api.filters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class PassThroughFilter implements Filter {
	List<Filter> internalFilters;
	Class<?> targetClass;
	public PassThroughFilter(Filter internalFilter, Class<?> targetClass) {
		ArrayList<Filter> internalFilters = new ArrayList<Filter>();
		internalFilters.add(internalFilter);
		this.internalFilters = internalFilters;
		this.targetClass = targetClass;
	}
	public PassThroughFilter(List<Filter> internalFilters, Class<?> targetClass) {
		this.internalFilters = internalFilters;
		this.targetClass = targetClass;
	}

	@Override
	public boolean doesPass(Object o) {

		Method[] methods = o.getClass().getMethods();
		for (Method m : methods) {

			if (m.getReturnType().equals(targetClass) && m.getParameterCount()==0) {
				try {
					Object instance = (targetClass.cast(m.invoke(o, new Object[0])));
					
					for(Filter internalFilter: internalFilters){
						if (internalFilter.doesPass(instance)) {
							return true;
						}
					}
				} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
					continue;
				}
			}

		}
		return false;
	}
}
