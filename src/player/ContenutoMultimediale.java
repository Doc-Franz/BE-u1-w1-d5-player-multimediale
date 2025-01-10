package player;

public abstract class ContenutoMultimediale {
    private String titolo;

    public ContenutoMultimediale(String titolo){
        this.titolo = titolo;
    }

    public String getTitolo(){
        return titolo;
    }

    public abstract void info();
}
