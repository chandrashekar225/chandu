package filterConcept1;

import java.util.HashMap;

public class imp2 implements rw1 {

	@Override
	public boolean valid(String user, String pass) {
		boolean flag=false;
		HashMap<String, String> map=new HashMap<String, String>();
		try {
			map.put("username", "rajini");
			map.put("password", "123");
			
		} catch (Exception e) {
e.printStackTrace();

		}
		
		if (map.containsValue(user)&&map.containsValue(pass)) {
			flag=true;
		} else {
flag=false;
		}
		return flag;
	}

}
