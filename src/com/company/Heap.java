package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class Heap implements Observer {
    private ArrayList<Node> allCharacters;
    private ArrayList<Character> list;
    private HashMap<Character,String> reMap;

    public HashMap<Character, String> getReMap() {
        return reMap;
    }

    public Heap() {
        this.allCharacters = new ArrayList<>();
        this.list = new ArrayList<>();
        this.reMap = new HashMap<>();
    }

    public void addCharacter(Node n) {
        allCharacters.add(n);
        list.add(n.getCharacter());
        heapifyUp(allCharacters.size()-1);
        n.addObserver(this);
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0 && getParentIndex(index) < allCharacters.size();
    }

    private int getParentIndex(int index) {
        return (int) Math.floor((index-1)/2);
    }

    public Node peek() {
        if(allCharacters.size() == 0) {
            return null;
        }
        return allCharacters.get(0);
    }

    public void remove() {
        allCharacters.set(0,allCharacters.get(allCharacters.size()-1));
        allCharacters.remove(allCharacters.size()-1);
        heapifyDown(0);
    }

    public void heapifyUp(int index) {
        if(!hasParent(index)) {
            return;
        }
        int parentIndex = getParentIndex(index);

        Node n = allCharacters.get(index);
        Node pai = allCharacters.get(parentIndex);

        if(n.getCases() < pai.getCases()) {
            allCharacters.set(index,pai);
            allCharacters.set(parentIndex,n);
            heapifyUp(parentIndex);
        }
    }

    public void heapifyDown(int index) {
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;

        int childIndex = -1;

        if(leftChild < allCharacters.size()) {
            childIndex = leftChild;
        }

        if(childIndex < 0) {
            return;
        }

        if(rightChild < allCharacters.size()) {
            if(allCharacters.get(rightChild).getCases() < allCharacters.get(leftChild).getCases()) {
                childIndex = rightChild;
            }
        }

        if(allCharacters.get(index).getCases() > allCharacters.get(childIndex).getCases()) {
            Node tmp = allCharacters.get(index);
            allCharacters.set(index,allCharacters.get(childIndex));
            allCharacters.set(childIndex,tmp);
            heapifyUp(childIndex);
        }
    }

    public void reading(String path, String name) throws IOException {

        if(path.charAt(path.length()-1)!='/') {
            path = path.concat("/");
            path = path.concat(name);
        } else {
            path = path.concat(name);
        }

        try {
            FileReader rdr = new FileReader(path);
            BufferedReader brdr = new BufferedReader(rdr);
            int content = brdr.read();
            int cont = 0;

            while (content != -1) {
                char key = (char) content;
                System.out.println(key);
                for (int i = 0; i < allCharacters.size(); ++i) {
                    if (key == allCharacters.get(i).getCharacter()) {
                        allCharacters.get(i).setCases(allCharacters.get(i).getCases() + 1);
                        cont++;
                    }
                }
                if(cont == 0) {
                    Node novoChar = new Node(key);
                    addCharacter(novoChar);
                }
                content = brdr.read();
                cont = 0;
            }
            rdr.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Node createBinaryTree() {
        while(allCharacters.size() > 1) {
            Node n = peek();
            remove();
            Node m = peek();
            remove();
            Node fusion = new Node(n.getCases()+m.getCases());
            fusion.setLeft(n);
            fusion.setRight(m);
            addCharacter(fusion);
        }
        return peek();
    }

    public void reMap(Node binaryTree) {
        if(binaryTree.getLeft() != null) {
            if(binaryTree.getBits() == "-1") {
                binaryTree.getLeft().setBits("0");
                reMap(binaryTree.getLeft());
            } else {
                String aux = binaryTree.getBits();
                aux = aux.concat("0");
                binaryTree.getLeft().setBits(aux.concat(aux));
                reMap(binaryTree.getLeft());
            }
        }
        else if(binaryTree.getRight() != null) {
            if(binaryTree.getBits() == "-1") {
                binaryTree.getRight().setBits("1");
                reMap(binaryTree.getRight());
            } else {
                String aux = binaryTree.getBits();
                aux = aux.concat("1");
                binaryTree.getRight().setBits(aux.concat(aux));
                reMap(binaryTree.getRight());
            }
        }
    }

    public void copyMap(Node n) {
        if(n.getLeft() != null) {
            for(int i=0; i<list.size(); ++i) {
                if(n.getLeft().getCharacter() == list.get(i)) {
                    reMap.put(list.get(i),n.getBits());
                }
            }
            copyMap(n.getLeft());
        }
        else if(n.getRight() != null) {
            for(int i=0; i<list.size(); ++i) {
                if(n.getRight().getCharacter() == list.get(i)) {
                    reMap.put(list.get(i),n.getBits());
                }
            }
            copyMap(n.getRight());
        }
    }

    public void imprimirMap() {
        System.out.println("Numero de caracteres" + list.size());
        System.out.println("Tamanho do hashMap" + reMap.size());

        for(int i=0; i<list.size(); ++i) {
            System.out.println("Para: " + list.get(i));
            //System.out.println("Remapeamento em bits: " + reMap.get(list.get(i)));
        }

        if(list.size() == reMap.size()) {
            for(int i=0; i<list.size(); ++i) {
                System.out.println("Para: " + list.get(i));
                System.out.println("Remapeamento em bits: " + reMap.get(list.get(i)));
            }
        }
    }

    @Override
    public void update(Observable nodeCasesSubject, Object arg) {
        if(nodeCasesSubject instanceof Node) {
            for (Node n: allCharacters) {
                if(n.getCharacter() == (((Node) nodeCasesSubject).getCharacter())) {
                    heapifyUp(allCharacters.indexOf(n));
                    heapifyDown(allCharacters.indexOf(n));
                    return;
                }
            }
        }
    }
}