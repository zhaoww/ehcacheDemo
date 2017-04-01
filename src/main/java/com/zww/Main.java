package com.zww;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class Main {

	public static void main(String[] args) {
		// ����cacheManager����Ĭ�ϴ�classpath�ж�ȡ���ʿ���ֱ�����޲εĹ��캯��
		CacheManager cacheManager = new CacheManager();
		// CacheManager cacheManager =
		// CacheManager.newInstance("src/ehcache.xml");

		// ����һ��cache,�����ļ�������
		Cache cache = cacheManager.getCache("cacheTest");

		// Put �ڵ㵽cache���� ��Map��
		cache.put(new Element("e1", "e1"));

		// ��ȡ�ڵ�
		Element ele = cache.get("e1");

		// ��ӡֵ
		System.out.println(ele.getObjectValue());

		// ����һ��cache
		cacheManager.addCache("cache2");
		Cache cache2 = cacheManager.getCache("cache2");
		cache2.put(new Element("e1", "e1"));
		cache2.put(new Element("e2", "e2"));
		System.out.println(cache2.get("e2").getObjectValue());

		// ɾ��cache
		cacheManager.removeCache("cache2");
		// System.out.println(cache2.get("e2").getObjectValue());

		// �ֶ��ر�cacheManager
		cacheManager.shutdown();

		// �˴������ᱨ��
		// cacheManager.addCache("cache1");
		// Cache cache3 = cacheManager.getCache("cache1");
		// cache3.put(new Element("e1", "e1"));
		// cache3.put(new Element("e2", "e2"));
		// System.out.println(cache3.get("e2").getObjectValue());

	}

}
