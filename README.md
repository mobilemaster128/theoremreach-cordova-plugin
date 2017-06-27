# theoremreach-cordova-plugin
Cordova Plugin for TheoremReach
#### Version 1.0.1 (06/27/2017)
- Tested on Android and iOS using Cordova cli 6.4.0, Cordova android 6.0.0 and Cordova ios 4.3.1
- Available sdk functions: initWithApiKeyAndUserId, isSurveyAvailable, showRewardCenter, onReward, onRewardCenterOpened and onRewardCenterClosed

## Get Your API Key
Sign-up for a new developer account and create a new app here and copy your API Key.

## Install Plugin
```Bash
cordova plugin add theoremreach

```
## Usage
### Initialize TheoremReach
Initialize the TheoremReach SDK with the initWithApiKeyAndUserId call.
```javascript
TheoremReachPlugin.initWithApiKeyAndUserId("YOUR_API_TOKEN", "YOUR_USER_ID");

```

### Reward Center
Next, in your activity, implement the logic to display the reward center. Call the showRewardCenter method when you are ready to the send the user into the reward center where they can complete surveys in exchange for your virtual currency. We automatically convert the amount of currency a user gets based on the conversion rate specified in your app.
```javascript
TheoremReachPlugin.isSurveyAvailable(function (isAvailable) {
  if (isAvailable) {
    console.log("available");
    TheoremReachPlugin.showRewardCenter();
  } else {
    console.log("unavailable");
  }
});

```

### Reward Callback
To ensure safety and privacy, we notify you of all awards via a server side callback. In the developer dashboard for your App add the server callback that we should call to notify you when a user has completed an offer. Note the user ID pass into the initialize call will be returned to you in the server side callback. More information about setting up the callback can be found in the developer dashboard.

The quantity value will automatically be converted to your virtual currency based on the exchange rate you specified in your app. Currency is always rounded in favor of the app user to improve happiness and engagement.
#### Client Side Award Callback
For security purposes we always recommend that developers utilize a server side callback, however we also provide APIs for implementing a client side award notification if you lack the server structure or a server altogether or want more real-time award notification. It's important to only award the user once if you use both server and client callbacks (though your users may not be opposed!).
```javascript
TheoremReachPlugin.onReward(function (quantity) {
  console.log('TheoremReach onReward:' + quantity);
});

```
#### Reward Center Events
You can optionally listen for the onRewardCenterOpened and onRewardCenterClosed events by implementing the TheoremReachSurveyListener interface.
```javascript
TheoremReachPlugin.onRewardCenterOpened(function () {
  console.log('TheoremReach onRewardCenterOpened in Cordova');
});

TheoremReachPlugin.onRewardCenterClosed(function () {
  console.log('TheoremReach onRewardCenterClosed in Cordova');
 });

```
## Declare Plugin Variable
in declarations.d.ts file
```javascript
declare var TheoremReachPlugin: any;

```

## Contact
Please send all questions, concerns, or bug reports to admin@theoremreach.com.
## FAQ
##### What do you do to protect privacy?
We take privacy very seriously. All data is encrypted before being sent over the network. We also use HTTPS to ensure the integrity and privacy of the exchanged data.

##### What kind of analytics do you provide?

Our dashboard will show metrics for sessions, impressions, revenue, and much more. We are constantly enhancing our analytics so we can better serve your needs.

##### What is your fill rate?

We have thousands of surveys and add hundreds more every day. Most users will have the opportunity to complete at least one survey on a daily basis.

##### I'm ready to go live! What are the next steps?

Let us know! We'd love to help ensure everything flows smoothly and help you achieve your monetisation goals!
