package me.brucephillips.threading.sec02;


import java.util.Arrays;

public class RealHelloWorldSingleThreaded
{
	public static void main(String args[])
	{

		String countries[] = { "France", "India", "China", "USA", "Germany" };

		Arrays.stream(countries).forEach(country -> System.out.println("Hello " + country + "!"));
	}
}
