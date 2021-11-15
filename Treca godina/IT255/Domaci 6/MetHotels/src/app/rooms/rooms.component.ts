import {Component, OnInit} from '@angular/core';
import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import {AddRoomDialogComponent, Room} from "./add-room-dialog/add-room-dialog.component";
import {EditRoomDialogComponent} from "./edit-room-dialog/edit-room-dialog.component";

@Component({
  selector: 'rooms',
  templateUrl: './rooms.component.html',
  styleUrls: ['./rooms.component.css']
})
export class RoomsComponent implements OnInit {
  search: number = 0;

  public roomsList = [
    {
      id: 1,
      sprat: 1,
      soba: 1,
      cena: 1600,
      opis: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    },
    {
      id: 2,
      sprat: 1,
      soba: 2,
      cena: 1000,
      opis: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    },
    {
      id: 3,
      sprat: 1,
      soba: 3,
      cena: 1800,
      opis: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    },
    {
      id: 4,
      sprat: 1,
      soba: 4,
      cena: 1200,
      opis: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    },
    {
      id: 5,
      sprat: 2,
      soba: 1,
      cena: 2600,
      opis: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    },
    {
      id: 6,
      sprat: 2,
      soba: 2,
      cena: 2000,
      opis: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    }
  ]

  constructor(private dialog: MatDialog) {
  }

  ngOnInit(): void {
  }

  openAddRoomDialog() {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    const dialogRef = this.dialog.open(AddRoomDialogComponent, dialogConfig);
    dialogRef.afterClosed().subscribe(room => {
      const roomId: number = this.roomsList.length + 1;
      const roomBody: Room = {
        id: roomId,
        sprat: room.sprat,
        soba: room.soba,
        cena: room.cena,
        opis: room.opis
      }
      this.roomsList.push(roomBody);
    })
  }

  shuffle() {
    const rooms = this.roomsList;
    for (let i = rooms.length - 1; i > 0; i--) {
      let j = Math.floor(Math.random() * (i + 1));
      let temp = rooms[i];
      rooms[i] = rooms[j];
      rooms[j] = temp;
    }
  }

  izmeniSobu(oldRoom: Room) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.data = oldRoom;
    const dialogRef = this.dialog.open(EditRoomDialogComponent, dialogConfig);
    dialogRef.afterClosed().subscribe(room => {
      const index = this.roomsList.findIndex((obj => obj.id === room.id))
      this.roomsList[index] = room;
    })

  }

  obrisiSobu(id: number) {
    this.roomsList = this.roomsList.filter(room => {
      return room.id !== id;
    })

  }

}
