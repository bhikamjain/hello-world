import { Component } from '@angular/core';
import Stomp from 'stompjs';
import SockJS from 'sockjs-client';
import $ from 'jquery';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private serverUrl = 'http://localhost:8888/socket';
  private title = 'Straight Through Processing';
  private stompClient;

  constructor() {
    this.initializeWebSocketConnection();
  }

  initializeWebSocketConnection() {
    console.log('initialize Socket');
    const ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(ws);
    const that = this;
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe('/trades', (trade) => {
        if (trade.body) {
          $('.trade').append('<div class=\'trade\'>' + trade.body + '</div>');
          console.log(trade.body);
        }
      });
    });
  }

  sendMessage(message) {
    console.log('trade ' + message);
    this.stompClient.send('/app/send/trade' , {}, message);
    $('#input').val('');
  }

}
