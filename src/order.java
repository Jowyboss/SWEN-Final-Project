
public class order {

	String name;
	int size;
	double price;
	String type;
	
	public order(){}
	
	public order(String n,int p,double pp,String t) {
		name = n;
		size = p;
		type = t;
		price = pp;
	}
	void setorder(String n,int p,double pp,String t) {
		name = n;
		size = p;
		type = t;
		price = pp;
	}
	
	public void setPrice(String pr) {
		price = Double.parseDouble(pr);
	} 
	
	String getName() {
		return name;
	}
	
	String getType() {
		return type;
	}
	
	double getPrice() {
		return price;
	}
	
	int getSize() {
		return size;
	}
}
