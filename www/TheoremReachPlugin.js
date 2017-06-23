var exec = require('cordova/exec');

exports.hello = function(arg0, success, error) {
    exec(success, error, "TheoremReachPlugin", "hello", [arg0]);
};

exports.initWithApiKeyAndUserIdAndActivityContext = function(arg0, success, error) {
    exec(success, error, "TheoremReachPlugin", "initWithApiKeyAndUserIdAndActivityContext", [arg0]);
};

exports.isSurveyAvailable = function(arg0, success, error) {
    exec(success, error, "TheoremReachPlugin", "isSurveyAvailable", [arg0]);
};

exports.showRewardCenter = function(arg0, success, error) {
    exec(success, error, "TheoremReachPlugin", "showRewardCenter", [arg0]);
};

exports.onResume = function(arg0, success, error) {
    exec(success, error, "TheoremReachPlugin", "onResume", [arg0]);
};

exports.onPause = function(arg0, success, error) {
    exec(success, error, "TheoremReachPlugin", "onPause", [arg0]);
};

exports.setTheoremReachRewardListener = function(arg0, success, error) {
    exec(success, error, "TheoremReachPlugin", "setTheoremReachRewardListener", [arg0]);
};

exports.onReward = function(arg0, success, error) {
    exec(success, error, "TheoremReachPlugin", "onReward", [arg0]);
};

exports.TheoremReachSurveyListener = function(arg0, success, error) {
    exec(success, error, "TheoremReachPlugin", "TheoremReachSurveyListener", [arg0]);
};

exports.onRewardCenterOpened = function(arg0, success, error) {
    exec(success, error, "TheoremReachPlugin", "onRewardCenterOpened", [arg0]);
};

exports.onRewardCenterClosed = function(arg0, success, error) {
    exec(success, error, "TheoremReachPlugin", "onRewardCenterClosed", [arg0]);
};