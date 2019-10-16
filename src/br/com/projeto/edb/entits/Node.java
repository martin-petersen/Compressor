package br.com.projeto.edb.entits;


public class Node {
    private Character letter;
    private Integer count;
    private Node left;
    private Node right;


    public Node(Object count, Node left, Node right){
        this.letter = null;
        this.count = (Integer) count;
        this.left = left;
        this.right = right;
    }

    public Node(Object letter, Object count){
        this.letter = (Character) letter;
        this.count = (Integer) count;
        this.left = null;
        this.right = null;
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Character getLetter() {
        return letter;
    }

    public Integer getCount() {
        return count;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }



    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Letter : " + letter + ", Count : " + count;
    }
}
