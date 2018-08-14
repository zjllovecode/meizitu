package com.zjl.crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.zjl.util.FileTool;

/**
 * 爬虫，爬取
 * 
 * @author zjl
 * @date 2017-12-5
 * @version 1.0
 */
public class Spider {

	private String saveDir;

	/**
	 * 
	 * @param saveDir
	 *            保存图片的目录
	 */
	public Spider(String saveDir) {
		this.saveDir = saveDir;
	}

	public void run(int page) {
		String url = "http://www.meizitu.com/a/" + page +".html";
		try {
			Document document = Jsoup.connect(url)
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:57.0) Gecko/20100101 Firefox/57.0")
					.timeout(120000)
					.get();
			System.out.println("连接成功--->开始获第：" + page + "页");
			Element element = document.getElementById("picture");
			Elements elements = element.getElementsByTag("img");
			System.out.println("本页共有：" + elements.size() + "条数据");
			int pictureId = 0;
			for (Element el : elements) {
					String imgUrl = el.attr("src");
					System.out.println(imgUrl);
					String fileName = "p" + pictureId;
					FileTool.downloadByApacheCommonIO(imgUrl, this.saveDir, fileName);
					pictureId++;
					System.out.println("爬取第：" + pictureId + "条");
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
