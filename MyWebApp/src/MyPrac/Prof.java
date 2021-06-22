package MyPrac;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
public class Prof extends CommonUtil{
	

@Test(priority=-1)
public void print1() {
	Actions a = new Actions(getDriver());
	a.moveToElement(getDriver().findElement(By.xpath(""))).pause(1000).build().perform();
	System.out.println("in print 1");
}

@Test(priority=1)
public void qbc() {
	System.out.println("in abc");
}
}
