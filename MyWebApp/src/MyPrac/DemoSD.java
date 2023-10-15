package MyPrac;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.utils.URIBuilder;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.springframework.web.util.UriBuilder;

import cucumber.api.DataTable;

//import org.openqa.selenium.remote.server.handler.GetPageSource;

import cucumber.api.java.en.Given;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

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
	
	@Given("^enter details \"([^\"]*)\"$")
	public void enterDetails(String input) {
		System.out.println("inside enter");
		HashMap<String, String> ipMap = new HashMap<String, String>();
//		Arrays.asList(input.split("#")).forEach(ip->ipMap.put(ip.split(":")[0],ip.split(":")[0]));
		Alert al = getDriver().switchTo().alert();
		al.sendKeys(ipMap.get("username"));
		al.sendKeys(ipMap.get("password"));
	}
	
	
	@Given("^go to aadhaar login$")
	public void goAadhaar() throws Exception{
		try {
			GoToURL gourl = getPage(GoToURL.class);
			gourl.gotourl("https://myaadhaar.uidai.gov.in/");
//		getDriver().get("https://myaadhaar.uidai.gov.in/");
			Thread.sleep(5000);
			getDriver().findElement(By.xpath("//div//button[contains(normalize-space(),'Login')]")).click();
			getDriver().get("https://myaadhaar.uidai.gov.in/");
			Thread.sleep(5000);
			WebElement capEle = getDriver().findElement(By.xpath("//img[contains(@src,'base')]"));
			File ss = capEle.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(ss, new File("test.resources/new.png"));
			ITesseract tesseract = new Tesseract();
			System.setProperty("TESSDATA_PREFIX", "/MyWebApp/tessdata");
			tesseract.setDatapath("/MyWebApp/tessdata");
			tesseract.setLanguage("eng");
//			tesseract.setDatapath("/MyWebApp/tessdata");
			String captchaText="";
			try {
			    captchaText = tesseract.doOCR(new File("/MyWebApp/test.resources/new.png"));
			    // Process the extracted CAPTCHA text as needed
			} catch (TesseractException e) {
			    e.printStackTrace();
			}
			System.out.println(captchaText);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				}
}
