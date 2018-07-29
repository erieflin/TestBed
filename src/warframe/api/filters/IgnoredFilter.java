package warframe.api.filters;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class IgnoredFilter implements Filter {
	private List<String> ignoredIds = new ArrayList<String>();
	
	public IgnoredFilter(List<String> toIgnore) {
		ignoredIds = toIgnore;
	}
	@Override
	public boolean doesPass(Object o) {
		// TODO Auto-generated method stub
		Method methodToFind = null;
		try {
			methodToFind = o.getClass().getMethod("getID", (Class<?>[]) null);
			String idString = (String) methodToFind.invoke(o, (Object[]) null);
			if (!ignoredIds.contains(idString)) {
				return true;
			}
		} catch (Exception e) {
			return true;
		}
		return false;
	}
	public List<String> getIgnoredIds() {
		return ignoredIds;
	}
	public void setIgnoredIds(List<String> ignoredIds) {
		this.ignoredIds = ignoredIds;
	}

}
