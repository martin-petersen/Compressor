package br.com.projeto.edb.entits;

import java.io.*;
import java.util.*;

public class Extrator {
    private byte[] bytes;
    private HashMap<Character, String> map;

    public Extrator (String fileTxT, String fileEDZ, String fileEDT) throws IOException {
        readTableFile(fileEDT);
        readFileToByteArray(fileEDZ);
        convertMail(this.bytes);

    }

    private void readTableFile (String fileEDT) throws IOException {
        FileReader rdr = new FileReader(fileEDT);
        BufferedReader brdr = new BufferedReader(rdr);
        ArrayList<String> str = new ArrayList<>();
        String st;
        while((st = brdr.readLine()) != null) {
            str.add(st);
        }

        for(int i = 0; i<str.size(); ++i) {
            StringBuffer sb = new StringBuffer();
            for(int j = 1; j<str.get(i).length(); ++j) {
                sb.append(str.get(i).charAt(j));
            }
            System.out.println(sb);
            //this.map.put(str.get(i).charAt(0),s);
        }
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
    }
}
