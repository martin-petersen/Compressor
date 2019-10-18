package br.com.projeto.edb.entits.Testes;

import br.com.projeto.edb.entits.Extrator;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ExtratorTest {

    @Test
    public void extractTeste1() throws IOException {
        Extrator a = new Extrator("C:\\Users\\Martin Petersen\\Desktop\\ProjetoEdbII-master (1)\\ProjetoEdbII-master\\P1\\src\\arquivos-de-teste\\Teste1.txt",
                "C:\\Users\\Martin Petersen\\Desktop\\ProjetoEdbII-master (1)\\ProjetoEdbII-master\\P1\\src\\arquivos-de-teste\\testes\\teste1.edz",
                "C:\\Users\\Martin Petersen\\Desktop\\ProjetoEdbII-master (1)\\ProjetoEdbII-master\\P1\\src\\arquivos-de-teste\\testes\\teste1.edt");
    }
    @Test
    public void extractTeste2() throws IOException {
        Extrator a = new Extrator("src/br/com/projeto/edb/entits/ArquivosTestes/Teste2.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste2.edz",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste2.edt");
    }
    @Test
    public void extractTeste3() throws IOException {
        Extrator a = new Extrator("C:\\Users\\Martin Petersen\\Desktop\\ProjetoEdbII-master (1)\\ProjetoEdbII-master\\P1\\src\\arquivos-de-teste\\Teste3.txt",
                "C:\\Users\\Martin Petersen\\Desktop\\ProjetoEdbII-master (1)\\ProjetoEdbII-master\\P1\\src\\arquivos-de-teste\\testes\\teste3.edz",
                "C:\\Users\\Martin Petersen\\Desktop\\ProjetoEdbII-master (1)\\ProjetoEdbII-master\\P1\\src\\arquivos-de-teste\\testes\\teste3.edt");
    }
    @Test
    public void extractTeste4() throws IOException {
        Extrator a = new Extrator("src/br/com/projeto/edb/entits/ArquivosTestes/Teste4.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste4.edz",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste4.edt");
    }
    @Test
    public void extractTeste5() throws IOException {
        Extrator a = new Extrator("src/br/com/projeto/edb/entits/ArquivosTestes/Teste5.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste5.edz",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste5.edt");
    }
    @Test
    public void extractTeste6() throws IOException {
        Extrator a = new Extrator("src/br/com/projeto/edb/entits/ArquivosTestes/Teste6.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste6.edz",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste6.edt");
    }
    @Test
    public void extractTeste7() throws IOException {
        Extrator a = new Extrator("src/br/com/projeto/edb/entits/ArquivosTestes/Teste7.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste7.edz",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste7.edt");
    }
    @Test
    public void extractTeste8() throws IOException {
        Extrator a = new Extrator("src/br/com/projeto/edb/entits/ArquivosTestes/Teste8.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste8.edz",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste8.edt");
    }
    @Test
    public void extractTeste9() throws IOException {
        Extrator a = new Extrator("src/br/com/projeto/edb/entits/ArquivosTestes/Teste9.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste9.edz",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste9.edt");
    }
    @Test
    public void extractTeste10() throws IOException {
        Extrator a = new Extrator("src/br/com/projeto/edb/entits/ArquivosTestes/Teste10.txt",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste10.edz",
                "src/br/com/projeto/edb/entits/ArquivosTestes/teste10.edt");
    }
}