var exec = require('cordova/exec');

exports.initWithApiKeyAndUserIdAndActivityContext = function(arg0, success, error) {
    exec(success, error, "TheoremReach", "initWithApiKeyAndUserIdAndActivityContext", [arg0]);
};