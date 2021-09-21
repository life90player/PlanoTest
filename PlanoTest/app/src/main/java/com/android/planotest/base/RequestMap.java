package com.android.planotest.base;

import java.util.HashMap;
import java.util.Map;

public class RequestMap {
    private HashMap<String, String> map = new HashMap<>();

    public RequestMap put(String id, String value){
        map.put(id, String.valueOf(value));
        return this;
    }

    //此处可以插入公共参数
    public Map<String, String> getMap(){
        return map;
    }

}
