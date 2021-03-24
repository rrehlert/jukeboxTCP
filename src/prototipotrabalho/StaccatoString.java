/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipotrabalho;

public class StaccatoString {
    
    //atributos da classe
    
    private int oitava;
    private int instrumento;
    private int volume;
    private int BPM;
    private String sequenciaNotas;
    
    //constantes da classe
    
    private final int OITAVA_MAXIMA = 10;
    private final int OITAVA_MINIMA = 0;
    private final int OITAVA_DEFAULT = 5;
    
    private final int INSTRUMENTO_MAXIMO = 48;
    private final int INSTRUMENTO_MINIMO = 0;
    
    private final int VOLUME_MAXIMO = 12000;
    private final int VOLUME_MINIMO = 500;
    private final int VOLUME_DEFAULT = 3000;
    
    private final int BPM_MINIMO = 30;
    private final int BPM_DEFAULT = 60;
    
    //métodos da classe
    
    public StaccatoString(){
        this.oitava = OITAVA_DEFAULT;
        this.instrumento = 0;
        this.volume = VOLUME_DEFAULT;
        this.BPM = BPM_DEFAULT;
        this.sequenciaNotas = "";
    }
    
    public void aumentaVolume(StaccatoString staccato){
        if((staccato.volume * 2) >= VOLUME_MAXIMO){
            staccato.volume = VOLUME_MAXIMO;
        }
        else{
            staccato.volume *= 2;
        }
    }
    
    public void resetaVolume(StaccatoString staccato){
        staccato.volume = VOLUME_DEFAULT;
    }
    
    public void defineVolume(StaccatoString staccato, int volume){
       if((volume >= VOLUME_MINIMO) && (volume <= VOLUME_MAXIMO)){
           staccato.volume = volume;
       }
    }
    
    public void aumentaBPM(StaccatoString staccato){
        staccato.BPM += 50;
    }
    
    public void diminuiBPM(StaccatoString staccato){
        if((staccato.BPM - 50) <= BPM_MINIMO){
            staccato.BPM = BPM_MINIMO;
        }
        else{
            staccato.BPM -= 50;
        }
    }
    
    public void defineBPM(StaccatoString staccato, int BPM){
       if(BPM >= BPM_MINIMO){
           staccato.BPM = BPM;
       }
    }
    
    public void aumentaOitava(StaccatoString staccato){
        if((staccato.oitava + 1) >= OITAVA_MAXIMA){
            staccato.oitava = OITAVA_MAXIMA;
        }
        else{
            staccato.oitava ++;
        }
    }
    
    public void diminuiOitava(StaccatoString staccato){
        if((staccato.oitava - 1) <= OITAVA_MINIMA){
            staccato.oitava = OITAVA_MINIMA;
        }
        else{
            staccato.oitava --;
        }
    }
    
    public void defineOitava(StaccatoString staccato, int oitava){
       if((oitava >= OITAVA_MINIMA) && (oitava <= OITAVA_MAXIMA)){
           staccato.oitava = oitava;
       }
    }
    
    public void defineInstrumento(StaccatoString staccato, int instrumento){
        if((instrumento >= INSTRUMENTO_MINIMO) && (instrumento <= INSTRUMENTO_MAXIMO)){
           staccato.instrumento = instrumento;
       }
    }
    
    public void defineSequenciaDeNotas(StaccatoString staccato, String notas){
        staccato.sequenciaNotas = notas;
    }
    
    public void adicionaNotas(StaccatoString staccato, String notas){
        staccato.sequenciaNotas = staccato.sequenciaNotas + notas;
    }
    
    public String montaStaccatoComAtributos(StaccatoString staccato){
        
        String sequenciaNotasComOitavas = staccato.sequenciaNotas.replace(" ", staccato.oitava + " ");
        return "T" + staccato.BPM + " V0 I" + staccato.instrumento + " " + sequenciaNotasComOitavas;
    }
    
}
