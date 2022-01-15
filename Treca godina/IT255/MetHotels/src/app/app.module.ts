import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import {MatToolbarModule} from "@angular/material/toolbar";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatCardModule} from "@angular/material/card";
import {MatSelectModule} from "@angular/material/select";
import {MatOptionModule} from "@angular/material/core";
import {MatInputModule} from "@angular/material/input";
import {AddApartmentComponent} from "./apartment-crud/add-apartment/add-apartment.component";
import {SearchPipe} from "./common/search.pipe";
import {MatDialogModule} from "@angular/material/dialog";
import { EditApartmentComponent } from "./apartment-crud/edit-apartment/edit-apartment.component";
import {RoomService} from "./common/services/room.service";
import { DeleteApartmentComponent } from "./apartment-crud/delete-apartment/delete-apartment.component";
import { CheckoutApartmentComponent } from "./apartment-crud/checkout-apartment/checkout-apartment.component";
import {StoreModule} from "@ngrx/store";
import {apartmantReducer} from "./common/redux/apartment/apartmant-reducer";

@NgModule({
  declarations: [
    AppComponent,
    AddApartmentComponent,
    SearchPipe,
    EditApartmentComponent,
    DeleteApartmentComponent,
    CheckoutApartmentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatButtonModule,
    MatToolbarModule,
    FormsModule,
    MatCardModule,
    MatSelectModule,
    MatOptionModule,
    ReactiveFormsModule,
    MatInputModule,
    MatDialogModule,
    StoreModule.forRoot(
      {
        apartment: apartmantReducer
      }
    )
  ],
  providers: [RoomService],
  bootstrap: [AppComponent]
})
export class AppModule { }