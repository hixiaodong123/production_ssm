package cn.lime.utils;

import java.util.HashMap;
import java.util.Map;

public class ControllerMapUtil {
    public static Map<String, Object> MapString(boolean b){
        Map<String, Object> map = new HashMap<>();
        if (b){
            map.put("data",null);
            map.put("msg","OK");
            map.put("status",200);
        }else{
            map.put("data",null);
            map.put("msg","errs");
            map.put("status",500);
        }
        return map;
    }
}
