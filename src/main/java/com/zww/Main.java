package com.zww;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class Main {

	public static void main(String[] args) {
		// 创建cacheManager对象，默认从classpath中读取，故可以直接用无参的构造函数
		CacheManager cacheManager = new CacheManager();
		// CacheManager cacheManager =
		// CacheManager.newInstance("src/ehcache.xml");

		// 创建一个cache,配置文件中已有
		Cache cache = cacheManager.getCache("cacheTest");

		// Put 节点到cache里面 （Map）
		cache.put(new Element("e1", "e1"));

		// 获取节点
		Element ele = cache.get("e1");

		// 打印值
		System.out.println(ele.getObjectValue());

		// 创建一个cache
		cacheManager.addCache("cache2");
		Cache cache2 = cacheManager.getCache("cache2");
		cache2.put(new Element("e1", "e1"));
		cache2.put(new Element("e2", "e2"));
		System.out.println(cache2.get("e2").getObjectValue());

		// 删除cache
		cacheManager.removeCache("cache2");
		// System.out.println(cache2.get("e2").getObjectValue());

		// 手动关闭cacheManager
		cacheManager.shutdown();

		// 此处创建会报错
		// cacheManager.addCache("cache1");
		// Cache cache3 = cacheManager.getCache("cache1");
		// cache3.put(new Element("e1", "e1"));
		// cache3.put(new Element("e2", "e2"));
		// System.out.println(cache3.get("e2").getObjectValue());

	}

}
