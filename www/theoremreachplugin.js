var exec = require('cordova/exec');

var TheoremReachPlugin = function() {
    var onRewardCallback = function(quantity) {};
    var onRewardCenterOpenedCallback = function() {};
    var onRewardCenterClosedCallback = function() {};
    var theoremreachSurveyAvailableCallback = function(surveyAvailable) {};
}

// INIT THEOREMREACH //
TheoremReachPlugin.prototype.initWithApiKeyAndUserId = function(key, user) {
    exec(TheoremReachPlugin.onRewardCallback, function() {}, "TheoremReachPlugin", 'setRewardCallback', []);
    exec(TheoremReachPlugin.onRewardCenterOpenedCallback, function() {}, "TheoremReachPlugin", 'setRewardCenterOpenedCallback', []);
    exec(TheoremReachPlugin.onRewardCenterClosedCallback, function() {}, "TheoremReachPlugin", 'setRewardCenterClosedCallback', []);
    exec(TheoremReachPlugin.theoremreachSurveyAvailableCallback, function() {}, "TheoremReachPlugin", 'setRewardCenterClosedCallback', []);

    exec(function() {}, function() {}, "TheoremReachPlugin", 'initWithApiKeyAndUserId', [key, user]);
}

// SETTING THEOREMREACH DEBUG MODE //
TheoremReachPlugin.prototype.enableDebugMode = function(mode) {
    exec(function() {}, function() {}, "TheoremReachPlugin", 'enableDebugMode', [mode]);
}

// CHECK SURVEY AVAILABLE //
TheoremReachPlugin.prototype.isSurveyAvailable = function(success) {
    exec(success, function() {}, "TheoremReachPlugin", 'isSurveyAvailable', []);
}

// SHOW REWARD CENTER //
TheoremReachPlugin.prototype.showRewardCenter = function() {
    exec(function() {}, function() {}, "TheoremReachPlugin", 'showRewardCenter', []);
}

// REWARD CALLBACK //
TheoremReachPlugin.prototype.onReward = function(callback) {
    TheoremReachPlugin.onRewardCallback = callback;
    exec(TheoremReachPlugin.onRewardCallback, function() {}, "TheoremReachPlugin", 'setRewardCallback', []);
}

// REWARDCENTER OPENED CALLBACK //
TheoremReachPlugin.prototype.onRewardCenterOpened = function(callback) {
    TheoremReachPlugin.onRewardCenterOpenedCallback = callback;
    exec(TheoremReachPlugin.onRewardCenterOpenedCallback, function() {}, "TheoremReachPlugin", 'setRewardCenterOpenedCallback', []);
}

// REWARDCENTER CLOSED CALLBACK //
TheoremReachPlugin.prototype.onRewardCenterClosed = function(callback) {
    TheoremReachPlugin.onRewardCenterClosedCallback = callback;
    exec(TheoremReachPlugin.onRewardCenterClosedCallback, function() {}, "TheoremReachPlugin", 'setRewardCenterClosedCallback', []);
}

// THEOREMREACH AVAILABLE CALLBACK //
TheoremReachPlugin.prototype.theoremreachSurveyAvailable = function(callback) {
    TheoremReachPlugin.theoremreachSurveyAvailableCallback = callback;
    exec(TheoremReachPlugin.theoremreachSurveyAvailableCallback, function() {}, "TheoremReachPlugin", 'setTheoremreachSurveyAvailableCallback', []);
}

var theoremReachPlugin = new TheoremReachPlugin();
module.exports = theoremReachPlugin;