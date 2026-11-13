# Changes

Changes to version 0.0.8

## Rate Limits

New interface `RateLimitService` created to implements Token Bucket algorithm.

There is two default implementations:
 - `LocalRateLimitService`: Save the bucket on local memory.
 - `RedisRateLimitService`: Save the bucket on redis for distributed systems.
