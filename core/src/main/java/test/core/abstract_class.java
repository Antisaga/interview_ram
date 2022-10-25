package test.core;

public abstract class abstract_class {
// contains at lesat one abstract method or no methods at all
// can't be instantiated 
	
	public void paymentForWork(int hours){
		System.out.println("The Wrestlers Make $ "+ hours*250.00 + " for tonight's match.");
	}
	public abstract void theMusic(String music); // NO BODY
	public abstract void finisher(String finisher); // NO BODY

}

