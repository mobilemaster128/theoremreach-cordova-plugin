package cordova.plugin.theoremreach;

import android.util.Log;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CordovaWebView;

import org.json.JSONArray;
import org.json.JSONException;

import theoremreach.com.theoremreach.TheoremReach;
import theoremreach.com.theoremreach.TheoremReachRewardListener;
import theoremreach.com.theoremreach.TheoremReachSurveyAvailableListener;
import theoremreach.com.theoremreach.TheoremReachSurveyListener;

/**
 * This class echoes a string called from JavaScript.
 */
public class TheoremReachPlugin extends CordovaPlugin implements TheoremReachRewardListener, TheoremReachSurveyListener, TheoremReachSurveyAvailableListener {
    private static final String TAG = "TheoremReachPlugin";
    private static CallbackContext onRewardCallback;
    private static CallbackContext onRewardCenterOpenedCallback;
    private static CallbackContext onRewardCenterClosedCallback;
    private static CallbackContext theoremreachSurveyAvailableCallback;

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        Log.d(TAG, "Initializing TheoremReachPlugin");
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if (action.equals("initWithApiKeyAndUserId")) {
            try {
                final String apiKey = args.getString(0);
                final String userId = args.getString(1);

                cordova.getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initTheoremReach(apiKey, userId);
                    }
                });

                return true;
            }
            catch (JSONException e) {
                Log.e(TAG, "execute: Got JSON Exception " + e.getMessage());
                return false;
            }
        } else if (action.equals("enableDebugMode")) {
            try {
                final boolean mode = args.getBoolean(0);
                enableDebugMode(mode);
                return true;
            }
            catch (JSONException e) {
                Log.e(TAG, "execute: Got JSON Exception " + e.getMessage());
                return false;
            }
        } else if (action.equals("isSurveyAvailable")) {
            isSurveyAvailable(callbackContext);
            return true;
        } else if (action.equals("showRewardCenter")) {
            showRewardCenter();
            return true;
        } else if (action.equals("setRewardCallback")) {
            setRewardCallback(callbackContext);
            return true;
        } else if (action.equals("setRewardCenterOpenedCallback")) {
            setRewardCenterOpenedCallback(callbackContext);
            return true;
        } else if (action.equals("setRewardCenterClosedCallback")) {
            setRewardCenterClosedCallback(callbackContext);
            return true;
        } else if (action.equals("setTheoremreachSurveyAvailableCallback")) {
            setTheoremreachSurveyAvailableCallback(callbackContext);
            return true;
        } else {
            return false;
        }
    }

    protected void initTheoremReach(String apiKey, String userId) {
        //initialize TheoremReach
        TheoremReach.initWithApiKeyAndUserIdAndActivityContext(apiKey, userId, cordova.getActivity());
        TheoremReach.getInstance().setTheoremReachRewardListener(this);
        TheoremReach.getInstance().setTheoremReachSurveyListener(this);
    }

    protected void enableDebugMode(boolean mode) {
        //setting TheoremReach Debug Mode
        TheoremReach.getInstance().enableDebugMode(mode);
    }

    protected void isSurveyAvailable(final CallbackContext callbackContext)
    {
        boolean result = TheoremReach.getInstance().isSurveyAvailable();
        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, result);
        callbackContext.sendPluginResult(pluginResult);
    }

    protected void showRewardCenter()
    {
        TheoremReach.getInstance().showRewardCenter();
    }

    protected void setRewardCallback(CallbackContext callbackContext)
    {
        onRewardCallback = callbackContext;
    }

    protected void setRewardCenterOpenedCallback(CallbackContext callbackContext)
    {
        onRewardCenterOpenedCallback = callbackContext;
    }

    protected void setRewardCenterClosedCallback(CallbackContext callbackContext)
    {
        onRewardCenterClosedCallback = callbackContext;
    }

    protected void setTheoremreachSurveyAvailableCallback(CallbackContext callbackContext)
    {
        theoremreachSurveyAvailableCallback = callbackContext;
    }

    // implement callback for award notification
    @Override
    public void onReward(int quantity) {
        Log.d(TAG, "onReward: " + quantity);

        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, quantity);
        pluginResult.setKeepCallback(true);
        onRewardCallback.sendPluginResult(pluginResult);
    }

    // reward center opened. time to start earning content!
    @Override
    public void onRewardCenterOpened() {
        Log.d(TAG, "onRewardCenterOpened");

        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
        pluginResult.setKeepCallback(true);
        onRewardCenterOpenedCallback.sendPluginResult(pluginResult);
    }

    // reward center closed. restart music/app.
    @Override
    public void onRewardCenterClosed() {
        Log.d(TAG, "onRewardCenterClosed");

        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
        pluginResult.setKeepCallback(true);
        onRewardCenterClosedCallback.sendPluginResult(pluginResult);
    }

    // reward center closed. restart music/app.
    @Override
    public void theoremreachSurveyAvailable(boolean surveyAvailable) {
        Log.d(TAG, "theoremreachSurveyAvailable: " + surveyAvailable);

        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, surveyAvailable);
        pluginResult.setKeepCallback(true);
        theoremreachSurveyAvailableCallback.sendPluginResult(pluginResult);
    }

    @Override
    public void onPause(boolean multitasking) {
        super.onPause(multitasking);
        Log.d(TAG, "onPause");
        TheoremReach.getInstance().onPause();
    }

    @Override
    public void onResume(boolean multitasking) {
        super.onResume(multitasking);
        Log.d(TAG, "onResume");
        TheoremReach.getInstance().onResume(cordova.getActivity());
    }

}
