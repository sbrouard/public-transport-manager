package tec;

/**
 * Permet à une classe faussaire d'enregistrer
 * le nom de la méthode appelee/declenchee.
 *
 * Arbitrairement, il y a 20 enregistrements au maximum.
 */
class Messages {
  final private String[] data = new String[20];
  private int nbElement;

  /**
   * Efface tous les enregistrements
   */
  void clear() {
    for (int i = 0; i < data.length; i++) {
      if (data[i] == null)
	break;
      data[i] = null;
    }
    nbElement = 0;
  } 

  /**
   * Nombre d'enregistrements effectues
   */
  int size() {
    return nbElement;
  }

  /** 
   * Ajoute un enregistrement
   */  
  void add(String s) {
    data[nbElement++] = s;
  }

  /** 
   * fournit le dernier enregistrement
   */
  String getLast() {
    return get(size());
  }

  /** 
   * Fournit le nieme enregistrement.
   * La numérotation commence à 1.
   */
  String get(int num) {
    assert num > 0 : "pas de message";
    return data[num - 1];
  }

  /* 
   * tests
   */
  static public void main(String[] argv) {
    Messages m = new Messages();
    
    // test 1
    assert 0 == m.size() : "0";
    assert m.get(1) == null : "null";    
    
    // test 2
    m.add("un");
    m.add("deux");
    m.add("trois");

    assert      3 == m.size() : "3";
    assert "deux"  == m.get(2) : "deux";    
    assert "un"    == m.get(1) : "un";    
    assert "trois" == m.get(3) : "trois";    
    assert    null == m.get(4) : "null 4";    
    assert    null == m.get(10): "null 10";    

    // test 3
    m.clear();

    assert 0 == m.size() : "0";
    assert m.get(1) == null : "null 1";    
    assert m.get(3) == null : "null 3";    
    assert m.get(4) == null : "null 4";    

    assert fin("OK " + m.getClass().getName());
  }

  static private boolean fin(String s) {
    System.out.println(s);
    return true;
  }
}
