package com.simuwang.aachart.tools;

import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * function:JSON序列化和反序列化帮助类.
 *
 */
public class JsonUtil {
  private static final String TAG = "JsonUtil";

  /**
   * 解析Json字符串为JavaBean对象
   */
  public static <T> T parseObject(String text, TypeReference<T> type) {
    T t = null;
    try {
      t = JSON.parseObject(text, type);
    } catch (Exception e) {
      Log.i(TAG, e.getMessage());
    }
    return t;
  }

  /**
   * 解析Json字符串为JavaBean对象
   */
  public static <T> T parseObject(String text, Class<T> clazz) {
    T t = null;
    try {
      t = JSON.parseObject(text, clazz);
    } catch (Exception e) {
      Log.i(TAG, e.getMessage());
    }
    return t;
  }

  public static <T> T parseType(String text, Type clazz) {
    T t = null;
    try {
      t = JSON.parseObject(text, clazz, new Feature[0]);
    } catch (Exception e) {
      Log.i(TAG, e.getMessage());
    }
    return t;
  }

  /**
   * 解析Json字符串为JavaBean对象
   */
  public static <T> List<T> parseArray(String text, Class<T> clazz) {
    try {
      return JSON.parseArray(text, clazz);
    } catch (Exception e) {
      Log.i(TAG, e.getMessage());
    } catch (Error e) {
      Log.i(TAG, e.getMessage());
    }
    return null;
  }

  /**
   * 将JavaBean对象转换成json字符串
   */
  public static String toJSONString(Object javaObject) {
    String result = null;
    try {
      result = JSON.toJSONString(javaObject);
    } catch (Exception e) {
      Log.i(TAG, e.getMessage());
    } catch (Error e) {
      Log.i(TAG, e.getMessage());
    }
    return result;
  }

  /** 将一个JSONObject对象转换为一个HashMap */
  public static Map<String, String> jsonToMap(JSONObject json) {
    Map<String, String> params = new HashMap<>();
    try {
      if (json != null) {
        Iterator<?> keys = json.keys();
        while (keys.hasNext()) {
          String key = (String) keys.next();
          params.put(key, json.getString(key));
        }
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return params;
  }

  /** 将一个JSONObject对象转换为一个HashMap */
  public static Map<String, String> jsonToMap(String jsonStr) {
    JSONObject json = null;
    try {
      json = new JSONObject(jsonStr);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return jsonToMap(json);
  }
}
