var exec = require('cordova/exec');

var TheoremReachPlugin = function() {
    var onRewardCallback = function(quantity) {};
    var onRewardCenterOpenedCallback = function() {};
    var onRewardCenterClosedCallback = function() {};
}

// INIT THEOREMREACH //
TheoremReachPlugin.prototype.initWithApiKeyAndUserId = function(key, user) {
    exec(TheoremReachPlugin.onRewardCallback, function() {}, "TheoremReachPlugin", 'setRewardCallback', []);
    exec(TheoremReachPlugin.onRewardCenterOpenedCallback, function() {}, "TheoremReachPlugin", 'setRewardCenterOpenedCallback', []);
    exec(TheoremReachPlugin.onRewardCenterClosedCallback, function() {}, "TheoremReachPlugin", 'setRewardCenterClosedCallback', []);

    exec(function() {}, function() {}, "TheoremReachPlugin", 'initWithApiKeyAndUserId', [key, user]);
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

var theoremReachPlugin = new TheoremReachPlugin();
module.exports = theoremReachPlugin;