/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorDeMusica;

import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeitorDeArquivos {

    private String caminhoArquivo;
    
    
    public LeitorDeArquivos(){
        caminhoArquivo = null;
    }
    
    private String leArquivo() {
        if (caminhoArquivo != null) {
            File entrada = new File(caminhoArquivo);
            try {
                Scanner leitor = new Scanner(entrada);
                leitor.useDelimiter("\\Z");
                return leitor.next();
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado");
            }
        }
        return null;
    }

    public String retornaConteudo() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            caminhoArquivo = selectedFile.getAbsolutePath();
        } else {
            caminhoArquivo = null;
        }
        if (result == JFileChooser.APPROVE_OPTION) {
            if (caminhoArquivo.substring(caminhoArquivo.lastIndexOf('.') + 1).equals("txt")) {
                return this.leArquivo();
            } else {
                return "-1";
            }
        }
        return "-1";
    }
}

