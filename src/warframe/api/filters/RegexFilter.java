package warframe.api.filters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFilter implements Filter {
	private String regex = "";

	public RegexFilter(String regex) {
		this.regex = regex;
	}

	@Override
	public boolean doesPass(Object o) {
		if(o==null){
			return false;
		}
		String inStr = o.toString();
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(inStr.trim().toLowerCase());
		return m.find();
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

}
