import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'proveedoresFilter'
})
export class ProveedoresFilterPipe implements PipeTransform {

  transform(li: any[], value: string): any {
   return value !== undefined && li !== undefined ? li.filter(val =>
      val.razon_social_proveedor.indexOf(value) !== -1 ||

      val.telefono_proveedor.indexOf(value) !== -1 ||

      val.localidad.indexOf(value) !== -1 ||

      val.razon_social_proveedor.toLowerCase().indexOf(value.toLowerCase()) !== -1 ||

      val.telefono_proveedor.toLowerCase().indexOf(value.toLowerCase()) !== -1 ||

      val.localidad.toLowerCase().indexOf(value.toLowerCase()) !== -1
      
    ) : li;
  }
}
