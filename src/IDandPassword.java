import java.util.HashMap;

public class IDandPassword {

	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	IDandPassword(){
		
		logininfo.put("Jason","TricorCEO");
		logininfo.put("Donald","Tricoradmin");
		logininfo.put("Jefferey","Tricoradmin");
		logininfo.put("Ashley","Tricoradmin");
		logininfo.put("Kelsey","Tricoradmin");
		logininfo.put("ADMIN","Tricoradmin");
	}
	
	protected HashMap getLoginInfo(){
		return logininfo;
	}
}
