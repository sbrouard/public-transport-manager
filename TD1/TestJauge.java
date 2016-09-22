class TestJauge {

    public static void main(String[] args) {
    
    boolean estMisAssertion = false;
    assert estMisAssertion = true;

    if (!estMisAssertion) {
      System.out.println("Execution impossible sans l'option -ea");
      return;
    }
    TestJauge.testDansIntervalle();
    System.out.println("PASSED");
    

}
    static void testDansIntervalle(){
	Jauge j = new Jauge(67899, 100);
	assert j.estVert() : "error";
	assert !j.estRouge() : "error";
	
    }
}
