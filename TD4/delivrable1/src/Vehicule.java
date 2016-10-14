package tec;

public interface Vehicule {
  public boolean aPlaceAssise();
  public boolean aPlaceDebout();

  void allerArretSuivant();

  void monteedemanderAssis(Passager p);
  void monteedemanderDebout(Passager p);

  public void arretdemanderDebout(Passager p);
  public void arretdemanderAssis(Passager p);
  public void arretdemanderSortie(Passager p);
}
