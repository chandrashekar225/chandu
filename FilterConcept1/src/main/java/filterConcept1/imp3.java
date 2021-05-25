package filterConcept1;

import java.util.HashMap;

public class imp3 implements rw2 {

	@Override
	public boolean valid(String user, String pass) {
		boolean flag=false;
		HashMap<String, String> map=new HashMap<String, String>();
		try {
			map.put("username", "shashi");
			map.put("password", "143");
			
		} catch (Exception e) {
e.printStackTrace();	
}
	if(map.containsValue(user)&&map.containsValue(pass)) {
		flag=true;
	}
	else {
		flag=false;
	}
		return flag;
	}

}
