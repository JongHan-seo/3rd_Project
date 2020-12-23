package frontcontroller;

import java.util.HashMap;

import com.controller.Controller;
import com.controller.JoinPageController;
import com.controller.LoginController;
import com.controller.LoginSuccess;
import com.controller.LogoutController;
import com.controller.MainPageController;
import com.controller.joinController;

public class HandlerMapping {
	
	private HashMap<String, Controller> mappings;
	
	public HandlerMapping (){
		mappings = new HashMap<>();
		initUrl(); 
	}
	
	private void initUrl() {    // 추가 매핑 여기서!
		mappings.put("/main.do", new MainPageController());
		mappings.put("/join.do", new joinController());
		mappings.put("/joinpage.do", new JoinPageController());
		mappings.put("/login.do", new LoginController());
		mappings.put("/loginsuccess.do", new LoginSuccess());
		mappings.put("/logout.do", new LogoutController());
		
	}
	
	public Controller getController(String command) {
		return mappings.get(command);
	}
	
	
	
}
