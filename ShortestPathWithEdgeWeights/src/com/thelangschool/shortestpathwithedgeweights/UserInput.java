package com.thelangschool.shortestpathwithedgeweights;

import java.util.ArrayList;
import java.util.List;

public class UserInput implements Inputter {

	@Override
	public ArrayList<String> input() {
		ArrayList<String> input = new ArrayList<>();
		// TODO input data in the following format:
		//first line contains one int: number of inputs
		//next [input] lines: each input line contains three ints: fromNode, toNode and weight
		//a final line will contain two ints: the starting and ending node
		//Example input:
		// 3
		// 0 1 2
		// 0 2 5
		// 1 2 10
		// 0 2
		return input;
	}



}
