package MyPrac;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.TestException;

import cucumber.api.DataTable;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class GoToURL extends CommonUtil {
	@FindBy(xpath = "//input[@type='text' and @title='Search']")
	private WebElement searchBox;
	@FindBy(xpath = "//input[@value='Google Search']")
	private WebElement search;

	public void gotourl(String url) throws Exception {
		try {
			getDriver().get(url);
			System.out.println("going to URL");
			Thread.sleep(5000);
			reports("pass", true, "Home Page");
			System.out.println(getDriver().getWindowHandle());
			// getDriver().navigate().refresh();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestException("Error while going to URL " + e.getMessage());
		}
	}
	
	public void gotourl(DataTable url) throws Exception {
		try {
			for(String u:url.asList(String.class)) {
				getDriver().get(u);
				reports("pass", true, "Home Page");
			}
			
			System.out.println("going to URL");
			Thread.sleep(5000);
//			reports("pass", true, "Home Page");
			System.out.println(getDriver().getWindowHandle());
			// getDriver().navigate().refresh();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestException("Error while going to URL " + e.getMessage());
		}
	}
	
	public void search(String searchInput) throws Exception{
		try {
			if (getDriver().getCurrentUrl().contains("google")) {
				// ITesseract instance = new Tesseract();
				// try {
				// String result =
				// getDriver().findElement(By.xpath("//img[@alt='Google']")).getAttribute("src");
				// URL u = new URL(result);
				// Image image = ImageIO.read(u);
				// String s = new OCR().recognizeCharacters((RenderedImage) image);
				// System.out.println("Text From Image : \n"+ s);
				// } catch (Exception e) {
				// System.err.println(e.getMessage());
				// }
				searchBox.sendKeys(searchInput);
				Actions a = new Actions(getDriver());
				a.sendKeys(Keys.ENTER).build().perform();
			}
			System.out.println(getDriver().getCurrentUrl());
//			List<WebElement> ll = getDriver().findElements(By.xpath("//span[@value='Aathirai']"));
//			System.out.println(ll.toString());
			if (getDriver().getCurrentUrl().contains("https://www.google.com")) {
				System.out.println("PASSED");
				reports("pass", true);
			} else {
				System.out.println("FAILED");
				reports("fail", true);
			}
		
		}
		catch(Exception e) {
			
		}
	}

//	public static void main(String[] args) throws Exception {
		// XWPFDocument doc = new XWPFDocument();
		// File f = new File("D:\\xwpf\\sample.docx");
		// FileOutputStream fi = new FileOutputStream(f);
		// try {
		// doc.write(fi);
		// fi.close();
		// } catch (IOException e) {
		// }
		// XWPFParagraph para = doc.createParagraph();
		// XWPFRun run = para.createRun();
		// File n = new
		// File("D:\\shrinath\\prac\\ipl-is-back-dream11-Logo-for-website-thumbnail.jpg");
//		try {
			// BufferedImage im = ImageIO.read(n);
			// int width = im.getWidth();
			// int height = im.getHeight();
			// System.out.println(width);
			// System.out.println(height);
			// System.out.println(Units.toEMU(width));
			// System.out.println(Units.toEMU(height));
			// @SuppressWarnings("unused")
			// String name = n.getName();
			// int format = XWPFDocument.PICTURE_TYPE_JPEG;
			// run.addPicture(new FileInputStream(n), format, "New", Units.toEMU(450),
			// Units.toEMU(300));
			// run.addBreak();
			// run.addPicture(new FileInputStream(n), format, "New", Units.toEMU(450),
			// Units.toEMU(300));
			// FileOutputStream fi1 = new FileOutputStream(f);
			// doc.write(fi1);
			// fi1.close();
			// doc.close();
			
//		} catch (Exception e) {
//		}
//	}
}
