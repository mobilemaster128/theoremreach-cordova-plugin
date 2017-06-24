var exec = require('cordova/exec');

exports.hello = function(arg0, success, error) {
    exec(success, error, "TheoremReachPlugin", "hello", [arg0]);
};

exports.initWithApiKeyAndUserId = function(arg0, arg1) {
    exec(function() {}, function() {}, "TheoremReachPlugin", "initWithApiKeyAndUserId", [arg0, arg1]);
};

exports.isSurveyAvailable = function() {
    exec(function() {}, function() {}, "TheoremReachPlugin", "isSurveyAvailable", []);
};

exports.showRewardCenter = function() {
    exec(function() {}, function() {}, "TheoremReachPlugin", "showRewardCenter", []);
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