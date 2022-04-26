import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{

  apiUrl = 'https://springbootangular11crud.herokuapp.com/api/';
  title = 'front-end';

  ngOnInit(): void
  {
  }
}
