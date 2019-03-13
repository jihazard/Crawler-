package jobkorea;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainApp {

	private static String URL = "http://www.jobkorea.co.kr/Search/?";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String keyword = "jquery";
		String param = getParam(keyword, 4);
		System.out.println("가져온 유아엘 " + URL+param);
		
		//1도큐먼트를 가져온다.
		Document doc = Jsoup.connect(URL+param).get();
		//2목록을가져온다.
		//System.out.println("" + doc.toString());
		
		Elements elements = doc.select("#smGiList .list .detailList li");
		int i=0;
		//배열에서 정보를 가져온다.
		for (Element el : elements) {
			System.out.println(++i+" "+el.text());
			System.out.println("--------------------------");
		
		}
	}
	
	
	/**
	 * url 완성
	 * @param keyworkd
	 * @param page
	 * @return
	 */
	public static String getParam(String keyword, int page){
		String param = "stext=" + keyword +""+"&IsCoInfoSC=false" + "&IsRecruit=false" + "&ord=1" + "&Order=1" + "&page=" + page +"&pageSize=10" + "&pageType=HRP"; 
		
		return param;
	}

}
