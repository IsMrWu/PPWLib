package com.mrwu.jsbridge.demo.handlers;

import android.content.Context;
import android.widget.Toast;

import com.mrwu.jsbridge.core.BridgeHandler;
import com.mrwu.jsbridge.core.BridgeLog;
import com.mrwu.jsbridge.core.CallBackFunction;

public class RequestBridgeHandler extends BridgeHandler {

    private String TAG = "RequestBridgeHandler";

    @Override
    public void handler(Context context,String data, CallBackFunction function) {

        BridgeLog.d(TAG,"data->"+data+",Thread is "+Thread.currentThread().getName());

        //a network request .....
        //callback
        Toast.makeText(context,"request data :"+data,Toast.LENGTH_SHORT).show();
        function.onCallBack("{\"status\":\"0\",\"msg\":\"请求成功\"}");

    }
}
