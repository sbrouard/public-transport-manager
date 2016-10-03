package tec;

class Position {

  private final int DEHORS = 1;
  private final int ASSIS  = 2;
  private final int DEBOUT = 3;

  private final int courant;

  public Position() {
    courant = DEHORS;
  }

  private Position(int e) {
    courant = e;
  }

  public boolean estDehors() {
    return courant != ASSIS && courant != DEBOUT;
  }

  public boolean estAssis() {
    return courant == ASSIS;
  }

  public boolean estDebout() {
    return courant == DEBOUT;
  }

  public boolean estInterieur() {
    return courant != DEHORS;
  }

  public Position assis() {
    return new Position(ASSIS); 
  }

  public Position debout() {
    return new Position(DEBOUT);
  }

  public Position dehors() {
    return new Position(DEHORS);
  }

  @Override
  public String toString() {
    String nom = null;
    switch(courant) {
    case DEHORS :
      nom = "endehors";
      break;
    case ASSIS :
      nom = "assis";
      break;
    case DEBOUT :
      nom = "debout";
      break;
    }
    return "<" + nom + ">";
  }
}
