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

    private final static Position dehors = new Position();
    private final static Position assis = new Position();
    private final static Position debout = new Position();

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
    private Position Position(int e) {
      switch(e){
      case DEHORS :
	  return dehors;
      case ASSIS :
	  return assis;
      case DEBOUT :
	  return debout;
      }
      return dehors;
    }
    
    
    
    

    /**
     * La position est-elle dehors ?
     *
     * @return vrai si l'état de l'instance est dehors;
     */
  public boolean estDehors() {
      return this != assis && this != debout;
  }
    
    /**
   * La position est-elle assis ?
   *
   * @return vrai si l'état de l'instance est assis;
   */
    public boolean estAssis() {
	return this == assis;
    }

    /**
     * La position est-elle debout ?
     *
     * @return vrai si l'état de l'instance est debout;
     */
  public boolean estDebout() {
      return this == debout;
  }
    
    /**
     * La position est-elle assis ?
   *
   * @return vrai la position est assis ou debout.
   */
    public boolean estInterieur() {
	return this != dehors;
    }
    
    
    /**
   * Fournit une position assis.
   *
   * @return instance dans l'état assis.
   */
    public Position assis() {
	return assis; 
  }
    
    /**
     * Fournit une position debout.
     *
     * @return instance dans l'état debout.
     */
    public Position debout() {
	return debout;
  }
    
    /**
     * Fournit une position dehors.
     *
     * @return instance dans l'état dehors.
     */
    public Position dehors() {
	return dehors;
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
	switch(this) {
	case dehors :
	    nom = "endehors";
	    break;
	case assis :
	    nom = "assis";
	    break;
	case debout :
	    nom = "debout";
	    break;
	}
	return "<" + nom + ">";
    }
}
