import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterPipe'
})
export class FilterPipePipe implements PipeTransform {

  transform(items: any[], searchText: string): any[] {
    if (!items) { return[]; }
    if (!searchText) { return items; }
    return items.filter(item => {
      return item.price <= parseInt(searchText);
    });
  }

}
