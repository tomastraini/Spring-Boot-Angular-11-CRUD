import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'provinciasFilter'
})
export class ProvinciasFilterPipe implements PipeTransform {

  transform(li: any[], value: string): any {
   return value !== undefined && li !== undefined ? li.filter(val =>
      val.id_provincia.toString().indexOf(value) !== -1 ||

      val.provincia.indexOf(value) !== -1 ||

      val.id_provincia.toString().toLowerCase().indexOf(value.toLowerCase()) !== -1 ||

      val.provincia.toLowerCase().indexOf(value.toLowerCase()) !== -1

    ) : li;
  }
}
