package com.baitao.hot.load;

/**
 * @author baitao
 * @date 2018/9/25 13:45
 */
public class LoadInfo {
	private MyClassLoader myClassLoader;
	private long longTime;
	private BaseManager baseManager;

	public LoadInfo(MyClassLoader myClassLoader, long longTime) {
		this.myClassLoader = myClassLoader;
		this.longTime = longTime;
	}

	public BaseManager getBaseManager() {
		return baseManager;
	}

	public void setBaseManager(BaseManager baseManager) {
		this.baseManager = baseManager;
	}

	public MyClassLoader getMyClassLoader() {
		return myClassLoader;
	}

	public void setMyClassLoader(MyClassLoader myClassLoader) {
		this.myClassLoader = myClassLoader;
	}

	public long getLongTime() {
		return longTime;
	}

	public void setLongTime(long longTime) {
		this.longTime = longTime;
	}
}
