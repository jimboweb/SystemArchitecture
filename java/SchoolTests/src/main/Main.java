package main;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		/*int[] heap = {9, 22, 5, 6, 32, 10, 30};
		ArrayHeap sort = new ArrayHeap(heap);
		sort.printHeapFlat(sort.heap);
		sort.heapSort(false);
		//sort.printHeap(heap);
		System.out.println(sort.pop(false));
		System.out.println(sort.pop(false));
		System.out.println(sort.pop(false));
		System.out.println(sort.pop(false));
		System.out.println(sort.pop(false));
		System.out.println(sort.pop(false));
		System.out.println(sort.pop(false));*/
		Hash hash = new Hash();
		hash.insertData("Test", "Apple");
		hash.insertData("Mom", "Poppa");
		System.out.println(hash.getData("Test"));
	}
}
