package seleniumstudy;

import java.awt.event.ContainerListener;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumEx1 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty //시스템 환경 설정에 크롬 드라이버 파일 설정
		        ("webdriver.chrome.driver","D:/setup/chromedriver_win32/chromedriver.exe");
		         WebDriver driver = new ChromeDriver(); 
		         driver.get("http://www.naver.com"); // url 로드 (네이버 화면이 뜬다.) 
		         System.out.println(driver.getPageSource());
		         WebElement element = null;
		         element = driver.findElement
		        		 (By.cssSelector("#account.sc_login a.link_login")); //cssSelector로 찾는다. 
		                                                                     //id가 #account 이고 class 속성이 sc_login인  a 태그의 link_login라는 태그를 찾아라 
		         element.click();
		         //로그인 하기
		         /* findElement(By.함수) : 한개의 태그 찾기 
		         /* findElements(By.함수) : 여러개의 태그 찾기(list로 나온다) 
		          * 
		          * By.함수 : 태그 찾는 방식 설정
		          * By.name() : name 속성으로 태그 찾기
		          * By.id() : id 속성으로 태그 찾기
		          * By.cssSelector() : css에서 사용하는 선택자 방식으로 태그 찾기
		          * #account.sc_login : id = "account" 이고
		          *                      class ="sc_login" 한개의 태그 선택
		          *                      
		          *  a.link_login : class="link_ligin 인 a 태그 선택
		          *  
		          *  #account.sc_login a.link_login : 공백이 들어가면 하위 태그가 된다.
		          *                           id 속성이 account인 태그 의 하위 태그 중
		          *                           class= "link_login"인 a 태그 선택 
		          *                           
		          *                           
		          *   By.xpath : xml 에서 태그 선택 하는 방식, @ 속성을 의미함
		          *        // : 어디서든 찾겠다. 위치 따로 선택 안함
		          *        /  : root 노드 의미.문서노드 
		          *        
		          *  @id='log.login' : @는 속성 펴시 
		          *                      id ="log.login: 인 태그
		          *                      
		          *  By.linkText(문자열) : 태그의 text 값으로 태그 찾기                   
		          *  By.partialLinkText(문자열) : 태그의 text 값이 포함 된 태그 찾기                   
		          *  
		          * */
		         Scanner scan = new Scanner(System.in);
		         element = driver.findElement(By.name("id"));
		         System.out.println("네이버 아이디를 입력하세요");
		         String id = scan.nextLine();
		         //sendKeys(값) : 찾아 놓은 태그에 값 입력
		         element.sendKeys(id);
		         element = driver.findElement(By.name("pw"));
		         System.out.println("네이버 비밀번호를 입력하세요");
		         String pw = scan.nextLine();
		         element.sendKeys(pw);
		         element = driver.findElement(By.xpath("//*[@id='log.login']"));
		         element.click();
		         Thread.sleep(1000);
		       
	}

}
