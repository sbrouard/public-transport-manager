package tec;
/**
 * Réalisation d'une jauge avec un intervalle d'entiers.
 * <p>
 * Un objet Jauge définit un niveau dans un intervalle [0, vigieMax[. 
 * Le niveau d'une jauge n'est pas limité aux valeurs dans l'intervalle.
 * <p>
 * L'état d'une jauge correspond à la position de son niveau par rapport à 
 * l'intervalle [0, vigieMax[.
 * Une jauge définit deux états : 
 * <ul>
 * <li>rouge niveau supérieur à l'intervalle,
 * <li>vert niveau dans l'intervalle, 
 * </ul>
 * 
 * @author georgy
 * @since 2006-2016
 */
class Jauge { 
  private int valeur;
  private final int max;

  /**
   * Construit une instance en précisant la valeur de départ de la Jauge
   * et l'intervalle de vigie.
   * 
   * @param vigieMax valeur maximale > 0 de l'intervalle de vigie.
   * @param depart       valeur initiale du niveau.
   */
  public Jauge(int vigieMax, int depart) {
    valeur = depart;
    max = vigieMax;

    if (vigieMax <=0) 
      throw new IllegalArgumentException("vigieMax must be > 0");
  }

  /**
   * Le niveau de la jauge est-il au-dessus de vigieMax ?
   *
   * @return vrai si niveau >=  vigieMax.
   *
   */
  public boolean estRouge() {
    return valeur >= max;
  }

  /**
   * Le niveau de la jauge est-il dans l'intervalle ?
   *
   * @return vrai si niveau appartient à [0, vigieMax[.
   *
   */
  public boolean estVert() {
    return valeur >= 0 && !estRouge();
  }

  /**
   * Incrémente le niveau d'une unité.
   * Le niveau peut devenir supérieur à vigieMax.
   */
  public void incrementer() {
    valeur++;
  }

  /**
   * Décrémente le niveau d'une unité.
   */
  public void decrementer() {
      valeur--;
  }

  /**
   * Cette méthode est héritée de la classe {@link java.lang.Object}.
   * Très utile pour le débogage, elle permet de fournir une 
   * chaîne de caractères correspondant a l'état d'un objet.
   * Mais, il faut adapter son code à chaque classe.
   *
   * @return la chaîne "<7 [0,23[>" si l'état d'une jauge 
   * est vigieMax=23, niveau=7 ;
   * 
   */
  @Override
  public String toString() {
    return "<" + (max-valeur) + ">"; 
  }
}
