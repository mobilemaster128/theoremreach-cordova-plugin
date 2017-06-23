package com.plugin.theoremreach;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import theoremreach.com.theoremreach.TheoremReach;
import theoremreach.com.theoremreach.TheoremReachRewardListener;
import theoremreach.com.theoremreach.TheoremReachSurveyListener;

/**
 * This class echoes a string called from JavaScript.
 */
public class TheoremReachPlugin extends CordovaPlugin {
    private static final String TAG = "TheoremReachPlugin";

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        Log.d(TAG, "Initializing TheoremReachPlugin");
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("initWithApiKeyAndUserIdAndActivityContext")) {
            String apiKey = data.getString(0);
            String userId = data.getString(1);
            TheoremReach.initWithApiKeyAndUserIdAndActivityContext(apiKey, userId, callbackContext);
            //TheoremReach.initWithApiKeyAndUserIdAndActivityContext(apiKey, userId, this.cordova.getActivity());
            return true;
        } else if (action.equals("isSurveyAvailable")) {
            return TheoremReach.getInstance().isSurveyAvailable();
        } else if (action.equals("showRewardCenter")) {
            TheoremReach.getInstance().showRewardCenter();
            return true;
        } else if (action.equals("onResume")) {
            return true;
        } else if (action.equals("onPause")) {
            return true;
        } else if (action.equals("setTheoremReachRewardListener")) {
            return true;
        } else if (action.equals("onReward")) {
            return true;
        } else if (action.equals("TheoremReachSurveyListener")) {
            return true;
        } else if (action.equals("onRewardCenterOpened")) {
            return true;
        } else if (action.equals("onRewardCenterClosed")) {
            return true;
        } else if (action.equals("hello")) {
            int message = args.getString(0);
            this.hello(message, callbackContext);
            return true;
        }
        return false;
    }
    
    private void hello(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

}
