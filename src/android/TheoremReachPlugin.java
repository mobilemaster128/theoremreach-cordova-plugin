/********* TheoremReach.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>
#import <TheoremReachSDK/TheoremReach.h>

NSString *onRewardCallback;
NSString *onRewardCenterOpenedCallback;
NSString *onRewardCenterClosedCallback;
NSString *theoremreachSurveyAvailableCallback;

@interface TheoremReachPlugin : CDVPlugin <TheoremReachRewardDelegate, TheoremReachSurveyDelegate> {
  // Member variables go here.
}

- (void)initWithApiKeyAndUserId:(CDVInvokedUrlCommand*)command;
- (void)enableDebugMode:(CDVInvokedUrlCommand*)command;
- (void)isSurveyAvailable:(CDVInvokedUrlCommand*)command;
- (void)showRewardCenter:(CDVInvokedUrlCommand*)command;
- (void)setRewardCallback:(CDVInvokedUrlCommand*)command;
- (void)setRewardCenterOpenedCallback:(CDVInvokedUrlCommand*)command;
- (void)setRewardCenterClosedCallback:(CDVInvokedUrlCommand*)command;
- (void)setTheoremreachSurveyAvailableCallback:(CDVInvokedUrlCommand*)command;
@end

@implementation TheoremReachPlugin

- (void)initWithApiKeyAndUserId:(CDVInvokedUrlCommand*)command
{
    NSString* apiKey = [command.arguments objectAtIndex:0];
    NSString* userId = [command.arguments objectAtIndex:1];

    [self.commandDelegate runInBackground:^{
        [TheoremReach initWithApiKey:apiKey userId:userId];
        
        [[TheoremReach getInstance] setRewardListenerDelegate:self];
        [[TheoremReach getInstance] setSurveyListenerDelegate:self];
    }];
}

- (void)enableDebugMode:(CDVInvokedUrlCommand*)command
{
    BOOL debugMode = [command.arguments objectAtIndex:0];

    [[TheoremReach getInstance] enableDebugMode:debugMode];
}

- (void)isSurveyAvailable:(CDVInvokedUrlCommand*)command
{
    [self.commandDelegate runInBackground:^{
        CDVPluginResult* pluginResult = nil;
        BOOL result = [TheoremReach getInstance].isSurveyAvailable;
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsBool:result];
        [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    }];
}

- (void)showRewardCenter:(CDVInvokedUrlCommand*)command
{
    NSLog(@"TheoremReachPlugin RewardCenter Opening");
    [TheoremReach showRewardCenter];
}

- (void)setRewardCallback:(CDVInvokedUrlCommand*)command
{
    onRewardCallback = command.callbackId;
}

- (void)setRewardCenterOpenedCallback:(CDVInvokedUrlCommand*)command
{
    onRewardCenterOpenedCallback = command.callbackId;
}

- (void)setRewardCenterClosedCallback:(CDVInvokedUrlCommand*)command
{
    onRewardCenterClosedCallback = command.callbackId;
}

- (void)setTheoremreachSurveyAvailableCallback:(CDVInvokedUrlCommand*)command
{
    theoremreachSurveyAvailableCallback = command.callbackId;
}

- (void)onReward: (NSNumber* )quantity {
    // award user the content!
    NSLog(@"TheoremReachPlugin onReward: %@", quantity);
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsNSInteger:[quantity integerValue]];
    pluginResult.keepCallback = @1;
    [self.commandDelegate sendPluginResult:pluginResult callbackId:onRewardCallback];
}

- (void)onRewardCenterOpened {
    // reward center opened! Time to take surveys!
    NSLog(@"TheoremReachPlugin onRewardCenterOpened");
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
    pluginResult.keepCallback = @1;
    [self.commandDelegate sendPluginResult:pluginResult callbackId:onRewardCenterOpenedCallback];
}

- (void)onRewardCenterClosed {
    // reward center opened! Back to the app to use our coins!
    NSLog(@"TheoremReachPlugin onRewardCenterClosed");
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
    pluginResult.keepCallback = @1;
    [self.commandDelegate sendPluginResult:pluginResult callbackId:onRewardCenterClosedCallback];
}

-(void)theoremreachSurveyAvailable: (BOOL) surveyAvailable {
    // TheoremReachSurvayAvailable
    NSLog(@"TheoremReachSurvayAvailable: %d", surveyAvailable);
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsBool:surveyAvailable];
    pluginResult.keepCallback = @1;
    [self.commandDelegate sendPluginResult:pluginResult callbackId:theoremreachSurveyAvailableCallback];
}

@end
