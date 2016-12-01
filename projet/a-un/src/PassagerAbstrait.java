package tec;

abstract public class PassagerAbstrait extends Passager implements Usager{
    private Position pos;
    private String name;
    private int dst;
    final private ComportementArret compArret;

    public PassagerAbstrait(String nom, int destination,ComportementArret comp) {
	if(destination <0){
	    throw new IllegalArgumentException("destination must be >= 0");
	}
	name = nom;
	dst = destination;
	compArret = comp;
	pos = new Position();
    }
    
    public int getDestination(){
	return dst;
    }

    // Change la position d'un passager en assis
    void changerEnAssis() {
	pos = pos.assis();
    }

    // Change la position d'un passager en debout
    void changerEnDebout() {
	pos = pos.debout();
    }

    // Change la position d'un passager en dehors
    void changerEnDehors() {
	pos = pos.dehors();
    }

    // Le passager est-il assis dans l'autobus ?
    boolean estAssis() {
	return pos.estAssis();
    }
    
    // Le passager est-il debout dans l'autobus ?
    boolean estDebout() {
	return pos.estDebout();
    }

    // Le passager est-il en dehors d'un autobus ?
    boolean estDehors() {
	return pos.estDehors();
    }

    // Fournit a un passager l'autobus auquel il peut accéder
    public void monterDans(Transport b) throws TecInvalidException{
	Vehicule t = (Vehicule) b;
	if (!(t instanceof Vehicule))
	    throw new TecInvalidException("Error type conversion");
	try{
	    choixPlaceMontee(t);
	}
	catch(IllegalStateException e)
	    {
		throw new TecInvalidException(e);
	    }
	    
    }

    // Fournit le nom d'un passager
    public String nom() {
	return name;
    }
    
    // Indique au passager qu'il est arrivé à un nouvel arret
    void nouvelArret(Vehicule bus, int numeroArret) {
	compArret.choixChangerPlace(dst-numeroArret, bus, this);
	if (numeroArret == dst) bus.arretDemanderSortie(this);
    }

    abstract protected void choixPlaceMontee(Vehicule v);
    
    public String toString() {
	return name + pos.toString();
    }
}
