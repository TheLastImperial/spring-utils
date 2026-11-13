package com.thelastimperial.utils.services.ratelimits;

import java.time.Duration;

import com.thelastimperial.utils.services.RateLimitService;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.BandwidthBuilder;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.BucketConfiguration;
import io.github.bucket4j.distributed.proxy.ProxyManager;

/**
 *
 * RedisRateLimitService RateLimitService implementation with redis storage.
*/
public class RedisRateLimitService implements RateLimitService {
    private final ProxyManager<String> cache;
    private final Bandwidth limit;

    public RedisRateLimitService(ProxyManager<String> cache) {
        this.cache = cache;
        this.limit = BandwidthBuilder.builder()
            .capacity(5)
            .refillGreedy(5, Duration.ofMinutes(1))
            .build();
    }

    public RedisRateLimitService(
        ProxyManager<String> cache, Bandwidth loginBandwidth
    ) {
        this.cache = cache;
        this.limit = loginBandwidth;
    }

    @Override
    public Bucket resolve(String id) {
        return cache.builder().build(id, () -> BucketConfiguration
                .builder()
                .addLimit(limit())
                .build()
            );
    }

    @Override
    public Bandwidth limit() {
        return limit;
    }
}
