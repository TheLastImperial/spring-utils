package com.thelastimperial.utils;
/**
 *
 * PageUtils to reusable pagination.
*/
public class PageUtils {
    /**
     * Calculate the page number
     * @param page the page number set by the user.
     * @return The page number that can be proccess by the pagination, start with 0.
    */
    public static int getPage(int page){
        if(page < 1)
            page = 1;
        else
            page = page - 1;
        return page;
    }
    /**
     * Calculate the page size number.
     * @param size the page size set by the user.
     * @return The page size number that can be proccess by the pagination, minimum 1.
    */
    public static int getPageSize(int size){
        if(size < 1)
            size = 1;
        return size;
    }
}
