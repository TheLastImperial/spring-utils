package com.thelastimperial.utils.services.ratelimits;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.thelastimperial.utils.services.RateLimitService;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.BandwidthBuilder;
import io.github.bucket4j.Bucket;

/**
 *
 * LocalRateLimitService RateLimitService implementation with local storage.
*/
public class LocalRateLimitService implements RateLimitService {
    private final Map<String, Bucket> cache = new ConcurrentHashMap<>();
    private final Bandwidth limit;

    public LocalRateLimitService() {
        limit = BandwidthBuilder.builder()
            .capacity(5)
            .refillGreedy(5, Duration.ofMinutes(1))
            .build();
    }

    public LocalRateLimitService(Bandwidth loginBandwidth) {
        this.limit = loginBandwidth;
    }

    @Override
    public Bucket resolve(String id) {
        return cache.computeIfAbsent(id, (inputId) -> Bucket
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
