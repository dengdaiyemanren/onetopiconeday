package org.com.onetopic.cache;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.com.onetopic.cache.coherence.CoherenceImpl;

public class CacheHelper {

	private static CacheManager cacheManager;
	private static final Lock lock = new ReentrantLock();

	private CacheHelper() {
		
	};

	/**
	 * 单例
	 * 
	 * @return
	 */
	public static CacheManager getIntance() {
		if (null == cacheManager) {
			lock.lock();
			try {
				if (null == cacheManager) {

					ICache cache = new CoherenceImpl();
					cacheManager = new CacheManager(cache);
				}

			} finally {
				lock.unlock();
			}
		}

		return cacheManager;

	}

}
