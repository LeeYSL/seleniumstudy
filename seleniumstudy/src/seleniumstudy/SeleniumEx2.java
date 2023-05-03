package seleniumstudy;
/*
 * daum 사이트에서 사진 다운 받기
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumEx2 {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:/setup/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url =
	"https://search.daum.net/search?w=img&nil_search=btn&DA=NTB&enc=utf8&q=%EC%9E%A5%EB%AF%B8&vimg=68do3ne7hDC2dbTP3s"; // 장미 사진으로 이루어진 주소
		driver.get(url);
		Thread.sleep(1000);
		//findElements : 태그들이기 때문에 리턴 타입은 list
		//images : img 태그 목록
		List<WebElement> imges = driver.findElements
				(By.cssSelector("div.wrap_thumb a > img"));
		List<String> imgurl = new ArrayList<>(); //이미지의 링크들을 저장한다.
		for(WebElement img : imges) {
			//src 태그의 src 속성의 값
			String src = img.getAttribute("src");
			if(src.startsWith("http")) { //src가 http(절대경로)인 경우
			imgurl.add(src);
			System.out.println(src);
		}
		
	}
	File f = new File("img");
	if(!f.exists()) f.mkdirs(); //존재하지 않는다면 현재 폴더 밑에 이미지 폴더 생성
	
	for(int i=0; i<imgurl.size();i++) {
    //URL : 네트워크 클래스
	//imgurl.get : 이미지 절대 경로 저장
    //is : 네티워크상의 이미지 파일을 읽기 위한 입력 스트림
	InputStream is = 
			 new URL(imgurl.get(i)).openConnection().getInputStream(); //외부에 있는 데이터를 InputStream 으로 읽어온다.
	//fos : 이미지를 저장할 파일 이름 설정
	FileOutputStream fos = new FileOutputStream("img/"+i+".jsp");
	byte[] buf = new byte[8096]; //8K 짜리 버퍼 생성
	int len =0;
	while((len=is.read(buf)) != -1) { //is로 부터 8k씩 읽어서 파일에다 저장
		fos.write(buf,0,len);
	}
		is.close();
		fos.close();
		Thread.sleep(100);
	}
	driver.close();
}
}
