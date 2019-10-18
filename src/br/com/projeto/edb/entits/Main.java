package br.com.projeto.edb.entits;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        if( args[0].equals(new String("compress"))){
            if(args.length > 3){
                Compressor a = new Compressor(args[1],args[2], args[3]);
                return;
            }
            Compressor a = new Compressor(args[1],args[2]);
            return;
        }else if( args[0].equals(new String("extract"))){
            Extrator b = new Extrator(args[1],args[2], args[3]);
        }

    }


}
