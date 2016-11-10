Ppackage tec;

abstract class Passager {
    abstract boolean estDehors();
    
    abstract void nouvelArret(Vehicule b, int numeroArret);
    
    abstract boolean estAssis();
    abstract boolean estDebout();
    
    abstract void changerEnDehors();
    abstract void changerEnAssis();
    abstract void changerEnDebout();

    abstract String nom();
}
