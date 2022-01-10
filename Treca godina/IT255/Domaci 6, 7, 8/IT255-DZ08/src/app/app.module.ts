import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RoomComponent } from './room/room.component';
import { FilterPipePipe } from './helpers/filter-pipe.pipe';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RoomListComponent } from './room-list/room-list.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { EditRoomDialogComponent } from './edit-room-dialog/edit-room-dialog.component';
import { MatDialogModule } from '@angular/material/dialog';
import { FormAddValidateComponent } from './form-add-validate/form-add-validate.component';

@NgModule({
  declarations: [
    AppComponent,
    RoomComponent,
    FilterPipePipe,
    RoomListComponent,
    EditRoomDialogComponent,
    FormAddValidateComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    NoopAnimationsModule,
    MatDialogModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
