package com.baitao.hot.load;

import java.io.*;
import java.util.Objects;

/**
 * @author baitao
 * @date 2018/9/25 13:42
 */
public class MyClassLoader extends ClassLoader {

	private String classpath;

	public MyClassLoader(String classpath) {
		super(ClassLoader.getSystemClassLoader());
		this.classpath = classpath;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] data = this.loadClassData(name);
		return this.defineClass(name, data, 0, Objects.requireNonNull(data).length);
	}

	private byte[] loadClassData(String name) {
		name = name.replace(".", "//");
		File file = new File(classpath + name + ".class");
		try (FileInputStream fileInputStream = new FileInputStream(file);
		     ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream()) {
			int b = 0;
			while (-1 != (b = fileInputStream.read())) {
				byteArrayInputStream.write(b);
			}
//			fileInputStream
			return byteArrayInputStream.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
