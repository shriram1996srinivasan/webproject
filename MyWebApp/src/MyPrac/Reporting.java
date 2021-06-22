package MyPrac;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.plexus.util.DirectoryScanner;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {
public static void main(String[] args) {
	String[] jsonFiles = null;
	DirectoryScanner scaning = new DirectoryScanner();
	scaning.setIncludes(new String[] {"**/*.json"});
	File repath = new File("report/json");
	scaning.setBasedir(repath);
	try {
		scaning.scan();
	}catch(Exception e) {
		jsonFiles=null;
	}
	jsonFiles = scaning.getIncludedFiles();
	List<String> rep = new ArrayList<>();
	String rpath = repath.getAbsolutePath();
	if(jsonFiles==null) {
		rep=null;
	}
	for(int i=0;i<jsonFiles.length;i++) {
		String r = rpath+"/"+jsonFiles[i];
		rep.add(r);
	}
	Configuration conf = new Configuration(new File("report/BHtml"), "Automation");
	conf.addClassifications("Browser", "Chrome");
	ReportBuilder builder = new ReportBuilder(rep, conf);
	builder.generateReports();
}
}
