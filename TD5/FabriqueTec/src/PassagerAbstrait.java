package tec;

abstract public class PassagerAbstrait implements Passager, Usager{
    private Position pos;
    private String name;
    private int dst;

    public PassagerAbstrait(String nom, int destination) {
	name = nom;
	dst = destination;
	pos = new Position();
    }
    
    public int getDestination(){
	return dst;
    }

    // Change la position d'un passager en assis
    public void changerEnAssis() {
	pos = pos.assis();
    }

    // Change la position d'un passager en debout
    public void changerEnDebout() {
	pos = pos.debout();
    }

    // Change la position d'un passager en dehors
    public void changerEnDehors() {
	pos = pos.dehors();
    }

    // Le passager est-il assis dans l'autobus ?
    public boolean estAssis() {
	return pos.estAssis();
    }
    
    // Le passager est-il debout dans l'autobus ?
    public boolean estDebout() {
	return pos.estDebout();
    }

    // Le passager est-il en dehors d'un autobus ?
    public boolean estDehors() {
	return pos.estDehors();
    }

    // Fournit a un passager l'autobus auquel il peut accéder
    public void monterDans(Transport b) {
	Vehicule t = (Vehicule) b;
	choixPlaceMontee(t);
    }

    // Fournit le nom d'un passager
    public String nom() {
	return name;
    }
    
    // Indique au passager qu'il est arrivé à un nouvel arret
    public void nouvelArret(Vehicule bus, int numeroArret) {
	choixChangerPlace(bus,numeroArret);
	if (numeroArret == dst) bus.arretDemanderSortie(this);
    }

    abstract protected void choixPlaceMontee(Vehicule v);
    abstract protected void choixChangerPlace(Vehicule v, int arret);
    
    
    public String toString() {
	return name + pos.toString();
    }
}
