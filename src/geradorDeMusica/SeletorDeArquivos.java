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

public class SeletorDeArquivos {

    private String arquivo;
    
    
    public SeletorDeArquivos(){
        this.arquivo = null;
    }
    
    public String getArquivo(){
        return this.arquivo;
    }
    
    private String leArquivo() {
        if (this.arquivo != null) {
            File entrada = new File(this.arquivo);
            try {
                Scanner novoArquivo = new Scanner(entrada);
                novoArquivo.useDelimiter("\\Z");
                return novoArquivo.next();
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado");
            }
        }
            return null;
    }

    public String retornaConteudoSelecionado() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            //System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            this.arquivo = selectedFile.getAbsolutePath();
        } else {
            this.arquivo = null;
        }
        if (this.arquivo.substring(this.arquivo.lastIndexOf('.') + 1).equals("txt"))
            return this.leArquivo();
        else
            return "vazio";

    }
}

