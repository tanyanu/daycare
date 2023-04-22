package edu.neu.csye6200.scheduler;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import edu.neu.csye6200.controller.StudentService;

/**
 * @author eraricamehra
 *
 */
public final class Scheduler {

	private final ScheduledExecutorService scheduler;
	private final long initialDelay;
	private final long delayBetweenRuns;
	private final long shutdownAfter;

	private static final int NUM_THREADS = 1;
	private static final boolean DONT_INTERRUPT_IF_RUNNING = false;


	Scheduler(long initialDelay, long delayBetweenBeeps, long stopAfter) {
		this.initialDelay = initialDelay;
		this.delayBetweenRuns = delayBetweenBeeps;
		this.shutdownAfter = stopAfter;
		this.scheduler = Executors.newScheduledThreadPool(NUM_THREADS);
	}

	void activateSchduler() {
		Runnable startTask = new ScheduleTask();
		ScheduledFuture<?> runTask = scheduler.scheduleWithFixedDelay(startTask, initialDelay,
				delayBetweenRuns, TimeUnit.SECONDS);
		Runnable stopTask = new StopScheduledTask(runTask);
		scheduler.schedule(stopTask, shutdownAfter, TimeUnit.SECONDS);
		
	}

	private static final class ScheduleTask implements Runnable {

		@Override
		public void run() {
			//TODO get list of students whose registration needs to be renewed 
			SendEmail mail = new SendEmail();
            StudentService service = new StudentService();
            List<String> emailIds = new ArrayList<>();
            try {
				service.getAllStudents().stream().forEach(student -> emailIds.add(student.getParent().getEmail()));
			} catch (Exception e) {
				e.printStackTrace();
			}
//			List<String> emailIds = new ArrayList<>();
//			//TODO send them email
//			emailIds.add("erarica.mehra@gmail.com");
//			emailIds.add("irarikamehra@gmail.com");
			if(!emailIds.isEmpty()) {
			mail.send(emailIds);
			}
		}

	}
	
	
	private final class StopScheduledTask implements Runnable {
		private ScheduledFuture<?> schedFuture;

		StopScheduledTask(ScheduledFuture<?> schedFuture) {
			this.schedFuture = schedFuture;
		}

		@Override
		public void run() {
			System.out.println("Stopping.");
			schedFuture.cancel(DONT_INTERRUPT_IF_RUNNING);
			scheduler.shutdown();
		}

	}

	
}