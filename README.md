# theoremreach-cordova-plugin
Cordova Plugin for TheoremReach
#### Version 0.0.3 (06/27/2017)
- Tested on Android and iOS using Cordova cli 6.4.0, Cordova android 6.0.0 and Cordova ios 4.3.1
- Available sdk functions: initWithApiKeyAndUserId, isSurveyAvailable, showRewardCenter, onReward, onRewardCenterOpened and onRewardCenterClosed

## Get Your API Key
Sign-up for a new developer account and create a new app here and copy your API Key.

## Install Plugin
```Bash
cordova plugin add TheoremReach

```
## Usage
### Initialize TheoremReach

```javascript
TheoremReachPlugin.initWithApiKeyAndUserId("YOUR_API_TOKEN", "YOUR_USER_ID");

```

### Reward Center
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
#### Client Side Award Callback
```javascript
TheoremReachPlugin.onReward(function (quantity) {
  console.log('TheoremReach onReward:' + quantity);
});

```
#### Reward Center Events
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
