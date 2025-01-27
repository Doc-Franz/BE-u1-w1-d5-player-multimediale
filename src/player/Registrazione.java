package player;

public class Registrazione extends ContenutoMultimediale implements ContenutoRiproducibile{
    private int durata;
    private int volume;

    public Registrazione(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
    }

    public void play(){
        for (int i = 0; i < durata; i++){
        System.out.println(getTitolo() + " " + "!".repeat(volume));}
    };

    public void alzaVolume(){
        volume ++;
    };

    public void abbassaVolume(){
        volume --;
    };


    public void info(){
        System.out.println("Il titolo della Registrazione è " + this.getTitolo() + ", la durata è di " + this.durata + " min," + "il volume è " + this.volume);
    }
}
