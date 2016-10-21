package tec;

abstract public class PassagerAbstrait extends Passager implements Usager{
    Position pos;
    String name;
    int dst;

    public PassagerAbstrait(String nom, int destination) {
	name = nom;
	dst = destination;
	pos = new Position();
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
    public void monterDans(Transport b) {
	Vehicule t = (Vehicule) b;
	if (t.aPlaceAssise()){
	    t.monteeDemanderAssis(this);
	}
	else if (t.aPlaceDebout()){
	    t.monteeDemanderDebout(this);
	}
    }

    // Fournit le nom d'un passager
    public String nom() {
	return name;
    }
    
    // Indique au passager qu'il est arrivé à un nouvel arret
    void nouvelArret(Vehicule bus, int numeroArret) {
	if (numeroArret == dst) bus.arretDemanderSortie(this);
    }
    
    public String toString() {
	return name + pos.toString();
    }
}
