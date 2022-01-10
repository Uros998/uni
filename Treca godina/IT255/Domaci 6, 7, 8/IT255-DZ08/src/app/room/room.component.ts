import { Component, OnInit, Input, HostBinding, Output, EventEmitter } from '@angular/core';
import { Room } from './room.model';

@Component({
  selector: 'app-room',
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.css']
})
export class RoomComponent implements OnInit {
  @HostBinding('attr.class') cssClass = 'col-sm-12 col-md-6 room';

  @Input() room: Room;
  @Output() delete = new EventEmitter<Room>();
  @Output() edit = new EventEmitter<Room>();
  constructor() { }

  ngOnInit(): void {
  }

  onDelete(): void {
    this.delete.emit(this.room);
  }

  onEdit(): void {
    this.edit.emit(this.room);
  }


}
