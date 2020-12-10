package frontcontroller;

import java.util.HashMap;

import com.controller.Controller;
import com.controller.MainPageController;

public class HandlerMapping {
	
	private HashMap<String, Controller> mappings;
	
	public HandlerMapping (){
		mappings = new HashMap<>();
		initUrl(); 
	}
	
	private void initUrl() {    // 추가 매핑 여기서!
		mappings.put("/main.do", new MainPageController());
		
	}
	
	public Controller getController(String command) {
		return mappings.get(command);
	}
	
	
	
}
