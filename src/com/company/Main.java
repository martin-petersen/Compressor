package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	    Heap leitor = new Heap();
	    String path = "/home/martin.rocha/Documentos/ProjetoEdbII/Projeto-EDB-II/src/arquivos-de-teste/testes";
	    String name = "teste1.txt";
	    leitor.reading(path,name);
	    leitor.v(leitor.getTree());
	    leitor.s(leitor.getTree());
    }
}
