/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipotrabalho;

import java.io.File;
import java.io.IOException;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;

public class GravadorDeMusica {
    
    private String nomeArquivo;
    
    
    public GravadorDeMusica(){
        this.nomeArquivo = "";
    }
    
    public void defineNomeArquivo(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }
   
    public void gravaMusica(String staccato){
        
        Pattern pattern = new Pattern(staccato);
        
        try {
            MidiFileManager.savePatternToMidi(pattern, new File(this.nomeArquivo));
        } 
        catch (IOException ex) {}
    }
}
