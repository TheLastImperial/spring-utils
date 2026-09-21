package com.thelastimperial.utils.handlers;
/**
 *
 * NotificationHandler handle the notification that can be configured to dont send it.
 * @param <T> the data to be send.
*/
public interface NotificationHandler<T> {
    /**
     * Send notifications
     * @param request data to send notification.
    */
    public void send(T request);
    /**
     * Know if the notification is active.
     * @return if the notification is active
    */
    public boolean isActiveNotification();
    /**
     * Activate or desactivate notifications.
     * @param activeNotification set activation value
    */
    public void setActiveNotification(boolean activeNotification);
}
