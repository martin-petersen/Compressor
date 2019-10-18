package br.com.projeto.edb.entits;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class Extrator {
    private String code;
    private String mensagem;
    private HashMap<String,Character> map;

    public Extrator (String fileTxT, String fileEDZ, String fileEDT) throws IOException {
        readTableFile(fileEDT);
        convertMail(readFileToByteArray(fileEDZ));
        decode(getCode(), getMap());
        generateTXT(fileTxT);

    }

    public String getCode() {
        return code;
    }

    public HashMap<String, Character> getMap() {
        return map;
    }

    public String getMensagem() {
        return mensagem;
    }

    private void generateTXT(String fileTXT) throws IOException {
        FileOutputStream fileOutEDT = new FileOutputStream(fileTXT);
        for (int i = 0; i < getMensagem().length(); ++i){
            fileOutEDT.write(getMensagem().charAt(i));
        }
        fileOutEDT.close();
    }

    private void readTableFile (String fileEDT) throws IOException {
        FileInputStream rdr = new FileInputStream(fileEDT);
        Reader brdr = new InputStreamReader(rdr, Charset.forName("ISO-8859-1"));

        HashMap<String, Character> mapa = new HashMap<>();

        StringBuffer letterCode = new StringBuffer();
        char letterNow;
        char auxReader = (char) brdr.read();

        while( auxReader != (char) 1 ){

            letterNow = auxReader;

            if ((auxReader != '0') || (auxReader != '1')){
                auxReader = (char) brdr.read();
            }

            while((auxReader == '1') || (auxReader == '0')){
                letterCode.append(auxReader);
                auxReader = (char) brdr.read();
            }

            mapa.put(letterCode.toString(), letterNow);
            letterCode = new StringBuffer();
        }

        this.map = mapa;
    }

    private void decode(String code, HashMap<String,Character> codeMap) {
        StringBuffer sb = new StringBuffer();
        StringBuffer mensagem = new StringBuffer();
        for(int i=0; i<code.length(); ++i) {
            sb.append(code.charAt(i));
            if(codeMap.containsKey(sb.toString()) && codeMap.get(sb.toString()) != (char)3) {
                mensagem.append(codeMap.get(sb.toString()));
                sb.setLength(0);
            }
        }
        this.mensagem = mensagem.toString();
    }

    private byte[] readFileToByteArray (String fileEDZ){
        File file = new File(fileEDZ);
        FileInputStream fis = null;
        byte[] bArray = new byte[(int) file.length()];
        try{
            fis = new FileInputStream(file);
            fis.read(bArray);
            fis.close();

        }catch(IOException ioExp){
            ioExp.printStackTrace();
        }

        return bArray;
    }

    private void convertMail (byte[] bytes) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            str.append(new StringBuilder(String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(" ", "0")).reverse());
        }
        this.code = str.toString();
    }
}
