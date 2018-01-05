package com.thelangschool.shortestpathwithedgeweights;

public class ConsoleOutput implements Outputter {

	@Override
	public void OutputLine(String str) {
		System.out.println(str);
		
	}

	@Override
	public void Output(String str) {
		System.out.print(str);
	}

}
