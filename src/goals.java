/*Jowayne Anderson, 620150840 */
public class goals {

	String name;
	double cost;
	
	public goals(){}
	
	public goals(String n,double p) {
		name = n;
		cost = p;
	}
	void setgoal(String n,double p) {
		name = n;
		cost = p;
	}
	
	String getName() {
		return name;
	}
	
	double getCost() {
		return cost;
	}
}
