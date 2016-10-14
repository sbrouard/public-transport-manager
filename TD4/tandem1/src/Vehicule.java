package tec;

abstract class Vehicule {
  void monteeDemanderAssis(Passager p);
  void monteeDemanderDebout(Passager p);

  public void arretDemanderDebout(Passager p);
  public void arretDemanderAssis(Passager p);
  public void arretDemanderSortie(Passager p);
}
