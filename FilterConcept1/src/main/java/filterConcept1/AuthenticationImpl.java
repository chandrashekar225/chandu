package filterConcept1;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationImpl implements Authentication{

	@Override
	public boolean validLogin(String user, String pass) {
		// TODO Auto-generated method stub
	boolean flag =false;
		
		Map<String, String> map=new HashMap<String, String>();
		try {
			map.put("userName", "sidhi");
			map.put("pasword", "123");
		

		
		} catch (Exception e) {
			e.printStackTrace();		
			}
		if (map.containsValue(user) &&map.containsValue(pass)) {
			
			flag=true;
		} else {
			flag=false;
		}
		return flag;
		
	}

}
