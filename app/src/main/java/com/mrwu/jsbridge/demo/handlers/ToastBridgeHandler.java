package com.mrwu.jsbridge.demo.handlers;

import android.content.Context;
import android.widget.Toast;

import com.mrwu.jsbridge.core.BridgeHandler;
import com.mrwu.jsbridge.core.BridgeLog;
import com.mrwu.jsbridge.core.CallBackFunction;

public class ToastBridgeHandler extends BridgeHandler {

    private String TAG = "ToastBridgeHandler";

    @Override
    public void handler(Context context,String data, CallBackFunction function) {

        BridgeLog.d(TAG,"data->"+data+",Thread is "+Thread.currentThread().getName());

        Toast.makeText(context,"data:"+data,Toast.LENGTH_SHORT).show();

        function.onCallBack("{\"status\":\"0\",\"msg\":\"toast success\"}");

    }
}
