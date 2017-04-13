package com.zv.geochat.service;

import android.content.Context;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.TimerTask;

/**
 * Created by SAJ on 4/12/2017.
 */

public class ChatServiceHelper extends TimerTask {

    Context context;
    private int currentSessionTime;

    ChatServiceHelper(Context context)
    {
        this.context=context;
    }

    @Override
    public void run() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        Integer userMaxSessionTimeValue = (Integer.parseInt(prefs.getString("key_chat_session_timer", "1"))) * 60;

        currentSessionTime++;

        if(currentSessionTime>userMaxSessionTimeValue)
        {
            ChatService chatService = new ChatService();

            this.cancel();

        }
        Log.v("TIMER value:", "" + currentSessionTime);
    }
}
