export class EnvService {
    public version = '1.0.0';
    public langDefault = sessionStorage.getItem('lang') != undefined ? sessionStorage.getItem('lang') : 'en';
    public langPath = 'assets/i18n/';
    public indexPath = '/';
    
}
  