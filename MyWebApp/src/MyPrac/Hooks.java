package MyPrac;

import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

//import org.apache.poi.hpsf.Section;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
//import org.jsoup.nodes.Document;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	static ExtentReports reports;
	static ExtentTest test;
	static XWPFDocument doc;
	static File f;
	static FileOutputStream fi;
	static FileOutputStream fi1;
	static XWPFParagraph para;
	static XWPFRun run;
	static Scenario s=null;

	@Before
	public static void beforeHooks(Scenario scenario) throws Exception {
		try {
			s=scenario;
			doc = new XWPFDocument();
			File dirfile1 = new File("report\\Word");
			if(!dirfile1.exists()) {
				dirfile1.mkdir();
			}
			f=new File("report\\Word\\"+ scenario.getName() +"_"+System.currentTimeMillis()+".docx");
			fi = new FileOutputStream(f);
			doc.write(fi);
			fi.close();
			para = doc.createParagraph();
			run = para.createRun();
			System.out.println("In Before Hooks");
			File dirfile = new File("reports\\htmlReports");
			if(!dirfile.exists()) {
				dirfile.mkdir();
			}
			File file = new File("report\\htmlReports\\" + scenario.getName() + ".html");
			int count = 0;
			String filename = null;
			while (file.exists()) {
				System.out.println(file.getParentFile().list());
				filename = file.getName();
				if (filename.replaceAll(scenario.getName(), "").replaceAll(".html", "").contains("(")) {
					count = Integer.valueOf(
							filename.replaceAll(scenario.getName(), "").replaceAll(".html", "").replaceAll("[()]", ""))
							+ 1;
				} else if (filename.replaceAll(scenario.getName(), "").replaceAll(".html", "").contains("")) {
					count = 1;
				}
				filename = scenario.getName().concat("(" + String.valueOf(count) + ")");
				// file.renameTo(new File("E:\\Reports\\" + filename + ".html"));
				file = new File("report\\htmlReports\\" + filename + ".html");
//				System.out.println(file.getAbsolutePath());

			}
			file = new File("report\\htmlReports\\" + scenario.getName() + ".html");
			file.renameTo(new File("report\\htmlReports\\" + filename + ".html"));
			reports = new ExtentReports("report\\htmlReports\\" + scenario.getName() + ".html");
			test = reports.startTest(scenario.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public static void afterHooks(Scenario scenario) throws IOException {
		System.out.println("In After Hooks");
		reports.endTest(test);
		reports.flush();
		fi1 = new FileOutputStream(f);
		try {
			doc.write(fi1);
			fi1.close();
			doc.close();
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtil.getDriver().close();
		CommonUtil.getDriver().quit();
		CommonUtil.browserInvoked = false;
//		s.embed(Files.readAllBytes(CommonUtil.runt.get("Img").get(0).toPath()), "image/png");
	}
}
