//package MyPrac;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//
//public class DriverInstansiate {
//static WebDriver driver = null;
//static DriverInstansiate d = null;
//	
//
//	private DriverInstansiate() {}
//	public static DriverInstansiate getInstance() {
//		if(d==null) {
//			d = new DriverInstansiate();
//			System.setProperty("webdriver.chrome.driver", "E:\\Jar\\chromedriver.exe");
//			System.out.println("Initializing Chrome");
//			driver = new ChromeDriver();
//		}
//		return d;
//	
//}
//}
