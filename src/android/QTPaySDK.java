package com.qfpay.qtpaysdk;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.qfpay.qpossdk.entity.PayOrderInfo;
import com.qfpay.qpossdk.pay.QfPayCallBack;
import com.qfpay.qpossdk.pay.QfPaySdk;

import android.app.Activity;

/**
 * This class echoes a string called from JavaScript.
 */
public class QTPaySDK extends CordovaPlugin {

    private CallbackContext callbackContext;
    private Activity activity = null;

//    @Override
//    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
//        super.initialize(cordova, webView);
//        // your init code here
//    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        this.callbackContext = callbackContext;
        this.activity = this.cordova.getActivity();
        boolean retValue = true;

        if (action.equals("orderPayByPos")) {
            this.orderPayByPos(args);
        } else {
            retValue = false;
        }

        return retValue;
    }

    QfPayCallBack payCallBack = new QfPayCallBack() {
        @Override
        public void onPayResultFail() {
            callbackContext.error("fail");
//            queryOrder();
        }

        @Override
        public void onPayResultSuccess() {
            callbackContext.success("success");
//            queryOrder();
        }

        @Override
        public void onPayResultCancel() {
            callbackContext.error("cancel");
//            queryOrder();
        }

        @Override
        public void onPayResultUnknow() {
            callbackContext.error("unknow");
//            queryOrder();
        }
    };

    private void orderPayByPos(JSONArray args) throws JSONException {
        JSONObject jObject = args.getJSONObject(0);

        PayOrderInfo orderInfo = new PayOrderInfo();
        orderInfo.createUserId = jObject.getString("createUserId");
        orderInfo.payOrderId = jObject.getString("payOrderId");
        orderInfo.qfToken = jObject.getString("qfToken");
        orderInfo.token = jObject.getString("token");
        orderInfo.platform = jObject.getString("platform");
        orderInfo.mobile = jObject.getString("mobile");

        QfPaySdk.getInstance().payOrder(this.activity, orderInfo, payCallBack);
    }
}
