package tec;

abstract class Vehicule{
    abstract void monteeDemanderAssis(Passager p);
    abstract void monteeDemanderDebout(Passager p);
    
    abstract void arretDemanderDebout(Passager p);
    abstract void arretDemanderAssis(Passager p);
    abstract void arretDemanderSortie(Passager p);
    
    abstract boolean aPlaceAssise();
    abstract boolean aPlaceDebout();
}
