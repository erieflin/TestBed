package warframe.api.filters;

import warframe.api.templates.CetusCycle;

public class CetusDayFilter implements Filter {

	@Override
	public boolean doesPass(Object o) {
		if(!(o instanceof CetusCycle)){
			return false;
		}
		CetusCycle cetus = (CetusCycle) o;
		return !cetus.isDay();
	}

}
