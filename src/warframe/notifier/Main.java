package warframe.notifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.utils.Time;

import javafx.scene.control.Alert;
import warframe.api.filters.AlertRewardFilters;
import warframe.api.filters.CetusDayFilter;
import warframe.api.filters.EventRewardFilter;
import warframe.api.filters.Filter;
import warframe.api.filters.RegexFilter;
import warframe.api.templates.CetusCycle;

public class Main {
	private static final int interval = 2;

	public static void main(String[] args) {
		Timer timer = new Timer();
		NotificationEngine engine = new NotificationEngine();
		
		List<Filter> rewardStringFilters = new ArrayList<Filter>();
		rewardStringFilters.add(new RegexFilter("catalyst"));
		rewardStringFilters.add(new RegexFilter("reactor"));
		rewardStringFilters.add(new RegexFilter("kavat"));
		
		Filter alertRewardFilter = new AlertRewardFilters(rewardStringFilters);
		Filter eventRewardFilter = new EventRewardFilter(rewardStringFilters);
		
		Filter cetusFilter = new CetusDayFilter();
		engine.getFe().getFilter(Alert.class).add(alertRewardFilter);
		engine.getFe().getFilter(CetusCycle.class).add(cetusFilter);
		//engine.getFe().getEventFilters().add(eventRewardFilter);
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				
				engine.checkUpdates();
			}
		}, 0, Time.seconds(60 *
				interval).getMilliseconds());
	}

}
