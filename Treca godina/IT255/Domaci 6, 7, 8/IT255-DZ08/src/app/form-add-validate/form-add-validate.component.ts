import { ThrowStmt } from '@angular/compiler';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  Validators,
  FormControl,
  AbstractControl
} from '@angular/forms';
import { Room } from '../room/room.model';

function scoreValidator(control: FormControl): { [s: string]: boolean } {
  if (!(control.value >= 1 && control.value <= 10)) {
    return { invalidScore: true };
  }
}

function nameValidator(control: FormControl): { [s: string]: boolean } {
  const word: string = control.value;
  return word.charAt(0) === word.charAt(0).toUpperCase() ? null : { invalidName: true };
}

function urlValidator(control: FormControl): { [s: string]: boolean } {
  const pattern = new RegExp('^(https?:\\/\\/)?' + // protocol
    '((([a-z\\d]([a-z\\d-]*[a-z\\d])*)\\.?)+[a-z]{2,}|' + // domain name
    '((\\d{1,3}\\.){3}\\d{1,3}))' + // OR ip (v4) address
    '(\\:\\d+)?(\\/[-a-z\\d%_.~+]*)*' + // port and path
    '(\\?[;&a-z\\d%_.~+=-]*)?' + // query string
    '(\\#[-a-z\\d_]*)?$', 'i'); // fragment locator
  return pattern.test(control.value) ? null : { invalidUrl: true };
}


@Component({
  selector: 'app-form-add-validate',
  templateUrl: './form-add-validate.component.html',
  styleUrls: ['./form-add-validate.component.css']
})
export class FormAddValidateComponent implements OnInit {
  myForm: FormGroup;
  name: AbstractControl;
  price: AbstractControl;
  score: AbstractControl;
  description: AbstractControl;
  room: Room;
  @Output() add = new EventEmitter<Room>();

  constructor(fb: FormBuilder) {
    this.myForm = fb.group({
      name: ['', Validators.compose([
        Validators.required, nameValidator
      ])],
      price: ['', Validators.required],
      score: ['', Validators.compose([
        Validators.required, scoreValidator
      ])],
      description: ['', Validators.required]
    });
    this.name = this.myForm.controls.name;
    this.price = this.myForm.controls.price;
    this.score = this.myForm.controls.score;
    this.description = this.myForm.controls.description;

    this.name.valueChanges.subscribe((form: string) => {
      if (form.length < 6) {
        console.log('Uneta vrednost je: "' + form + '" i ona je kraca od 6 karaktera');
      }
    });

    this.description.valueChanges.subscribe((form: string) => {
      if (form.length < 6) {
        console.log('Uneta vrednost je: "' + form + '" i ona je kraca od 6 karaktera');
      }
    });
  }

  ngOnInit(): void {
  }

  onSubmit(form: any): void {
    if (this.myForm.valid) {
      this.room = new Room(form.name, form.description, form.price, form.score);
      this.add.emit(this.room);
    } else {
      alert('Neispravno popunjena forma');
    }
  }
}
