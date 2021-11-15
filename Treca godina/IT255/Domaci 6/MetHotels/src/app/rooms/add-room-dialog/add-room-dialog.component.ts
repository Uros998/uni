import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

export interface Room {
  id: number
  sprat: number,
  soba: number,
  cena: number,
  opis: string
}

@Component({
  selector: 'app-add-room-dialog',
  templateUrl: './add-room-dialog.component.html',
  styleUrls: ['./add-room-dialog.component.css']
})

export class AddRoomDialogComponent implements OnInit {

  roomForm = new FormGroup({
    sprat: new FormControl(null, Validators.required),
    soba: new FormControl(null, Validators.required),
    cena: new FormControl(null, Validators.required),
    opis: new FormControl(null, Validators.required)
  })
  constructor(public dialogRef: MatDialogRef<AddRoomDialogComponent>) {

  }

  ngOnInit(): void {
  }

  addRoom() {
    //provera validnosti jer su sva polja neophodna
    if(this.roomForm.valid) {
      this.dialogRef.close({
        sprat: this.roomForm.controls.sprat.value,
        soba: this.roomForm.controls.soba.value,
        cena: this.roomForm.controls.cena.value,
        opis: this.roomForm.controls.opis.value,
      })
    }
  }

}
