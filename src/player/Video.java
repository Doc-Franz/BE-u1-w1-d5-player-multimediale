package player;

public class Video extends ContenutoMultimediale implements ContenutoRiproducibile, ContenutoNonRiproducibile {
    private int durata;
    private int volume;
    private int luminosità;

    public Video(String titolo, int durata, int volume, int luminosità) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
        this.luminosità = luminosità;
    }

    public void play(){

    };

    public void alzaVolume(){
        volume ++;
    };

    public void abbassaVolume(){
        volume --;
    };

    public void alzaLuminosità() {
        luminosità ++;
    }

    public void abbassaLuminosità() {
        luminosità --;
    }

    public void info(){
        System.out.println("Il titolo del Video è " + this.getTitolo() + ", la durata è di " + this.durata + " min," + "il volume è " + this.volume + ", la luminosità è " + this.luminosità);
    }
}
