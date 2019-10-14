package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Heap {
    private ArrayList<Node> allCharacters;
    private ArrayList<Integer> allCases;
    private ArrayList<Character> list;
    private HashMap<Character,String> reMap;
    private Node tree = null;

    public HashMap<Character, String> getReMap() {
        return reMap;
    }

    public Heap() {
        this.allCharacters = new ArrayList<>();
        this.allCases = new ArrayList<>();
        this.list = new ArrayList<>();
        this.reMap = new HashMap<>();
    }

    public void addCharacter(Node n) {
        allCharacters.add(n);
        heapifyUp(allCharacters.size()-1);
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
                for (int i = 0; i < allCharacters.size(); ++i) {
                    if (key == allCharacters.get(i).getCharacter()) {
                        allCharacters.get(i).setCases();
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
            for(int i=0; i<allCharacters.size(); ++i) {
                heapifyDown(i);
            }
            for(int i=0; i<allCharacters.size(); ++i) {
                list.add(allCharacters.get(i).getCharacter());
                allCases.add(allCharacters.get(i).getCases());
            }
            rdr.close();

            createBinaryTree();

            this.tree = peek();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void createBinaryTree() {
        while(allCharacters.size() > 1) {
            Node n = peek();
            remove();
            Node m = peek();
            remove();
            Node fusion = new Node(n.getCases()+m.getCases());
            fusion.setLeft(n);
            fusion.setRight(m);
            addCharacter(fusion);
            System.out.println("No Soma -> " + fusion.getCases() + " // No Esquerdo -> " + fusion.getLeft().getCases() + " // No Direito -> " + fusion.getRight().getCases());
        }
        System.out.println(allCharacters.size());
    }

    public Node getTree() {
        return tree;
    }

    public void reMap(Node node) {
        if(node.getLeft() != null && node.getLeft().getCases() >= allCases.get(0)) {
            node.getLeft().setBits(node.getBits().concat("1"));
            reMap(node.getLeft());
        }
        else if (node.getRight() != null && node.getRight().getCases() <= allCases.get(0)) {
            node.getLeft().setBits(node.getBits().concat("0"));
            reMap(node.getRight());
        }
        System.out.println("Caractere -> " + list.get(0) + " // Ocorrencias -> " + allCases.get(0) + " // Remaped -> " + node.getBits());
        allCases.remove(0);
        list.remove(0);
    }

    public void v(Node node) {
        while (allCases.size() >= 1) {
            reMap(node);
        }
    }

    public void s(Node node) {
        if(node.getLeft() != null) {
            System.out.println(node.getCases());
            s(node.getLeft());
        } else {
            System.out.println("NULL");
        }
    }
}