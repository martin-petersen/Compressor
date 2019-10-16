package br.com.projeto.edb.entits;

import java.io.*;
import java.util.*;

public class Extrator {
    private byte[] bytes;

    public Extrator (String fileTxT, String fileEDZ, String fileEDT) throws IOException {
        convertMail(readFileToByteArray(fileEDZ));

    }

    private void readTableFile (String fileEDT) {

    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    private void readFileToByteArray (String fileEDZ){
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
        this.bytes = bArray;
    }

    private void convertMail (byte[] bytes) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            str.append(new StringBuilder(String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(" ", "0")).reverse());
        }

        System.out.println(str);
    }
}
