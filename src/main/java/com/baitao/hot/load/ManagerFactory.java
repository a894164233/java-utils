package com.baitao.hot.load;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author baitao
 * @date 2018/9/25 14:06
 */
public class ManagerFactory {

	private static final Map<String, LoadInfo> loadTimeMap = new HashMap<>();
	public static final String CLASS_PATH = "E://1study//github_repository//java-utils//target//classes//";
	public static final String MY_MANAGER = "com.baitao.hot.load.MyManager";

	public static BaseManager getBaseManager(String className) {
		File loadFile = new File(CLASS_PATH + className.replace(".", "//") + ".class");
		System.out.println(loadFile.getName());
		long lastModified = loadFile.lastModified();
		System.out.println(lastModified);
		if (null == loadTimeMap.get(className)) {
			load(className, lastModified);
		} else if(loadTimeMap.get(className).getLongTime() != lastModified) {
			load(className, lastModified);
		}
		return loadTimeMap.get(className).getBaseManager();
	}

	private static void load(String className, long lastModified) {
		MyClassLoader myClassLoader = new MyClassLoader(CLASS_PATH);
		Class<?> loadClass = null;
		try {
			loadClass = myClassLoader.loadClass(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		BaseManager baseManager = newInstance(loadClass);
		LoadInfo loadInfo = new LoadInfo(myClassLoader, lastModified);
		loadInfo.setBaseManager(baseManager);
		loadTimeMap.put(className, loadInfo);
	}

	private static BaseManager newInstance(Class<?> loadClass) {
		try {
			return (BaseManager) loadClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}
}
