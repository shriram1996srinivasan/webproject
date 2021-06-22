package MyPrac;

import cucumber.api.DataTable;

//import org.openqa.selenium.remote.server.handler.GetPageSource;

import cucumber.api.java.en.Given;

public class DemoSD extends CommonUtil{
	@Given("^go to \"([^\"]*)\"$")
	public void go_to(String url) throws Exception {
	   try {
		GoToURL gourl = getPage(GoToURL.class);
		gourl.gotourl(url);
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	@Given("^go to$")
	public void go_to(DataTable url) throws Exception {
	   try {
		GoToURL gourl = getPage(GoToURL.class);
		gourl.gotourl(url);
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	@Given("^search \"([^\"]*)\"$")
	public void search(String input) throws Exception {
		   try {
				GoToURL gourl = getPage(GoToURL.class);
				gourl.search(input);
			} catch (Exception e) {
				e.printStackTrace();
			}
			} 
}
