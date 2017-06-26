package cordova.plugin.theoremreach;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult.Status;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import theoremreach.com.theoremreach.TheoremReach;
import theoremreach.com.theoremreach.TheoremReachRewardListener;
import theoremreach.com.theoremreach.TheoremReachSurveyListener;

/**
 * This class echoes a string called from JavaScript.
 */
public class TheoremReachPlugin extends CordovaPlugin implements TheoremReachRewardListener, TheoremReachSurveyListener {
    private static final String TAG = "TheoremReachPlugin";

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        Log.d(TAG, "Initializing TheoremReachPlugin");
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if (action.equals("initWithApiKeyAndUserId")) {
            try {
                String apiKey = args.getString(0);
                String userId = args.getString(1);

                // initialize TheoremReach
                TheoremReach.initWithApiKeyAndUserIdAndActivityContext(apiKey, userId, cordova.getActivity());
                TheoremReach.getInstance().onResume(cordova.getActivity());

                //set reward and survey status listeners
                TheoremReach.getInstance().setTheoremReachRewardListener(this);
                TheoremReach.getInstance().setTheoremReachSurveyListener(this);
                return true;
            }
            catch (JSONException e) {
                Log.e(TAG, "execute: Got JSON Exception " + e.getMessage());
                return false;
            }
        } else if (action.equals("isSurveyAvailable")) {
            return isSurveyAvailable(callbackContext);
        } else if (action.equals("showRewardCenter")) {
            return showRewardCenter();
        } else if (action.equals("onReward")) {
            return onReward(callbackContext);
        } else if (action.equals("onRewardCenterOpened")) {
            return onRewardCenterOpened(callbackContext);
        } else if (action.equals("onRewardCenterClosed")) {
            return onRewardCenterClosed(callbackContext);
        } else {
            return false;
        }
    }

    protected boolean isSurveyAvailable(CallbackContext callbackContext)
	{
        boolean result = TheoremReach.getInstance().isSurveyAvailable();
		if (result) {
            callbackContext.success("");
        } else {
            callbackContext.error("");
        }
        
		return true;
	}

    protected boolean showRewardCenter()
	{
        TheoremReach.getInstance().showRewardCenter();

		return true;
	}

    protected boolean onReward(CallbackContext callbackContext)
	{
		return true;
	}

    protected boolean onRewardCenterOpened(CallbackContext callbackContext)
	{
		return true;
	}

    protected boolean onRewardCenterClosed(CallbackContext callbackContext)
	{
		return true;
	}

    // implement callback for award notification
    @Override
    public void onReward(int quantity) {
        Log.d(TAG, "onReward: " + quantity);
    }
    
    // reward center opened. time to start earning content!
    @Override
    public void onRewardCenterOpened() {
        Log.d(TAG, "onRewardCenterOpened");
    }

    // reward center closed. restart music/app.
    @Override
    public void onRewardCenterClosed() {
        Log.d(TAG, "onRewardCenterClosed");
    }

    @Override
    public void onPause(boolean multitasking) {
        super.onPause(multitasking);
        Log.d(TAG, "onPause");
        //TheoremReach.getInstance().onPause();
    }

    @Override
    public void onResume(boolean multitasking) {
        super.onResume(multitasking);
        Log.d(TAG, "onResume");
        //TheoremReach.getInstance().onResume(cordova.getActivity());
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
        //TheoremReach.getInstance().onResume(cordova.getActivity());
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
        //TheoremReach.getInstance().onPause();
    }
}
