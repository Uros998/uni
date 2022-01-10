import {Component, NgModule} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {EditRoomDialogComponent} from './edit-room-dialog/edit-room-dialog.component';
import {Room} from './room/room.model';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  rooms: Room[];
  searchText: string;

  constructor(private dialog: MatDialog) {
    this.rooms = [
      new Room('Hotel plaza', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.', 60, 4.5),
      new Room('Ambasador', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.', 150, 9.5),
      new Room('Sole', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.', 120, 7)
    ];
    this.searchText = '';
  }


  randomize() {
    if (this.searchText !== '') {
      alert(`Can't use randomize with search bar`);
      return;
    }
    let currentIndex = this.rooms.length;
    let randomIndex;
    let temp;
    while (currentIndex !== 0) {
      randomIndex = Math.floor(Math.random() * currentIndex);
      currentIndex -= 1;

      temp = this.rooms[currentIndex];
      this.rooms[currentIndex] = this.rooms[randomIndex];
      this.rooms[randomIndex] = temp;
    }
  }

  onDelete(room: Room): void {
    const index = this.rooms.indexOf(room);
    if (index > -1) {
      this.rooms.splice(index, 1);
    }
  }

  onEdit(room: Room): void {
    const dialogRef = this.dialog.open(EditRoomDialogComponent, {
      data: {
        room
      }
    });
    dialogRef.afterClosed().subscribe(room => {
      console.log(room);
    });
  }

  addRoom(room: Room) {
    this.rooms.push(room);
  }
}
