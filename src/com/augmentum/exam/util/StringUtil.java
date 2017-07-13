package com.augmentum.exam.util;
import com.augmentum.exam.Constants;

public class StringUtil {

    public static boolean isEmpty(String name) {
        return (name == null || name.equals(Constants.BLANK)) ? true : false;
    }

    //Prevent null pointer error
    public static String doWithNull(Object obj) {
        if (obj == null) {
            return Constants.BLANK;
        } else {
            String returnValue = obj.toString();
            if (returnValue.equalsIgnoreCase(Constants.NULL)) {
                return Constants.BLANK;
            } else {
                return returnValue.trim();
            }
        }
    }

    // Splitting Strings
    public static String[] split(String strSource, String strDiv) {
        int arynum = 0, intIdx = 0, intIdex = 0;
        int div_length = strDiv.length();
        if (strSource.compareTo(Constants.BLANK) != 0) {
            if (strSource.indexOf(strDiv) != -1) {
                intIdx = strSource.indexOf(strDiv);
                for (int intCount = 1; ; intCount++) {
                    if (strSource.indexOf(strDiv, intIdx + div_length) != -1) {
                        intIdx = strSource.indexOf(strDiv, intIdx + div_length);
                        arynum = intCount;
                    } else {
                        arynum += 2;
                        break;
                    }
                }
            } else {
                arynum = 1;
            }
        } else {
            arynum = 0;
        }
        intIdx = 0;
        intIdex = 0;
        String[] returnStr = new String[arynum];

        if (strSource.compareTo(Constants.BLANK) != 0) {
            if (strSource.indexOf(strDiv) != -1) {
                intIdx = strSource.indexOf(strDiv);
                returnStr[0] = strSource.substring(0, intIdx);
                for (int intCount = 1; ; intCount++) {
                    if (strSource.indexOf(strDiv, intIdx + div_length) != -1) {
                        intIdex = strSource.indexOf(strDiv, intIdx + div_length);
                        returnStr[intCount] = strSource.substring(intIdx + div_length, intIdex);
                        intIdx = strSource.indexOf(strDiv, intIdx + div_length);;
                    } else {
                        returnStr[intCount] = strSource.substring(intIdx + div_length, strSource.length());
                        break;
                    }
                }
            } else {
                returnStr[0] = strSource.substring(0, strSource.length());
                return returnStr;
            }
        } else {
            return returnStr;
        }
        return returnStr;
    }

    private static String replace(String str, String strSub, String strRpl) {
        String[] temp = split(str, strSub);
        String returnStr = Constants.BLANK;
        if (temp.length != 0) {
            returnStr = temp[0];
            for (int i =0; i<temp.length - 1; i++) {
                returnStr = doWithNull(returnStr + strRpl + temp[i + 1]);
            }
        }
        return doWithNull(returnStr);
    }

    //Conversion escape character
    public static String htmlEncode(String txt) {
        if (txt != null) {
            txt = replace(txt, "&", "&amp;");
            txt = replace(txt, "&amp;amp;", "&amp;");
            txt = replace(txt, "&amp;quot;", "&quot;");
            txt = replace(txt, "\"", "&quot");
            txt = replace(txt, "&amp;lt;", "&lt;");
            txt = replace(txt, "<", "&lt;");
            txt = replace(txt, "&amp;gt;", "&gt;");
            txt = replace(txt, ">", "&gt;");
            txt = replace(txt, "&amp;nbsp;", "&nbsp;");
        }
        if (isEmpty(txt)) {
            txt = Constants.BLANK;
        }
        return txt;
    }
}

