package tec;

/**
 * Cette classe représente la position d'un passager par rapport à un transport.
 * Une position a trois états possibles : assis dans un transport, 
 * debout dans un transport et dehors d'un transport.
 *
 * Les instances de cette classe sont des objets constants.
 *
 * @author Georgy
 * @since 2007-2016
 **/
class Position {

  private final int DEHORS = 1;
  private final int ASSIS  = 2;
  private final int DEBOUT = 3;

  private final int courant;

  /**
   * construit une l'instance dans la position dehors.
   * 
   */
  public Position() {
    courant = DEHORS;
  }

  /**
   * Construit une instance en précisant un des positions du passager.
   * 
   * @param e valeur de l'état.
   */
  private Position(int e) {
    courant = e;
  }

  /**
   * La position est-elle dehors ?
   *
   * @return vrai si l'état de l'instance est dehors;
   */
  public boolean estDehors() {
    return courant != ASSIS && courant != DEBOUT;
  }

  /**
   * La position est-elle assis ?
   *
   * @return vrai si l'état de l'instance est assis;
   */
  public boolean estAssis() {
    return courant == ASSIS;
  }

  /**
   * La position est-elle debout ?
   *
   * @return vrai si l'état de l'instance est debout;
   */
  public boolean estDebout() {
    return courant == DEBOUT;
  }

  /**
   * La position est-elle assis ?
   *
   * @return vrai la position est assis ou debout.
   */
  public boolean estInterieur() {
    return courant != DEHORS;
  }


  /**
   * Fournit une position assis.
   *
   * @return instance dans l'état assis.
   */
  public Position assis() {
    return new Position(ASSIS); 
  }

  /**
   * Fournit une position debout.
   *
   * @return instance dans l'état debout.
   */
  public Position debout() {
    return new Position(DEBOUT);
  }

  /**
   * Fournit une position dehors.
   *
   * @return instance dans l'état dehors.
   */
  public Position dehors() {
    return new Position(DEHORS);
  }

  /**
   * Cette méthode est héritée de la classe {@link java.lang.Object}.
   * Très utile pour le débogage, elle permet de fournir une 
   * chaîne de caractères correspondant à l'état d'un objet.
   * Mais, il faut adapter son code à chaque classe.
   * 
   * @return une des chaînes "<endehors>", "<assis>", "<debout>" 
   * en fonction de la position courante.
   */
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
