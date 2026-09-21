package com.thelastimperial.utils.entities;

import java.security.Principal;

import lombok.Builder;
import lombok.Data;
/**
 *
 * AuditWrapper Wrapper to save audit data.
 * @param <T>
*/
@Data
@Builder
public class AuditWrapper<T> {
    private T user;
    private Principal principal;
    private String comment;
    private String actionId;
}
