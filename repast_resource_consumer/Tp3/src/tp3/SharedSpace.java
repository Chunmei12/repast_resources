package tp3;

import java.util.HashSet;
import java.util.Set;


public class SharedSpace<T extends Agent> {

	private Set<T> space = new HashSet<T>();
	private Set<T> historySpace = new HashSet<T>();

	public  synchronized T take(T entity) throws InterruptedException {
		while(true) {
			synchronized(space){
				for(T t : space)
					if(t.getType().equals(entity.getType())) {
						space.remove(t);
						historySpace.add(t);
					    return t;
					
				}
			}
				
			
			 wait();
			   
		}
	}
	
	public synchronized void add(T entity) {
		if(!historySpace.contains(entity)) { //
			space.add(entity);
			notifyAll();
		}
	}


	
}
