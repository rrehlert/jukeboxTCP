/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipotrabalho;

public class StaccatoString {
    
    private int oitava;
    private int instrumento;
    private int volume;
    private int BPM;
    private String sequenciaNotas;
    
    
    private static final int OITAVA_MAXIMA = 10;
    private static final int OITAVA_MINIMA = 0;
    private static final int OITAVA_DEFAULT = 5;
    
    private static final int INSTRUMENTO_MAXIMO = 127;
    private static final int INSTRUMENTO_MINIMO = 0;
    
    private static final int VOLUME_MAXIMO = 127;
    private static final int VOLUME_MINIMO = 31;
    private static final int VOLUME_DEFAULT = 63;
    
    private static final int BPM_MINIMO = 60;
    private static final int BPM_MAXIMO = 210;
    
    
    public StaccatoString(){
        this.oitava = OITAVA_DEFAULT;
        this.instrumento = INSTRUMENTO_MINIMO;
        this.volume = VOLUME_DEFAULT;
        this.BPM = BPM_MINIMO;
        this.sequenciaNotas = "";
    }
    
    private void resetaVolume(){
        this.volume = VOLUME_DEFAULT;
    }
    
    public void defineVolume(int volume){
       if((volume >= VOLUME_MINIMO) && (volume <= VOLUME_MAXIMO)){
           this.volume = volume;
       }
    }
    
    public void dobraVolume(){
        if((this.volume * 2) > VOLUME_MAXIMO){
            this.resetaVolume();
        }
        else{
            this.volume *= 2;
        }
    }
    
    public void defineBPM(int BPM){
       if((BPM >= BPM_MINIMO) && (BPM <= BPM_MAXIMO)){
           this.BPM = BPM;
       }
    }
    
    public void aumentaBPM(){
        this.BPM += 50;
    }
    
    public void diminuiBPM(){
        if((this.BPM - 50) <= BPM_MINIMO){
            this.BPM = BPM_MINIMO;
        }
        else{
            this.BPM -= 50;
        }
    }
    
    private void resetaOitava(){
        this.oitava = OITAVA_DEFAULT;
    }
    
    public void defineOitava(int oitava){
       if((oitava >= OITAVA_MINIMA) && (oitava <= OITAVA_MAXIMA)){
           this.oitava = oitava;
       }
    }
    
    public void aumentaOitava(){
        if((this.oitava + 1) > OITAVA_MAXIMA){
            this.resetaOitava();
        }
        else{
            this.oitava ++;
        }
    }
    
    public void diminuiOitava(){
        if((this.oitava - 1) <= OITAVA_MINIMA){
            this.oitava = OITAVA_MINIMA;
        }
        else{
            this.oitava --;
        }
    }
    
    public int retornaInstrumento(){
        return this.instrumento;
    }
    
    public void defineInstrumento(int instrumento){
        if((instrumento >= INSTRUMENTO_MINIMO) && (instrumento <= INSTRUMENTO_MAXIMO)){
           this.instrumento = instrumento;
       }
    }
    
    public void apagaSequenciaDeNotas(){
        this.sequenciaNotas = "";
    }
    
    public void adicionaNota(char nota){
        this.sequenciaNotas = this.sequenciaNotas + nota + " ";
    }
    
    public void adicionaPausa(){
        this.sequenciaNotas = this.sequenciaNotas + "R ";
    }
    
    private String adicionaOitavasNaSequencia(){
        return this.sequenciaNotas.replace(" ", this.oitava + " ");
    }
    
    public String geraStringParametrizada(){
        
        String sequenciaNotasComOitavas = adicionaOitavasNaSequencia();
        return ("T" + this.BPM + " V0 I" + this.instrumento + " :CON(7," + this.volume + ") " + sequenciaNotasComOitavas);
    }
    
}
