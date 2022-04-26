import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'historialFilter'
})
export class HistorialFilterPipe implements PipeTransform {

  transform(li: any[], value: string): any {
   return value !== undefined && li !== undefined ? li.filter(val =>
      val.cliente.indexOf(value) !== -1 ||

      val.forma_pago.indexOf(value) !== -1 ||

      val.fecha_final.indexOf(value) !== -1 ||

      val.cliente.toLowerCase().indexOf(value.toLowerCase()) !== -1 ||

      val.forma_pago.toLowerCase().indexOf(value.toLowerCase()) !== -1 ||

      val.fecha_final.toLowerCase().indexOf(value.toLowerCase()) !== -1
      
    ) : li;
  }
}
