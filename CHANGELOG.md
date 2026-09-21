# Changes

Changes to version 0.0.5

## PageUtils

Utils to get a secure page and page size to use with pagination.

## AuditWrapper

Wrapper to save audit data.

## NotificationHandler

Interface to manage notifications.

## Pagination fragment

Pagination fragment to be reused.

Parameters:
    page: Page object
    defaultSize: The default size of every page
    baseUrl: The base url to go to next and previus page.

Pagination use the baseUrl and two params to navigate, `page` and `size`.

## Dependencies added
    - spring-boot-starter-thymeleaf
    - lombok
