package com.thelastimperial.utils.services;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
/**
 *
 * RateLimitService interface to request a rate limit.
*/
public interface RateLimitService {
    /**
     * Search the bucket with the id or create a new one.
     * @param id Bucket's id to search.
     * @return Bucket
    */
    public Bucket resolve(String id);
    /**
     * The default Bandwidth for the new buckets.
     * @return
    */
    public Bandwidth limit();
    /**
     * Default consume with default numTokens on 1
     * @param id Bucket's Id
     * @return Bucket
    */
    public default boolean consume(String id) {
        return resolve(id).tryConsume(1);
    };
}
