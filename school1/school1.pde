int size;
int[] heap;
//int[] ideal;
int frame = 0;

void setup() {
  size = 4;
  heap = new int[(int)pow(2, size) - 1]; //COMMENT: probably more efficient to use size*size
  //ideal = new int[(int)pow(2, size) - 1];
  //int p = 0;
  for(int i = 0; i < heap.length; i++) {
    heap[i] = -1;//p = p + (int)random(4) + 1;
    //ideal[i] = p;
  }
  //for(int i = 0; i < heap.length; i++) {
  //  swap((int)random(heap.length),(int)random(heap.length));
  //}
  size(256,256);
}

void draw() {
  if(frame % 20 == 0) {
    background(#c0c0c0);
    insert((int)random(256));
    for(int i = 0; i < heap.length; i++) {
      int d = getDepth(i);
      int s = 16;
      text(heap[i], (width/(pow(2,d)+1)) * (i-(pow(2,d)-2)), (d+1)*s);//(i-(pow(2,d)-1))
    }
  }
  frame++;
}

boolean insert(int n) {
  int a = 0;
  while(heap[a] != -1) { //BUG: This ends with an indexOutOfBounds exception
    a++;
    if(a >= heap.length) return false;
  }
  heap[a] = n;
  int b = indexParent(a);
  while(b >= 0) {
    b = indexParent(a);
    if(b >= 0) if(heap[a] < heap[b]) {
      swap(a,b);
    };
    a = b;
  }
  return true;
}
int[] insert(int[] array, int n) {
  int a = 0;
  int out = array;
  while(out[a] != -1) {
    a++;
    if(a >= out.length) return array;
  }
  out[a] = n;
  int b = indexParent(a);
  while(b >= 0) {
    b = indexParent(a);
    if(b >= 0) if(out[a] < out[b]) {
      swap(out,a,b);
    };
    a = b;
  }
  return out;
}

int[] buildHeap(int[] in) {
  int[] out = new int[in.length];
  for() {
    insert((int)random(256));
  }
}

void swap(int a, int b) {
  int temp = heap[a];
  heap[a] = heap[b];
  heap[b] = temp;
}
int[] swap(int[] array, int a, int b) {
  int[] out = array;
  int temp = out[a];
  out[a] = out[b];
  out[b] = temp;
  return out;
}

int findChild1(int n) {
  return heap[(n << 1) + 1];
}
int findChild2(int n) {
  return heap[(n << 1) + 2];
}
int findParent(int n) {
  return heap[(n - 1) >> 1];
}
int indexParent(int n) {
  return (n - 1) >> 1;
}
int getDepth(int n) {
  return (int)(log(n+1)/log(2));
}

int powInt(int pow, int n) {
  int out = 1;
  for(int i = 0; i < pow; i++) {
    out *= n;
  }
  return out;
}