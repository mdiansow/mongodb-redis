package fr.istic.redis;

import redis.clients.jedis.Jedis;

public class TestRedis {

	public static void main(String[] args) {

		/*
		 * Exemple 1
		 */
		Jedis jedis = new Jedis("localhost");
		jedis.set("foo", "bar");
		String value = jedis.get("foo");

		System.out.println("EXEMPLE 1 : \t" + value);
		// done...

		/*
		 * Exemple 2
		 */
		System.err.println("\nEXEMPLE 2\n");
		Jedis jedis2 = new Jedis("localhost");
		System.out.println("\nEXEMPLE 2 : \t" + jedis2.get("counter"));
		jedis.incr("counter");
		System.out.println("EXEMPLE 2 : \t" + jedis2.get("counter"));

		// done..

		/*
		 * Exemple 3
		 */

		System.err.println("\nEXEMPLE 3\n");

		String cacheKey = "cachekey";
		Jedis jedis3 = new Jedis("localhost");
		// adding a new key
		jedis3.set(cacheKey, "cached value");
		// setting the TTL in seconds
		jedis3.expire(cacheKey, 15);
		// Getting the remaining ttl
		System.out.println("TTL:" + jedis3.ttl(cacheKey));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("TTL:" + jedis3.ttl(cacheKey));
		// Getting the cache value
		System.out.println("Cached Value:" + jedis3.get(cacheKey));

		// Wait for the TTL finishs
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// trying to get the expired key
		System.out.println("Expired Key:" + jedis3.get(cacheKey));

		// done...

		/*
		 * Exemple 4
		 */
		System.err.println("\nEXEMPLE 4\n");
		cacheKey = "languages";
		Jedis jedis4 = new Jedis("localhost");
		// Adding a set as value

		jedis4.sadd(cacheKey, "Java");
		jedis4.sadd(cacheKey, "C#");
		jedis4.sadd(cacheKey, "Python");// SADD

		// Getting all values in the set: SMEMBERS
		System.out.println("Languages: " + jedis4.smembers(cacheKey));
		// Adding new values
		jedis4.sadd(cacheKey, "Java");
		jedis4.sadd(cacheKey, "Ruby");
		// Getting the values... it doesn't allow duplicates
		System.out.println("Languages: " + jedis4.smembers(cacheKey));

	}

}
