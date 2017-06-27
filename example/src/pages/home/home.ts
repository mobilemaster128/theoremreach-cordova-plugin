import {Component} from '@angular/core';
import {NavController, Platform} from 'ionic-angular';

@Component({selector: 'page-home', templateUrl: 'home.html'})
export class HomePage {

  constructor(public navCtrl : NavController, public platform : Platform) {}

  ionViewDidLoad() {
    this
      .platform
      .ready()
      .then(() => {
        TheoremReachPlugin.onReward(function (quantity) {
            console.log('TheoremReach onReward:' + quantity);
          });

        TheoremReachPlugin.onRewardCenterOpened(function () {
          console.log('TheoremReach onRewardCenterOpened in Cordova');
        });

        TheoremReachPlugin.onRewardCenterClosed(function () {
          console.log('TheoremReach onRewardCenterClosed in Cordova');
        });
      });
  }

  ShowReward() {
    console.log("clicked");
    TheoremReachPlugin.isSurveyAvailable(function (result) {
      if (result) {
        console.log("available");
        TheoremReachPlugin.showRewardCenter();
      } else {
        console.log("unavailable");
      }
    });
  }
}
