/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipotrabalho;

import org.jfugue.player.Player;

public class TocadorDeMusica {
    
    //atributos da classe
    
    private String staccato;
    
    //métodos da classe
    
    public TocadorDeMusica(){
        this.staccato = "";
    }
    
    public void defineStaccato(TocadorDeMusica jukebox, String staccato){
        jukebox.staccato = staccato;
    }
    
    public void TocaMusica(TocadorDeMusica jukebox){
        Player player = new Player();
        player.play(jukebox.staccato);
    }
   
}
