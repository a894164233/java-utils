package com.baitao.hot.load;

/**
 * @author baitao
 * @date 2018/9/25 14:33
 */
public class MsgHandler implements Runnable {

	@Override
	public void run() {
		while (true) {
			BaseManager baseManager = ManagerFactory.getBaseManager(ManagerFactory.MY_MANAGER);
			baseManager.logic();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
