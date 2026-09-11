package com.thelastimperial.utils.services;
/**
 *
 * AuditService interface to save audit data. When someone updates something that must be tracked.
 * @param <T> Generic type used to save auditable data.
*/
public interface AuditService<T> {
    /**
     * Save the audit data related with T.
     * @param t an object used has reference to save the auditable data.
    */
    public void save(T t);
}
