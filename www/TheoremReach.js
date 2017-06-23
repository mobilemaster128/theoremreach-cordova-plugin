var exec = require('cordova/exec');

exports.hello = function(arg0, success, error) {
    exec(success, error, "TheoremReach", "hello", [arg0]);
};

exports.initWithApiKeyAndUserIdAndActivityContext = function(arg0, success, error) {
    exec(success, error, "TheoremReach", "initWithApiKeyAndUserIdAndActivityContext", [arg0]);
};

exports.isSurveyAvailable = function(arg0, success, error) {
    exec(success, error, "TheoremReach", "isSurveyAvailable", [arg0]);
};

exports.showRewardCenter = function(arg0, success, error) {
    exec(success, error, "TheoremReach", "showRewardCenter", [arg0]);
};

exports.onResume = function(arg0, success, error) {
    exec(success, error, "TheoremReach", "onResume", [arg0]);
};

exports.onPause = function(arg0, success, error) {
    exec(success, error, "TheoremReach", "onPause", [arg0]);
};

exports.setTheoremReachRewardListener = function(arg0, success, error) {
    exec(success, error, "TheoremReach", "setTheoremReachRewardListener", [arg0]);
};

exports.onReward = function(arg0, success, error) {
    exec(success, error, "TheoremReach", "onReward", [arg0]);
};

exports.TheoremReachSurveyListener = function(arg0, success, error) {
    exec(success, error, "TheoremReach", "TheoremReachSurveyListener", [arg0]);
};

exports.onRewardCenterOpened = function(arg0, success, error) {
    exec(success, error, "TheoremReach", "onRewardCenterOpened", [arg0]);
};

exports.onRewardCenterClosed = function(arg0, success, error) {
    exec(success, error, "TheoremReach", "onRewardCenterClosed", [arg0]);
};