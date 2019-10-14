package com.company;

import java.util.Observable;

public class Node {
    private int cases;
    private char character;
    private String bits = "";
    private Node left = null;
    private Node right = null;


    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(int cases) {
        this.cases = cases;
    }

    public Node(char character) {
        this.character = character;
        this.cases = 1;
    }

    public int getCases() {
        return cases;
    }

    public void setCases() {
        this.cases++;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public String getBits() {
        return bits;
    }

    public void setBits(String bits) {
        this.bits = bits;
    }

}
