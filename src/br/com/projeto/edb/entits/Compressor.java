package br.com.projeto.edb.entits;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class Compressor {

    public Compressor (String fileTxT, String fileEDC) throws IOException {

        HashMap<Character, Integer> hashmap = new HashMap<> (this.lettersFrequency(fileTxT));
        hashmap.put((char)3,1);
        Heap heap = new Heap();

        heap.insert(hashmap);

        Node root = heap.createBinaryTree();
        HashMap<Character, String> codeMap = generateTableCode(root);
        String encrypted = generateEnchantedMail(fileTxT, codeMap);
        generateEDC(generateBitSet(encrypted), generateStringTableCodeEDC(codeMap), fileEDC);

    }

    public Compressor (String fileTxT, String fileEDZ, String fileEDT) throws IOException {

        HashMap<Character, Integer> hashmap = new HashMap<> (this.lettersFrequency(fileTxT));
        hashmap.put((char)3, 1);
        Heap heap = new Heap();
        heap.insert(hashmap);
        Node root = heap.createBinaryTree();
        HashMap<Character, String> codeMap = generateTableCode(root);
        String encrypted = generateEnchantedMail(fileTxT, codeMap);
        generateEDZ(generateBitSet(encrypted), fileEDZ);
        generateEDT(generateStringTableCodeEDT(codeMap), fileEDT);

    }

    private void generateEDZ(byte[] encrypted, String fileEDT) throws IOException {
        FileOutputStream fileOutEDT = new FileOutputStream(fileEDT);
        fileOutEDT.write(encrypted);
        fileOutEDT.close();
    }

    private void generateEDT(String tableCode, String fileEDT) throws IOException {
        FileOutputStream fileOutEDT = new FileOutputStream(fileEDT);
        Writer wtr = new OutputStreamWriter(fileOutEDT,Charset.forName("ISO-8859-1"));
        for (int i = 0; i < tableCode.length(); ++i){
            fileOutEDT.write(tableCode.charAt(i));
        }
        fileOutEDT.close();
    }

    private void generateEDC (byte[] encrypted, String tabelaEncrypted, String fileEDC ) throws IOException {
        FileOutputStream fileOutEDC = new FileOutputStream(fileEDC);
        for (int i = 0;i < tabelaEncrypted.length(); ++i){
            fileOutEDC.write(tabelaEncrypted.charAt(i));
        }
        fileOutEDC.write(encrypted);
        fileOutEDC.close();
    }

    private String generateStringTableCodeEDT(HashMap<Character, String> codeMap) {
        StringBuffer str = new StringBuffer();
        Iterator it = codeMap.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry mapElement = (Map.Entry)it.next();
            str.append(mapElement.getKey()).append(mapElement.getValue());
        }
        str.append((char)1);
        return str.toString();
    }

    private String generateStringTableCodeEDC(HashMap<Character, String> codeMap) {
        StringBuffer str = new StringBuffer();
        Iterator it = codeMap.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry mapElement = (Map.Entry)it.next();
            str.append(mapElement.getKey()).append(mapElement.getValue());
        }
        str.append((char)1);
        str.append('\n');
        return str.toString();
    }

    private byte[] generateBitSet(String encrypted) {
        BitSet bit = new BitSet();
        for (int i = 0; i < encrypted.length(); ++i){
            if(encrypted.charAt(i) == '1'){
                bit.set(i);
            }
        }
        return bit.toByteArray();
    }

    private String generateEnchantedMail(String fileNameIn, HashMap<Character, String> codeMap) throws IOException {

        FileInputStream stream = new FileInputStream(fileNameIn);
        Reader rdr = new InputStreamReader(stream, Charset.forName("ISO-8859-1"));
        int contentIn = rdr.read();

        StringBuffer contenteEncriptedOut = new StringBuffer();

        while (contentIn != -1) {
            Character key = (char) contentIn;
            contenteEncriptedOut.append(codeMap.get(key));
            contentIn = rdr.read();
        }

        stream.close();
        rdr.close();

        contenteEncriptedOut.append(codeMap.get((char)3));

        return contenteEncriptedOut.toString();
    }

    private HashMap<Character, Integer> lettersFrequency(String fileName) throws IOException {
        HashMap<Character, Integer> charFrequency = new HashMap<>();
        FileInputStream rdr = new FileInputStream(fileName);

        int content = rdr.read();
        while (content != -1) {
            Character key = (char) content;

            charFrequency.computeIfPresent(key, (Character character, Integer frequency) -> ++frequency);
            charFrequency.putIfAbsent(key, 1);

            content = rdr.read();
        }

        rdr.close();

        return charFrequency;
    }

    private HashMap<Character, String> generateTableCode(Node root){
        HashMap<Character, String> codeMap = new HashMap<>();
        String byteCode = new String();
        generateNodeNumbers(codeMap, root, byteCode);
        return codeMap;
    }

    private void generateNodeNumbers(HashMap<Character, String> codeMap , Node root, String byteCode){

        if (root.getLetter() != null) {
            codeMap.put(root.getLetter(), byteCode);
        }

        if (root.getLeft() != null) {
            String byteCodAux = byteCode + '0';
            generateNodeNumbers(codeMap, root.getLeft(), byteCodAux);
        }

        if (root.getRight() != null) {
            String byteCodAux = byteCode + '1';
            generateNodeNumbers(codeMap, root.getRight(), byteCodAux);
        }
    }

    /*
    private void generateNodeNumbersInBitCode(HashMap<Character, BitSet> codeMap , Node root, BitSet byteCode, int index){

        if (root.getLetter() != null) {
            codeMap.put(root.getLetter(), byteCode);
        }

        if (root.getLeft() != null) {
            BitSet byteCodAux = (BitSet) byteCode.clone();
            generateNodeNumbersInBitCode(codeMap, root.getLeft(), byteCodAux, ++index);
        }

        if (root.getRight() != null) {
            BitSet byteCodAux = (BitSet) byteCode.clone();
            byteCodAux.set(index);
            generateNodeNumbersInBitCode(codeMap, root.getRight(), byteCodAux, ++index);
        }
    }
    */
}
