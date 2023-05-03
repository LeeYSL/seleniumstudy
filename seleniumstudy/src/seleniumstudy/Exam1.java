package seleniumstudy;

import javax.lang.model.element.Element;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



/*
 * jspStudy2의 로그인 창 띄우기
 * 
 * 
 * */

public class Exam1 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/setup/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/jspstudy2/member/loginForm");
		System.out.println(driver.getPageSource());
		WebElement element = null;
		element = driver.findElement(By.name("id"));
		String id = "admin";
		element.sendKeys(id);
		element = driver.findElement(By.name("pass"));
		String pass = "1234";
		element.sendKeys(pass);
//	       element = driver.findElement(By.cssSelector(".btn.btn-dark"));
//	       element.click();
		
		element = driver.findElement(By.name("f")); // form 태그 찾아서 바로 submit도 가능?
		element.submit(); // form submit
		driver.switchTo().alert().accept(); // alert 창 안 띄움
		Thread.sleep(3000);
		driver.get("http://localhost:8080/jspstudy2/member/list");
		// Jsoup으로 분석하기
		//driver.getPageSource() : 브라우저에서 제공되는 html 페이지
		Document doc = Jsoup.parse(driver.getPageSource());
		Elements div = doc.select("table"); //table 들 중에
		for (Element e : div) { // 하나의 테이블을 가져와서
			for (Element tr : e.select("tr")) { //테이블 및 tr가져와서
				Elements tds = tr.select("td"); //tr에 td를 가져오고
				if (tds.size() > 3) { //td가 3보다 큰 것 들은
					//tds.get(2) : 회원 이름의 값
					System.out.println(tds.get(2).html());

				}
			}
		}
		Thread.sleep(1000);
		driver.quit();
		driver.close();
	}

}
