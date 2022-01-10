import {Component, Inject, OnInit} from '@angular/core';
import {Room} from '../room/room.model';
import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';


function scoreValidator(control: FormControl): { [s: string]: boolean } {
  if (!(control.value >= 1 && control.value <= 10)) {
    return {invalidScore: true};
  }
}

function nameValidator(control: FormControl): { [s: string]: boolean } {
  const word: string = control.value;
  return word.charAt(0) === word.charAt(0).toUpperCase() ? null : {invalidName: true};
}

function urlValidator(control: FormControl): { [s: string]: boolean } {
  const pattern = new RegExp('^(https?:\\/\\/)?' + // protocol
    '((([a-z\\d]([a-z\\d-]*[a-z\\d])*)\\.?)+[a-z]{2,}|' + // domain name
    '((\\d{1,3}\\.){3}\\d{1,3}))' + // OR ip (v4) address
    '(\\:\\d+)?(\\/[-a-z\\d%_.~+]*)*' + // port and path
    '(\\?[;&a-z\\d%_.~+=-]*)?' + // query string
    '(\\#[-a-z\\d_]*)?$', 'i'); // fragment locator
  return pattern.test(control.value) ? null : {invalidUrl: true};
}

@Component({
  selector: 'app-edit-room-dialog',
  templateUrl: './edit-room-dialog.component.html',
  styleUrls: ['./edit-room-dialog.component.css']
})
export class EditRoomDialogComponent {
  myForm: FormGroup;
  name: AbstractControl;
  price: AbstractControl;
  image: AbstractControl;
  score: AbstractControl;
  description: AbstractControl;
  room: Room;

  constructor(public dialogRef: MatDialogRef<EditRoomDialogComponent>, @Inject(MAT_DIALOG_DATA) private data, fb: FormBuilder) {
    this.room = data.room;
    this.myForm = fb.group({
      name: [this.room.name, Validators.compose([
        Validators.required, nameValidator
      ])],
      price: [this.room.price, Validators.required],

      score: [this.room.score, Validators.compose([
        Validators.required, scoreValidator
      ])],
      description: [this.room.description, Validators.required]
    });
    this.name = this.myForm.controls.name;
    this.price = this.myForm.controls.price;
    this.score = this.myForm.controls.score;
    this.description = this.myForm.controls.description;
  }

  editRoom(form: any): void {
    if (this.myForm.valid) {
      this.room.name = form.name;
      this.room.description = form.description;
      this.room.price = form.price;
      this.room.score = form.score;
      this.dialogRef.close(this.room);
    } else {
      alert('Nepravilno popunjena forma!');
    }
  }

}

