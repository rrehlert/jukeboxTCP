/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipotrabalho;

import org.jfugue.player.Player;

public class TocadorDeMusica {
    
    //atributos da classe
    
    private String staccatoPrincipal;
    
    //métodos da classe
    
    public TocadorDeMusica(){
        this.staccatoPrincipal = "";
    }
    
    public void defineStringPrincipal(TocadorDeMusica jukebox, String staccato){
        jukebox.staccatoPrincipal = staccato;
    }
    
    public void TocaMusica(TocadorDeMusica jukebox){
        Player player = new Player();
        player.play(jukebox.staccatoPrincipal);
    }
   
}
