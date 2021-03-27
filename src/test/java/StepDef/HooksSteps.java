package StepDef;

import Utilities.OpenCloseBrowser;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksSteps {
	
	@Before
	public void openBrowser() {
		OpenCloseBrowser.openChrome();
	}
	
	@After
	public void CloseBrowser() {
		OpenCloseBrowser.closeChrome();
	}

}
