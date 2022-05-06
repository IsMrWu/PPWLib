package com.mrwu.jsbridge.demo.handlers;

import android.content.Context;
import android.widget.Toast;

import com.mrwu.jsbridge.core.BridgeHandler;
import com.mrwu.jsbridge.core.CallBackFunction;

public class PhotoBridgeHandler extends BridgeHandler {
    @Override
    public void handler(Context context,String data, CallBackFunction function) {

        Toast.makeText(context,"data:"+data,Toast.LENGTH_SHORT).show();

        function.onCallBack("{\"status\":\"0\"}");

    }
}
