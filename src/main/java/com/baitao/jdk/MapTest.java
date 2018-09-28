package com.baitao.jdk;

import sun.misc.LRUCache;

import java.util.*;

/**
 * @author baitao
 * @date 2018/9/25 15:43
 */
public class MapTest {

	//集合的类型
	public static void main1(String[] args) {
		Map<String, String> hashMap = new HashMap<>();
		HashSet<String> hashSet = new HashSet<>();
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
		Hashtable<String, String> hashtable = new Hashtable<>();


	}
	//HashMap 的 hash method
	public static void main2(String[] args) {
		String key = "abcd";
		int h = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
		System.out.println(h);

//		key = "1";
		int a = key.hashCode();
		int b = a >>> 16;
		int c = a ^ b;
		int idx = (1 << 4 - 1) & c;
	}
	//LinkedHashMap 的 插入顺序，访问顺序
	public static void main3(String[] args) {
		Map<String, String> linkedHashMap = new LinkedHashMap<>(32, .75F, true);
		linkedHashMap.put("a1", "test1");
		linkedHashMap.put("a2", "test1");
		linkedHashMap.put("a3", "test1");
		linkedHashMap.put("a4", "test1");
		linkedHashMap.put("a5", "test1");
		linkedHashMap.get("a1");
		linkedHashMap.forEach((key, value) -> {
			System.out.println(key);
		});
		Set<Map.Entry<String, String>> set = linkedHashMap.entrySet();
		set.forEach(entry -> System.out.println(entry.getKey()));
		Iterator<Map.Entry<String, String>> iterable = linkedHashMap.entrySet().iterator();
		while (iterable.hasNext()) {
			Map.Entry entry = iterable.next();
			System.out.println(entry.getKey());
		}
	}
	//& % 速度的比较
	public static void mai4(String[] args) {



		List<String> charAZ = new ArrayList<>();
		for (char a = 'a'; a <= 'z'; a++) {
			charAZ.add(String.valueOf(a));
		}
		charAZ.forEach(System.out::print);

		int[] arr1 = new int[16];
		long start = System.currentTimeMillis();
		charAZ.forEach(s -> {
			int h;
			h = (h = s.hashCode()) ^ (h >>> 16);
			int test = (1 << 4 - 1) & h;
			arr1[test]++;
		});
		System.out.println(System.currentTimeMillis()-start);

		int[] arr2 = new int[16];
		start = System.currentTimeMillis();
		charAZ.forEach(s -> {
			int h;
			h = (h = s.hashCode()) ^ (h >>> 16);
			int test = (1 << 4 - 1)%h;
			arr2[test]++;
		});
		System.out.println(System.currentTimeMillis()-start);

//		int[] arr1 = new int[16];
//		long start = System.currentTimeMillis();
//		for (int i = 0; i < 9_999_999; i++) {
//			int test = (1 << 4 - 1) & (1 + i);
//			arr1[test]++;
//		}
//		System.out.println(System.currentTimeMillis()-start);
//
//		int[] arr2 = new int[16];
//		start = System.currentTimeMillis();
//		for (int i = 0; i < 9_999_999; i++) {
//			int test = (1 << 4 - 1)%(1 + i);
//			arr2[test]++;
//		}
//		System.out.println(System.currentTimeMillis()-start);

		Arrays.stream(arr1).forEach(value -> {
			System.out.print(value + ", ");
		});
		System.out.println();
		Arrays.stream(arr2).forEach(value -> {
			System.out.print(value + ", ");
		});
	}
	//最大值 >>> 和 >> 的运算， hashMap MAXIMUM_CAPACITY = 1 <<< 30的原因是，再扩大2倍就整型溢出了，1<<31=-2147483648;
	public static void main(String[] args) {
		System.out.println(51 << 30);
		System.out.println(1 << 31);
		System.out.println("-------");
		int test = Integer.MIN_VALUE;
		System.out.println(test);
		System.out.println(test >>> 1 ); //相当于，绝对值，再除2。无符号右移，需要补0，0代表正数
		System.out.println(test >> 1 ); //相当于除2
	}
	//LRUCache
	public static void main6(String[] args) {
//		System.arraycopy();
		float a = 1.01f;
	}

}
