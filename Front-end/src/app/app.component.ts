import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{

  // apiUrl = 'http://localhost:44043/api/';
  apiUrl = 'https://springbootangular11crud.herokuapp.com/api/';
  title = 'front-end';

  ngOnInit(): void
  {
  }
}
