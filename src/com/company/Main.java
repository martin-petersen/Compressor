package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	    Heap leitor = new Heap();
	    leitor.reading(args[0],args[1]);
	    Node arvore = leitor.createBinaryTree();
	    leitor.reMap(arvore);
	    leitor.copyMap(arvore);
	    leitor.imprimirMap();
    }
}
