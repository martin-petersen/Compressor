package br.com.projeto.edb.entits.Testes;

import br.com.projeto.edb.entits.Compressor;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CompressorTest {
    @Test
    public void compressorTeste1() throws Exception {
        Compressor a = new Compressor( "src/arquivos-de-teste/testes/teste1.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste1.edc");
    }

    @Test
    public void compressorTeste1EDTEDZ() throws IOException {
        Compressor a = new Compressor( "C:\\Users\\Martin Petersen\\Desktop\\ProjetoEdbII-master (1)\\ProjetoEdbII-master\\P1\\src\\arquivos-de-teste\\testes\\teste1.txt",
                "C:\\Users\\Martin Petersen\\Desktop\\ProjetoEdbII-master (1)\\ProjetoEdbII-master\\P1\\src\\arquivos-de-teste\\testes\\teste1.edz",
                "C:\\Users\\Martin Petersen\\Desktop\\ProjetoEdbII-master (1)\\ProjetoEdbII-master\\P1\\src\\arquivos-de-teste\\testes\\teste1.edt");
    }

    @Test
    public void compressorTeste2() throws Exception {
        Compressor a = new Compressor("src/arquivos-de-teste/testes/teste2.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste2.edc");

    }

    @Test
    public void compressorTeste2EDTEDZ() throws IOException {
        Compressor a = new Compressor( "src/arquivos-de-teste/testes/teste2.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste2.edz",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste2.edt");
    }

    @Test
    public void compressorTeste3() throws Exception {
        Compressor a = new Compressor("src/arquivos-de-teste/testes/teste3.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste3.edc");
    }

    @Test
    public void compressorTeste3EDTEDZ() throws IOException {
        Compressor a = new Compressor( "C:\\Users\\Martin Petersen\\Desktop\\ProjetoEdbII-master (1)\\ProjetoEdbII-master\\P1\\src\\arquivos-de-teste\\tst3.txt",
                "C:\\Users\\Martin Petersen\\Desktop\\ProjetoEdbII-master (1)\\ProjetoEdbII-master\\P1\\src\\arquivos-de-teste\\testes\\teste3.edz",
                "C:\\Users\\Martin Petersen\\Desktop\\ProjetoEdbII-master (1)\\ProjetoEdbII-master\\P1\\src\\arquivos-de-teste\\testes\\teste3.edt");
    }

    @Test
    public void compressorTeste4() throws Exception {
        Compressor a = new Compressor("src/arquivos-de-teste/testes/teste4.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste4.edc");
    }

    @Test
    public void compressorTeste4EDTEDZ() throws IOException {
        Compressor a = new Compressor( "src/arquivos-de-teste/testes/teste4.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste4.edz",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste4.edt");
    }

    @Test
    public void compressorTeste5() throws Exception {
    Compressor a = new Compressor("src/arquivos-de-teste/testes/teste5.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste5.edc");
    }

    @Test
    public void compressorTeste5EDTEDZ() throws IOException {
        Compressor a = new Compressor( "src/arquivos-de-teste/testes/teste5.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste5.edz",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste5.edt");
    }

    @Test
    public void compressorTeste6() throws IOException {
        Compressor a = new Compressor("src/arquivos-de-teste/testes/teste6.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste6.edc");
    }
    @Test
    public void compressorTeste6EDTEDZ() throws IOException {
        Compressor a = new Compressor( "src/arquivos-de-teste/testes/teste6.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste6.edz",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste6.edt");
    }

    @Test
    public void compressorTeste7() throws IOException {
        Compressor a = new Compressor("src/arquivos-de-teste/testes/teste7.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste7.edc");
    }

    @Test
    public void compressorTeste7EDTEDZ() throws IOException {
        Compressor a = new Compressor( "src/arquivos-de-teste/testes/teste7.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste7.edz",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste7.edt");
    }

    @Test
    public void compressorTeste8() throws IOException {
        Compressor a = new Compressor("src/arquivos-de-teste/testes/teste8.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste8.edc");
    }

    @Test
    public void compressorTeste8EDTEDZ() throws IOException {
        Compressor a = new Compressor( "src/arquivos-de-teste/testes/teste8.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste8.edz",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste8.edt");
    }

    @Test
    public void compressorTeste9() throws IOException {
        Compressor a = new Compressor("src/arquivos-de-teste/testes/teste9.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste9.edc");
    }

    @Test
    public void compressorTeste9EDTEDZ() throws IOException {
        Compressor a = new Compressor( "src/arquivos-de-teste/testes/teste9.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste9.edz",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste9.edt");
    }

    @Test
    public void compressorTeste10() throws IOException {
        Compressor a = new Compressor("src/arquivos-de-teste/testes/teste10.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste10.edc");
    }

    @Test
    public void compressorTeste10EDTEDZ() throws IOException {
        Compressor a = new Compressor( "src/arquivos-de-teste/testes/teste10.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste10.edz",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste10.edt");
    }

}