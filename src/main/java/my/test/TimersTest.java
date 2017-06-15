package my.test;

import java.io.IOException;
import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Timer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.test.beans.StatelessWithTimers;
import my.test.beans.StatefulWithoutTimers;

@WebServlet(name = "TimersTest", urlPatterns = { "/TimersTest" })
public class TimersTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	StatefulWithoutTimers withoutTimers;

	@EJB
	StatelessWithTimers withTimers;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		withTimers.createTimer();
		Collection<Timer> timers = withTimers.getAllTimers();
		response.getWriter().append("Timers count: ").append(String.valueOf(timers.size()));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
