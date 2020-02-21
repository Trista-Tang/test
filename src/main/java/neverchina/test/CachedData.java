package neverchina.test;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CachedData {
	Object data;
	volatile boolean cacheValid;
	final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

	void processCachedData() {
		// 读锁
		rwl.readLock().lock();
		// 验证是否缓存
		if (!cacheValid) {
			// 释放锁
			rwl.readLock().unlock();
			// 写锁
			rwl.writeLock().lock();
			try {
				if (!cacheValid) {
					generateData();
					cacheValid = true;
				}
				// 上读锁
				rwl.readLock().lock();
			} finally {
				// 解除写锁
				rwl.writeLock().unlock();
			}
		}
		try {
			consumeData(data);
		} finally {
			rwl.readLock().unlock();// 8. 解除读锁
		}
	}

	/**
	 * 消费数据
	 * 
	 * @param data
	 */
	private void consumeData(Object data) {
		// TODO Auto-generated method stub
		System.out.println("消费数据");

	}

	/**
	 * 设置数据
	 * 
	 * @param data
	 */
	private Object generateData() {
		// TODO Auto-generated method stub
		System.out.println("设置数据");
		return "设置数据";

	}
}
