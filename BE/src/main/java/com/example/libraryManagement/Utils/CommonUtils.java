package com.example.libraryManagement.Utils;

import org.springframework.web.multipart.MultipartFile;

import java.time.Year;
import java.util.Date;

public class CommonUtils {
    public static boolean validateBetweenNotAnyNull(Object from, Object to) {
        if (from == null || to == null) {
            return true;
        }
        return false;
    }
    public static boolean validateYearBetween(Year from, Year to) {
        if (validateBetweenNotAnyNull(from, to))
            return false;
        return !from.isAfter(to);
    }
    public static  boolean validateDateBetween(Date from, Date to){
        if(validateBetweenNotAnyNull(from, to)){
            return false;
        }
        return !from.after(to);
    }
    public static boolean validateIntegerBetween(Integer from, Integer to) {
        if (validateBetweenNotAnyNull(from, to)) {
            return false;
        }
        return from < to;
    }
    public static String getFileName(MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        assert originalFileName != null;
        return originalFileName.substring(0, originalFileName.lastIndexOf('.'));
    }

    public static String getFileExtension(MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        assert originalFileName != null;
        return originalFileName.substring(originalFileName.lastIndexOf('.') + 1);
    }

}
