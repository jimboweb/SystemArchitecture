package main;

public class Hash {
	short in;
	String[] array = new String[65536];
	
	public Hash() {
	}
	
	public int rand(short n_) { //from sm64
		in = n_;
		short s0 = (short)(in ^ (in << 8));
		in = (short)((s0 >> 8) | (s0 << 8));
		s0 = (short)(in ^ ((s0 & 0x00FF) << 1));
		short s1 = (short)(0xFF80 ^ (s0 >> 1));
		if((s0 & 0x0001) == 0x0001) in = (short)(0x8180 ^ s1);
		else in = (short)(0x1FF4 ^ s1);
		return in;
	}
	
	public void insertData(String word, String data) {
		array[getAddr(word)] = data;
	}
	
	public int getAddr(String word) {
		return rand((short)((word.charAt(0) << 8) + word.charAt(1))) + 32768;
	}
	
	public String getData(String word) {
		return array[getAddr(word)];
	}
}
