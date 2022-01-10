import { Component, HostBinding, Input, OnInit } from '@angular/core';
import { Room } from '../room/room.model';

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css']
})
export class RoomListComponent implements OnInit {
  @HostBinding('attr.class') cssClass = 'row';

  rooms: Room[];

  searchText: string;


  constructor() {
    this.rooms = [
      new Room('Ambasador', 'Set in Niš, a few steps from King Milan Square, Ambasador Hotel offers accommodation with a restaurant, free private parking, a fitness centre and a bar. With a shared lounge, the 5-star hotel has air-conditioned rooms with free WiFi. The accommodation features a 24-hour front desk, room service and currency exchange for guests.', 150,  9.5),
      new Room('Eter', 'At the hotel, every room has a desk, a flat-screen TV, a private bathroom, bed linen and towels. All rooms include a safety deposit box and certain rooms here will provide you with river views. The units will provide guests with a wardrobe and a kettle.', 40, 7.0)
    ];
  }

  ngOnInit(): void {
  }



}
