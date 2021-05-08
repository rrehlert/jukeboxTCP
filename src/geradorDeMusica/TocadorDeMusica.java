/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorDeMusica;

import org.jfugue.player.Player;

public class TocadorDeMusica {
    
    private String staccato;
    
    
    public TocadorDeMusica(){
        this.staccato = "";
    }
    
    public void defineStaccato(String staccato){
        this.staccato = staccato;
    }
    
    public void tocaMusica(){
        Player player = new Player();
        player.play(this.staccato);
    }

}
