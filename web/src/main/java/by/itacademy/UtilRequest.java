package by.itacademy;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class UtilRequest {

    public static String getParam(HttpServletRequest req, String name, String pattern) throws ParseException {
        String value = req.getParameter(name);
        if (value.matches(pattern)) {
            return value;
        }
        throw new ParseException("incorrect value " + value, 0);
    }

    public static Integer getInt(HttpServletRequest req, String name) {
        Integer result;
        try {
            result = Integer.parseInt(req.getParameter(name));
        } catch (Exception e) {
            // log
            return null;
        }
        return result;
    }

    public static Long getLong(HttpServletRequest req, String name) {
        Long result;
        try {
            result = Long.parseLong(req.getParameter(name));
        } catch (Exception e) {
            // log
            return null;
        }
        return result;
    }

    public static Float getFloat(HttpServletRequest req, String name) {
        Float result;
        try {
            result = Float.parseFloat(req.getParameter(name));
        } catch (Exception e) {
            // log
            return null;
        }
        return result;
    }

    public static Double getDouble(HttpServletRequest req, String name) throws ParseException {
        return Double.parseDouble(req.getParameter(name));
    }

    public static boolean isPost(HttpServletRequest req) {
        return req
                .getMethod()
                .toUpperCase()
                .equals("POST");
    }

    public static boolean isGet(HttpServletRequest req) {
        return req
                .getMethod()
                .toUpperCase()
                .equals("GET");
    }
}
