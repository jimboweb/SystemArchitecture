package main;

public class ArrayHeap {
	int[] heap;
	//boolean isMin;
	
	public ArrayHeap(int[] heap_) {
		heap = heap_;
	}
	
	public int getTop() {
		int out = heap[0];
		return out;
	}
	
	public int[] heapSort(boolean isMin) {
		int[] out = new int[heap.length];
		for(int i = 0; i < out.length; i++) {
			out[i] = -1;
		}
		for(int i = 0; i < heap.length; i++) {
			out = push(out, heap[i], isMin);
			//printHeapFlat(out);
		}
		heap = out;
		return heap;
	}
	
	int[] push(int[] array, int n, boolean isMin) {
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
	    //System.out.print(" ");
	    //printHeapFlat(out);
	  }
	  //System.out.print("\n");
	  return out;
	}
	
	int pop(boolean isMin) {
		int output = getTop();
		//int[] out = array;
		heap[0] = -1;
		if(isBlank()) return -1;
		//heap = heapSort(isMin);
		for(int i = heap.length - 1; heap[0] == -1; i--) {
			heap[0] = heap[i];
			heap[i] = -1;
			//System.out.print("e");
			//printHeapFlat(heap);
		}
		heapSort(isMin);
		return output;
	}
	
	boolean isBlank() {
		for(int i = 0; i < heap.length; i++) {
			if(heap[i] >= 0) return false;
		}
		return true;
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
