package tp3;

import repast.simphony.context.Context;

public class Resource extends Agent {
	public Resource(Context<Agent> context){
		context.add(this);
	}
}