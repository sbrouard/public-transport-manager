package tec;

public class TecInvalidException extends Exception {
    
    public TecInvalidException(String msg){
	System.out.println("TecInvalidException : " + msg);
    }
    
    public TecInvalidException(Exception e){
	e.toString();
    }
}
