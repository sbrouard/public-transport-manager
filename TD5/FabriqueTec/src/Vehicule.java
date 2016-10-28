package tec;

interface Vehicule {
  public boolean aPlaceAssise();
  public boolean aPlaceDebout();

  void allerArretSuivant();

  void monteeDemanderAssis(Passager p);
  void monteeDemanderDebout(Passager p);

  public void arretDemanderDebout(Passager p);
  public void arretDemanderAssis(Passager p);
  public void arretDemanderSortie(Passager p);
}
