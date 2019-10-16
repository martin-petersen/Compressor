package br.com.projeto.edb.entits;

import java.util.*;

public class Heap {
    private Node[] heap;
    private int size;
    private int capacity;


    //Constructor
    public Heap() {
        this(10);
    }

    public Heap(int capacity){
        this.heap = new Node[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    //Getter's


    public Node[] getHeap() {
        return heap;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }


    //Methods

    public void insert(Node pessoa) {
        ensureCapacity();
        heap[getSize()] = pessoa;
        heapifyUp(getSize());
        size++;
    }

    public void insert(HashMap<Character, Integer> hashmap) {
        Iterator it = hashmap.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry mapElement = (Map.Entry)it.next();
            this.insert(new Node(mapElement.getKey(), mapElement.getValue() ));
        }
    }

    private void ensureCapacity() {
        if (this.size == this.capacity) {
            this.heap = Arrays.copyOf(this.heap, this.capacity * 2);
            this.capacity = this.capacity * 2;
        }
    }

    public int getParentIndex(int index) {
        return (int) Math.floor((index - 1) / 2);
    }

    public Node peek() {
        if (getSize() == 0) {
            return null;
        }
        return this.heap[0];
    }

    public Node poll() {
        if (getSize() == 0) {
            return null;
        }
        Node n = heap[0];
        this.remove();
        return n;
    }

    public void remove() {
        heap[0] = heap[getSize() - 1];
        heap[getSize() - 1] = null;
        size--;
        heapifyDown(0);
    }

    private void heapifyUp(int index) {
        int parentIndex = getParentIndex(index);

        if (parentIndex < 0) {
            return;
        }

        Node pai    = this.heap[parentIndex];
        Node pessoa = this.heap[index];

        if (pessoa.getCount() < pai.getCount()) {
            this.heap[index]   = pai;
            this.heap[parentIndex] = pessoa;
            heapifyUp(parentIndex);
        }
    }

    private void heapifyDown(int index) {
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;

        int childIndex = -1;
        if (leftChild < getSize()) {
            childIndex = leftChild;
        }

        if (childIndex == -1) {
            return;
        }

        if (rightChild < getSize()) {
            if (this.heap[rightChild].getCount() < this.heap[leftChild].getCount()) {
                childIndex = rightChild;
            }
        }

        if (this.heap[index].getCount() > this.heap[childIndex].getCount()) {
            Node tmp          = this.heap[index];
            this.heap[index]      = this.heap[childIndex];
            this.heap[childIndex] = tmp;
            heapifyDown(childIndex);
        }
    }

    public String toString(){
        StringBuffer str = new StringBuffer();
        for (Node node: heap) {
            if(node != null){
                str.append(node + "\n");
            }
        }
        return str.toString();
    }

    public Node createBinaryTree(){
        while(this.getSize() > 1){
            Node left = poll();
            Node rigth = poll();
            insert(new Node ((left.getCount() + rigth.getCount()), left, rigth));
        }
        return poll();
    }


}
