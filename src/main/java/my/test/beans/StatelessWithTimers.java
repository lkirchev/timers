package my.test.beans;

import java.util.Collection;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

@Stateless
@LocalBean
public class StatelessWithTimers {

	@Resource
	protected TimerService timerService;

	@Timeout
	protected void timeout(Timer timer) {
	}

	public Collection<Timer> getAllTimers() {
		return timerService.getAllTimers();
	}

	public void createTimer() {
		timerService.createSingleActionTimer(60 * 1000, new TimerConfig());
	}
}
