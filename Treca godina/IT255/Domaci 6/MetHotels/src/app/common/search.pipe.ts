import { Pipe, PipeTransform } from '@angular/core';
import {Room} from "../rooms/add-room-dialog/add-room-dialog.component";

@Pipe({
  name: 'search'
})
export class SearchPipe implements PipeTransform {

  transform(rooms: Room[], searchNum: number): Room[] {
    if (!rooms) {
      return [];
    }
    if (!searchNum) {
      return rooms;
    }
    return rooms.filter(r => {
      return r.cena <= searchNum;
    })
  }

}
