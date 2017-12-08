package main;

public class ArraySorter {
	private int[] heap; //have heap array as a property
	private int size; //size will be returned with a method
	
	public ArraySorter(int[] input) {
		// heap = build heap
		// size = size of heap
	}
	
	public int size() {
		//return size
		return 0;
	}
	
	public int extractMax() {
		//return max value and delete it
		return 0;
	}
	
	public int showMax() {
		//return max value but don't delete it
		return 0;
	}
	
	public void deleteMax() {
		//delete max value
		
	}
	
	public boolean insert(int value) {
		//insert new value
		//return true if insert succeeded
		return false;
	}
	
	public int[] heapSort(int[] heap, boolean isMin) {
		int[] out = new int[heap.length];
		for(int i = 0; i < out.length; i++) {
			out[i] = -1;
		}
		for(int i = 0; i < heap.length; i++) {
			out = insert(out, heap[i], isMin);
			//printHeapFlat(out);
		}
		return out;
	}
	
	int[] insert(int[] array, int n, boolean isMin) {
	  int a = 0;
	  int[] out = array;
	  
	  while(out[a] >= 0) {
	    a++;
	    if(a >= out.length) return array;
	  }
	  out[a] = n; //a is the index of the first empty space
	  int parent = indexParent(a);
	  //System.out.print(parent + ")");
	  while(parent >= 0) {
		  parent = indexParent(a);
	    if(parent >= 0 && out[a]*(isMin ? 1 : -1) < out[parent]*(isMin ? 1 : -1)) {
	      out = swap(out,a,parent);
	    }
	    a = parent;
	    printHeapFlat(out);
	  }
	  System.out.print("\n");
	  return out;
	}
	
	int[] swap(int[] array, int a, int b) {
	  int[] out = array;
	  int temp = out[a];
	  out[a] = out[b];
	  out[b] = temp;
	  return out;
	}
	int findChild1(int[] heap, int n) {
	  return heap[(n << 1) + 1];
	}
	int findChild2(int[] heap, int n) {
	  return heap[(n << 1) + 2];
	}
	int findParent(int[] heap, int n) {
	  return heap[indexParent(n)];
	}
	int indexParent(int n) {
	  return (n - 1) >> 1;
	  /* 0123456789ABCDE
	   * x00112233445566
	   */
	}
	int getDepth(int n) {
	  return (int)(Math.log(n+1)/Math.log(2));
	}

	int powInt(int pow, int n) {
	  int out = 1;
	  for(int i = 0; i < pow; i++) {
	    out *= n;
	  }
	  return out;
	}
	
	void printHeap(int[] heap) {
		for(int i = 0; i < heap.length; i++) {
			System.out.print(heap[i]);
			if(i+1 < heap.length) System.out.print(", ");
			else System.out.print(".");
			if(i == 0 || i == 2 || i == 6 || i == 14 || i == 30) System.out.print("\n");
		}
	}
	void printHeapFlat(int[] heap) {
		for(int i = 0; i < heap.length; i++) {
			System.out.print(heap[i]);
			if((i == 0 || i == 2 || i == 6 || i == 14 || i == 30) && (i+1 < heap.length)) System.out.print(".  ");
			else if(i+1 < heap.length) System.out.print(", ");
			else System.out.print(".\n");
		}
	}
}
