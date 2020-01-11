package observer;

public interface Observable{

	public abstract void notifyObservers(Object arg);
	
	public abstract void addObserver(Observer observer);
	
	public abstract void removeObserver(Observer observer);
	
}
