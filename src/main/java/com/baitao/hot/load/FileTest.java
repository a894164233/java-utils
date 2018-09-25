package com.baitao.hot.load;

import java.io.*;

/**
 * @author baitao
 * @date 2018/9/25 15:07
 */
public class FileTest {

	public static void main(String[] args) {
		String encoding = "UTF-8";
		File file = new File("E:\\1study\\github_repository\\java-utils\\src\\main\\java\\com\\baitao\\hot\\load\\test.txt");
		try(InputStreamReader reader = new InputStreamReader(new FileInputStream(file), encoding);
				BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
