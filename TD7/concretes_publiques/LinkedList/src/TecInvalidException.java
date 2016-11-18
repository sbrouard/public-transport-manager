package tec;

public class TecInvalidException extends Exception {
    
    public TecInvalidException(String msg){
	super(msg);
    }
    
    public TecInvalidException(Exception e){
	super(e);
    }
}
