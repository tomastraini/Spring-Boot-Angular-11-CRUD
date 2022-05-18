import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'enviosFilter'
})
export class EnviosFilterPipe implements PipeTransform {
  transform(li: any[], value: string): any {
   return value !== undefined && li !== undefined ? li.filter(val =>
      val.cliente.toString().indexOf(value) !== -1 ||

      val.telefono.toString().indexOf(value) !== -1 ||

      val.localidad.toString().indexOf(value) !== -1 ||

      val.direccion.toString().indexOf(value) !== -1 ||

      val.costo.toString().indexOf(value) !== -1 ||

      val.fechaFormatted.toString().indexOf(value) !== -1 ||

      val.cliente.toLowerCase().indexOf(value.toLowerCase()) !== -1 ||

      val.telefono.toString().toLowerCase().indexOf(value.toLowerCase()) !== -1 ||

      val.localidad.toString().toLowerCase().indexOf(value.toLowerCase()) !== -1 ||

      val.direccion.toString().toLowerCase().indexOf(value.toLowerCase()) !== -1 ||

      val.costo.toString().toString().toLowerCase().indexOf(value.toLowerCase()) !== -1 ||

      val.fechaFormatted.toString().toLowerCase().indexOf(value.toLowerCase()) !== -1
    ) : li;
  }
}
