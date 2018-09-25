package com.baitao.hot.load;

/**
 * @author baitao
 * @date 2018/9/25 13:57
 */
public class ClassLoaderTest {
	public static void main(String[] args) {
		new Thread(new MsgHandler()).start();
	}
}
