package sk.upjs.ics.paz1c.binarytree;


public class Vrchol {
    private String hodnota;
    
    private Vrchol lavyVrchol;
    
    private Vrchol pravyVrchol;

    public Vrchol(String hodnota, Vrchol lavyVrchol, Vrchol pravyVrchol) {
        this.hodnota = hodnota;
        this.lavyVrchol = lavyVrchol;
        this.pravyVrchol = pravyVrchol;
    }

    public Vrchol(String hodnota) {
        this.hodnota = hodnota;
    }

    
    
    public Vrchol getLavyVrchol() {
        return lavyVrchol;
    }

    public Vrchol getPravyVrchol() {
        return pravyVrchol;
    }

    public void vypisDoHlbky(Visitor visitor) {
        visitor.visit(this);

        if(this.getLavyVrchol() != null) {
            this.getLavyVrchol().vypisDoHlbky(visitor);
        }
        if(this.getPravyVrchol() != null) {
            this.getPravyVrchol().vypisDoHlbky(visitor);
        }
    }

    public String getHodnota() {
        return this.hodnota;
    }
    
    
    
}
