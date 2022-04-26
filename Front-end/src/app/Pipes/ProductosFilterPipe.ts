import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'productosFilter'
})
export class ProductosFilterPipe implements PipeTransform {

  transform(li: any[], value: string): any {
   return value !== undefined && li !== undefined ? li.filter(val =>
      val.producto.indexOf(value) !== -1 ||

      val.producto.toLowerCase().indexOf(value.toLowerCase()) !== -1
      
    ) : li;
  }
}
