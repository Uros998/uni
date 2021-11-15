import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {AddRoomDialogComponent, Room} from "../add-room-dialog/add-room-dialog.component";

@Component({
  selector: 'app-edit-room-dialog',
  templateUrl: './edit-room-dialog.component.html',
  styleUrls: ['./edit-room-dialog.component.css']
})
export class EditRoomDialogComponent implements OnInit {

  roomForm = new FormGroup({
    sprat: new FormControl(null, Validators.required),
    soba: new FormControl(null, Validators.required),
    cena: new FormControl(null, Validators.required),
    opis: new FormControl(null, Validators.required)
  })

  constructor(public dialogRef: MatDialogRef<AddRoomDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: Room) {
  }

  ngOnInit(): void {
    this.roomForm.get("sprat")?.setValue(this.data.sprat);
    this.roomForm.get("soba")?.setValue(this.data.soba);
    this.roomForm.get("cena")?.setValue(this.data.cena);
    this.roomForm.get("opis")?.setValue(this.data.opis);
  }

  editRoom() {
    //provera validnosti jer su sva polja neophodna
    if (this.roomForm.valid) {
      this.dialogRef.close({
        id: this.data.id,
        sprat: this.roomForm.controls.sprat.value,
        soba: this.roomForm.controls.soba.value,
        cena: this.roomForm.controls.cena.value,
        opis: this.roomForm.controls.opis.value,
      })
    }
  }

}
