package com.thelangschool.shortestpathwithedgeweights;

import java.util.ArrayList;

public class ShortestPathWithEdgeWeights {
	Inputter inputter;
	Outputter outputter;
	
	public ShortestPathWithEdgeWeights(Inputter i, Outputter o) {
		this.inputter = i;
		this.outputter = o;
	}
	public static void main(String[] args) {
		new ShortestPathWithEdgeWeights(new UserInput(), new ConsoleOutput()).run();
	}
	
	public void run() {
		
		ArrayList<String> input = inputter.input();
		
		// solve problem here
		
		//output answer below
		outputter.Output("");
	}

}
