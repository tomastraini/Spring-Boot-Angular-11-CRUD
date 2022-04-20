import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'clientesFilter'
})
export class ClientesFilterPipe implements PipeTransform {

  transform(li: any[], value: string): any {
   return value !== undefined && li !== undefined ? li.filter(val =>
      val.razon_social.indexOf(value) !== -1 ||

      val.telefono.indexOf(value) !== -1 ||

      val.localidad.indexOf(value) !== -1 ||

      val.razon_social.toLowerCase().indexOf(value.toLowerCase()) !== -1 ||

      val.telefono.toLowerCase().indexOf(value.toLowerCase()) !== -1 ||

      val.localidad.toLowerCase().indexOf(value.toLowerCase()) !== -1
      
    ) : li;
  }
}
