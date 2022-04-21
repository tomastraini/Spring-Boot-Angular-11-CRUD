import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{

  apiUrl = 'http://localhost:44043/api/';
  title = 'front-end';

  ngOnInit(): void {
  }
}
