import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'localidadesFilter'
})
export class LocalidadesFilterPipe implements PipeTransform {

  transform(li: any[], value: string): any {
   return value !== undefined && li !== undefined ? li.filter(val =>

      val.provincia.indexOf(value) !== -1 ||

      val.localidad.indexOf(value) !== -1 ||

      val.cp.toString().indexOf(value) !== -1 ||

      val.provincia.toLowerCase().indexOf(value.toLowerCase()) !== -1 ||

      val.localidad.toLowerCase().indexOf(value.toLowerCase()) !== -1 ||
      
      val.cp.toString().toLowerCase().indexOf(value.toLowerCase()) !== -1 

    ) : li;
  }
}
