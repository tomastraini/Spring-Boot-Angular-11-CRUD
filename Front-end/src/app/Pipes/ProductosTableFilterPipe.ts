import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'productosTableFilter'
})
export class ProductosTableFilterPipe implements PipeTransform {

  transform(li: any[], value: string): any {
   return value !== undefined && li !== undefined ? li.filter(val =>
      val.descripcion.indexOf(value) !== -1 ||

      val.proveedor.indexOf(value) !== -1 ||

      val.stock.toString().indexOf(value) !== -1 ||

      val.importe.toString().indexOf(value) !== -1 ||

      val.descripcion.toLowerCase().indexOf(value.toLowerCase()) !== -1 ||

      val.proveedor.toLowerCase().indexOf(value.toLowerCase()) !== -1 ||

      val.stock.toString().toLowerCase().indexOf(value.toLowerCase()) !== -1 ||

      val.importe.toString().toLowerCase().indexOf(value.toLowerCase()) !== -1
    ) : li;
  }
}
