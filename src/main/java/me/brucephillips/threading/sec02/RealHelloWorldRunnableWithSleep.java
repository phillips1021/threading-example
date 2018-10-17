package me.brucephillips.threading.sec02;

import java.util.Random;

public class RealHelloWorldRunnableWithSleep
{
	public static class Greeter implements Runnable
	{
		private String country;
		
		public Greeter(String country)
		{
			this.country = country;
		}

		public void run()
		{
			try
			{
				Random r = new Random();
				int sleepTime = r.ints(1, 10).findFirst().getAsInt();
				System.out.format("%s thread about to sleep for %d seconds\n", country, sleepTime);
				Thread.sleep(sleepTime*1000);
			}
			catch (InterruptedException e)
			{
				// Safe to ignore this
				// We'll discuss it shortly
			}
			
			System.out.println("Hello " + country + "!");
		}
	}

	public static void main(String[] args)
	{
		String countries[] = { "France", "India", "China", "USA", "Germany" };

		for (String country : countries)
		{
			Greeter greeter = new Greeter(country);
			new Thread(greeter, country + " thread").start();
		}
	}
}
