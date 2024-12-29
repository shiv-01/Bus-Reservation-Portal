import { AdminServiceService } from '../admin-service.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-user-control',
  templateUrl: './user-control.component.html',
  styleUrls: ['./user-control.component.scss']
})
export class UserControlComponent implements OnInit {

  userid:any;

  constructor(private adminsvc:AdminServiceService,private router:Router) { }

  ngOnInit(): void {
  }

  onClickSubmit(userid:any){
    this.adminsvc.deleteUser(this.userid);

  }
}
