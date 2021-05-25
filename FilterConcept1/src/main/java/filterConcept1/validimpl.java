package filterConcept1;

import java.util.HashMap;

public class validimpl implements rw{

	@Override
	public boolean valid(String user, String pass) {
		boolean flag=false;
		HashMap<String, String> map=new HashMap<String, String>();
		try {
			map.put("username", "sweety");
			map.put("password", "134");
			
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
