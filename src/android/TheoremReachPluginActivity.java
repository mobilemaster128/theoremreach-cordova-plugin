package cordova.plugin.theoremreach;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import theoremreach.com.theoremreach.TheoremReach;
import theoremreach.com.theoremreach.TheoremReachRewardListener;
import theoremreach.com.theoremreach.TheoremReachSurveyListener;

public class TheoremReachPluginActivity extends Activity implements TheoremReachRewardListener, TheoremReachSurveyListener {
    private static String TAG = "TheoremReachPlugin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        String apiKey = getIntent().getExtras().getString("key");
        String userId = getIntent().getExtras().getString("user");

        //initialize TheoremReach
        TheoremReach.initWithApiKeyAndUserIdAndActivityContext(apiKey, userId, this);

        //set reward and survey status listeners
        TheoremReach.getInstance().setTheoremReachRewardListener(this);
        TheoremReach.getInstance().setTheoremReachSurveyListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        TheoremReach.getInstance().onResume(this);
        if (TheoremReach.getInstance().isSurveyAvailable()) {
            TheoremReach.getInstance().showRewardCenter();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        TheoremReach.getInstance().onPause();
    }

    @Override
    public void onReward(int i) {
        Log.d(TAG, "onReward: " + i);
    }

    @Override
    public void onRewardCenterClosed() {
        Log.d(TAG, "onRewardCenterClosed");
    }

    @Override
    public void onRewardCenterOpened() {
        Log.d(TAG, "onRewardCenterOpened");
    }
}
