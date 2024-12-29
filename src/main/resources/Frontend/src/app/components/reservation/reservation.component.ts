import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import * as moment from 'moment';
@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.scss']
})
export class ReservationComponent implements OnInit {

  buses:any;
  myBusFrom:any='Source';
  myBusTo:any='Destination';
  myDate:any;
  constructor(private userService:UserService,private router:Router) { }

  ngOnInit(): void {
    let res = this.userService.getAllBus();
    res.subscribe((data)=>{this.buses = data;
    console.log(this.buses)});
    
  }
  public bus:any={

  };

  showBuses(busForm:any){
    this.userService.getBusBySourceAndDestination(busForm.myBusFrom,busForm.myBusTo).subscribe((data)=>{this.bus = data;console.log(data)});
    console.log(moment(this.myDate).format("yyyy-MM-DD"));
    this.router.navigate(['/getAvailableBuses',busForm.myBusFrom,busForm.myBusTo,moment(this.myDate).format("yyyy-MM-DD")
  ]);
    console.log(this.myBusFrom);
    console.log(this.myBusTo);
  }
}
