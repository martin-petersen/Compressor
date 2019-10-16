package br.com.projeto.edb.entits.Testes;

import br.com.projeto.edb.entits.Compressor;
import br.com.projeto.edb.entits.Extrator;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class CompressorTest {

    @Test
    public void compressorTest() throws IOException {
        Compressor a = new Compressor(new String("C:\\Users\\Martin Petersen\\Desktop\\ProjetoEdbII-master\\P1\\src\\arquivos-de-teste\\testes\\teste1.txt"),
                "C:\\Users\\Martin Petersen\\Desktop\\ProjetoEdbII-master\\P1\\src\\arquivos-de-teste\\testes\\teste.edz",
                "C:\\Users\\Martin Petersen\\Desktop\\ProjetoEdbII-master\\P1\\src\\arquivos-de-teste\\testes\\teste.edt");

    }

    @Test
    public void extratorTest() throws IOException {
        Extrator a = new Extrator(new String("C:\\Users\\Martin Petersen\\Desktop\\ProjetoEdbII-master\\P1\\src\\arquivos-de-teste\\testes\\teste1.txt"),
                "C:\\Users\\Martin Petersen\\Desktop\\ProjetoEdbII-master\\P1\\src\\arquivos-de-teste\\testes\\teste.edz",
                "C:\\Users\\Martin Petersen\\Desktop\\ProjetoEdbII-master\\P1\\src\\arquivos-de-teste\\testes\\teste.edt");
    }
}