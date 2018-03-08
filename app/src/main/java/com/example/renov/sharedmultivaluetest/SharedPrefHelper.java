package com.example.renov.sharedmultivaluetest;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

/**
 * Created by renov on 2018-03-08.
 */

public class SharedPrefHelper {
    private static SharedPrefHelper instance;

    public static final String PREFERENCE_NAME = "PUBLIC_ENEMY_PREF";
    public static final String ACCESS_TOKEN = "ACCESS_TOKEN";
    public static final String USER_STATUS = "USER_STATUS";
    public static final String USER_ID = "USER_ID";
    public static final String POINT = "POINT";
    //	출석일자 체크 2018-02-05 김정원
    public static final String LOGGED_DAY_COUNT = "LOGGED_DAY_COUNT";
    public static final String GENDER = "GENDER";
    public static final String NOTICE_ID = "NOTICE_ID";
    public static final String STORY_UPDATE_TIME = "STORY_UPDATE_TIME";
    public static final String LAST_LOGIN_DATE = "LAST_LOGIN_DATE";
    public static final String NOTICE_CHECK_USER_ID = "CHECK_NOTICE_ID";

    public SharedPreferences prefs;

    protected SharedPrefHelper() {
    }

    public static SharedPrefHelper getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPrefHelper();
            instance.prefs = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        }

        return instance;
    }

    public void setNoticeCheckUserId(String UserId){
        String SaveUserId = prefs.getString(SharedPrefHelper.NOTICE_CHECK_USER_ID,null);

        ArrayList<String> UserList;
        if(SaveUserId == null | "".equals(SaveUserId)){
            UserList = new ArrayList<>();
            UserList.add(UserId);
        } else {
            UserList = stringToList(SaveUserId);
            UserList.add(UserId);
        }

        SharedPreferences.Editor edit = prefs.edit();
        edit.putString(SharedPrefHelper.NOTICE_CHECK_USER_ID, UserList.toString());
        edit.commit();
    }

    public String getNoticeCheckUserId(){
        return prefs.getString(SharedPrefHelper.NOTICE_CHECK_USER_ID,null);
    }
    
    public boolean isCheckedNotice(String UserID){
        String SaveUserIdListString = prefs.getString(SharedPrefHelper.NOTICE_CHECK_USER_ID, null);

        if(SaveUserIdListString == null | "".equals(SaveUserIdListString)){
            return false;
        }

        ArrayList<String> SaveUserList = stringToList(SaveUserIdListString);

        for (String SaveUserId : SaveUserList){
            if(SaveUserId.equals(UserID))
                return true;
        }

        return false;
    }

    public static ArrayList<String> stringToList(final String input) {
        String[] elements = input.substring(1, input.length() - 1).split(", ");
        ArrayList<String> result = new ArrayList<String>(elements.length);
        for (String item : elements) {
            result.add(item);
        }
        return result;
    }

    public boolean getSharedPreferences(String key, boolean defaultVal) {
        return prefs.getBoolean(key, defaultVal);
    }

    public String getSharedPreferences(String key, String defaultVal) {
        return prefs.getString(key, defaultVal);
    }

    public long getSharedPreferences(String key, long defaultVal) {
        return prefs.getLong(key, defaultVal);
    }

    public int getSharedPreferences(String key, int defaultVal) {
        return prefs.getInt(key, defaultVal);
    }

    public float getSharedPreferences(String key, float defaultVal) {
        return prefs.getFloat(key, defaultVal);
    }

    public void setSharedPreferences(String key, boolean val) {
        SharedPreferences.Editor edit = prefs.edit();
        edit.putBoolean(key, val);
        edit.commit();
    }

    public void setSharedPreferences(String key, int val) {
        SharedPreferences.Editor edit = prefs.edit();
        edit.putInt(key, val);
        edit.commit();
    }

    public void setSharedPreferences(String key, String val) {
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString(key, val);
        edit.commit();
    }

    public void setSharedPreferences(String key, long val) {
        SharedPreferences.Editor edit = prefs.edit();
        edit.putLong(key, val);
        edit.commit();
    }

    public void setSharedPreferences(String key, float val) {
        SharedPreferences.Editor edit = prefs.edit();
        edit.putFloat(key, val);
        edit.commit();
    }

    public void removeSharedPreferences(String key) {
        SharedPreferences.Editor edit = prefs.edit();
        edit.remove(key);
        edit.commit();
    }

    public void removeAllSharedPreferences() {
        removeSharedPreferences(ACCESS_TOKEN);
        removeSharedPreferences(USER_STATUS);
        removeSharedPreferences(USER_ID);
        removeSharedPreferences(POINT);
        removeSharedPreferences(LOGGED_DAY_COUNT);
    }


}