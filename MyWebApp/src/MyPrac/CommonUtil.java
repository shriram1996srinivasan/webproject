package MyPrac;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import org.apache.poi.ss.formula.functions.T;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
//import org.apache.poi.xwpf.usermodel.XWPFParagraph;
//import org.apache.poi.xwpf.usermodel.XWPFRun;
//import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class CommonUtil {
	static boolean browserInvoked = false;
	static WebDriver drive;
	// static HashMap<String,List<File>> runt= new HashMap<>();
	// static List<File> ff = new ArrayList<>();

	public String screenCapture(String caption) throws IOException, InvalidFormatException {
		System.out.println("SCREENCAPTURE");
		String output = "";
		File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		File destdir = new File("report\\Screenshots");
		if (!destdir.exists()) {
			destdir.mkdir();
		}
		File dest = new File("report\\Screenshots\\" + System.currentTimeMillis() + ".jpeg");
		FileUtils.copyFile(screenshot, dest);
		output = "<pre><a class=\"screenshots\" href=" + dest.getAbsolutePath() + ">" + dest.getName()
				+ "</href></pre>";
		// Hooks.s.embed(Files.readAllBytes(dest.toPath()), "image/png");
		Hooks.s.embed(output.getBytes(), "text/html");
		try {
			BufferedImage im = ImageIO.read(dest);
			int width = im.getWidth();
			int height = im.getHeight();
			System.out.println(width);
			System.out.println(height);
			System.out.println(Units.toEMU(width));
			System.out.println(Units.toEMU(height));
			@SuppressWarnings("unused")
			String name = dest.getName();
			int format = XWPFDocument.PICTURE_TYPE_JPEG;
			Hooks.para.setAlignment(ParagraphAlignment.CENTER);
			Hooks.run.setText(caption);
			Hooks.run.addBreak();
			Hooks.run.addPicture(new FileInputStream(dest), format, "New", Units.toEMU(450), Units.toEMU(300));
			Hooks.run.addBreak();

		} catch (IOException e) {
		}
		System.out.println("returning " + dest.getAbsolutePath());
		return dest.getAbsolutePath();
	}

	public void reports(String status, boolean screenCaptureFlag) throws Exception {
		try {
			switch (status.trim().toLowerCase().replaceAll(" ", "")) {
			case "pass":
				if (screenCaptureFlag) {
					Hooks.test.log(LogStatus.PASS,
							Hooks.test.addScreenCapture(screenCapture(String.valueOf(System.currentTimeMillis()))),
							getDriver().getTitle() + System.currentTimeMillis());
				} else {
					Hooks.test.log(LogStatus.PASS, getDriver().getTitle() + System.currentTimeMillis());
				}
				break;
			case "info":
				if (screenCaptureFlag) {
					Hooks.test.log(LogStatus.INFO,
							Hooks.test.addScreenCapture(screenCapture(String.valueOf(System.currentTimeMillis()))),
							getDriver().getTitle() + System.currentTimeMillis());
				} else {
					Hooks.test.log(LogStatus.INFO, getDriver().getTitle() + System.currentTimeMillis());
				}
				break;
			case "fail":
				if (screenCaptureFlag) {
					Hooks.test.log(LogStatus.FAIL,
							Hooks.test.addScreenCapture(screenCapture(String.valueOf(System.currentTimeMillis()))),
							getDriver().getTitle() + System.currentTimeMillis());
				} else {
					Hooks.test.log(LogStatus.FAIL, getDriver().getTitle() + System.currentTimeMillis());
				}
				break;
			default:
				throw new Exception("Invalid Status of execution passed");
			}

		} catch (Exception e) {

		}
	}

	public void reports(String status, boolean screenCaptureFlag, String caption) throws Exception {
		try {
			switch (status.trim().toLowerCase().replaceAll(" ", "")) {
			case "pass":
				if (screenCaptureFlag) {
					Hooks.test.log(LogStatus.PASS, Hooks.test.addScreenCapture(screenCapture(caption.trim())),
							caption.trim());
				} else {
					Hooks.test.log(LogStatus.PASS, caption.trim());
				}
				break;
			case "info":
				if (screenCaptureFlag) {
					Hooks.test.log(LogStatus.INFO, Hooks.test.addScreenCapture(screenCapture(caption.trim())),
							caption.trim());
				} else {
					Hooks.test.log(LogStatus.INFO, caption.trim());
				}
				break;
			case "fail":
				if (screenCaptureFlag) {
					Hooks.test.log(LogStatus.FAIL, Hooks.test.addScreenCapture(screenCapture(caption.trim())),
							caption.trim());
				} else {
					Hooks.test.log(LogStatus.FAIL, caption.trim());
				}
				break;
			default:
				throw new Exception("Invalid Status of execution passed");
			}

		} catch (Exception e) {

		}
	}

	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "test.resources/Driver/chromedriver.exe");
//		System.setProperty("webdriver.chrome.verboseLogging", "true");
		WebDriver driver = drive;
		if (browserInvoked == false) {
//			DesiredCapabilities caps = DesiredCapabilities.chrome();
//			LoggingPreferences logPrefs = new LoggingPreferences();
//			logPrefs.enable(LogType.BROWSER, Level.ALL);
			ChromeOptions options = new ChromeOptions();
			// add the headless argument
			options.addArguments("headless");
//			options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
//			options.addArguments("verbose");
			driver = new ChromeDriver();
			// driver = new InternetExplorerDriver();
			// driver = new HtmlUnitDriver();
			drive = driver;
			System.out.println("Initializing Chrome");
			browserInvoked = true;
			driver.manage().window().maximize();
			return driver;
		}
		return driver;
	}

	/***
	 * author Shriram Srinivasan opens a new empty browser tab
	 * 
	 * @throws Exception
	 */
	public static void openNewTab() throws Exception {
		try {
			JavascriptExecutor exe = (JavascriptExecutor) getDriver();
			exe.executeScript("window.open('','_blank');");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error in opening new tab " + e.getMessage());
		}
	}

	/***
	 * author Shriram Srinivasan opens a new browser tab with specified URL
	 * 
	 * @param url
	 * @throws Exception
	 */
	public static void openNewTab(String url) throws Exception {
		try {
			JavascriptExecutor exe = (JavascriptExecutor) getDriver();
			String link = "window.open('" + url + "','_blank');";
			exe.executeScript(link);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error in opening new tab " + e.getMessage());
		}
	}

	/***
	 * author Shriram Srinivasan clicks the specified button
	 * 
	 * @param button
	 * @throws Exception
	 */
	public void buttonclick(WebElement button) throws Exception {
		try {
			JavascriptExecutor exe = (JavascriptExecutor) getDriver();
			exe.executeScript("arguements[0].click()", button);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while clicking the buttons");
		}
	}

	@SuppressWarnings({ "hiding" })
	public static <T> T getPage(Class<T> in) {
		return PageFactory.initElements(getDriver(), in);
	}

	public static void main(String[] args) {
		String path = "123";

		for (int i = 0; i < 15; i++) {
			System.out.print(" ");
		}
		System.out.print(path);
		// System.out.println(path);
		// System.out.println(FilenameUtils.separatorsToWindows(path));
	}

}
