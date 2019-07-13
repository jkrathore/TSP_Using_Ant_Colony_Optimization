package com.tsp.aco;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Driver {

	static final int NUMBER_OF_ANTS = 500;
	static ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	static ExecutorCompletionService<Ant> executorCompletionService = new ExecutorCompletionService<Ant>(executorService);
	
	private int activeAnts = 0;
	public static void main(String[] args) {
		Driver driver = new Driver();
		System.out.println("> Driver.main : enter active ants loop ...");
		IntStream.range(1, NUMBER_OF_ANTS).forEach(x -> {
			System.out.println("\nDriver.main: executorCompletion.submit((new Ant())");
			executorCompletionService.submit(new Ant());
			driver.activeAnts++;
			while (driver.activeAnts > 0) {
				try { executorCompletionService.take();
			}
				catch(Exception e) {
					e.printStackTrace();
				}
				driver.activeAnts--;
				
			}
		});
		System.out.println("\n Driver.main: exit activate ants loop...");
		executorService.shutdownNow();
	}
	
	
	
}
