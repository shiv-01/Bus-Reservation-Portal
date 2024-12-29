import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { ShareObjectService } from 'src/app/services/share-object.service';

@Component({
  selector: 'app-avilablebuses',
  templateUrl: './avilablebuses.component.html',
  styleUrls: ['./avilablebuses.component.scss']
})
export class AvilablebusesComponent implements OnInit {
  myBusFrom:any='';
  myBusTo:any='';
  allBuses:any;
  mydate:any;
  constructor(private share:ShareObjectService, private userService:UserService,private route:ActivatedRoute,private router:Router) { }
  user:any = this.share.getMessage();
  ngOnInit(): void {
    this.myBusFrom = this.route.snapshot.params['from'];
    this.myBusTo = this.route.snapshot.params['to'];
    this.mydate = this.route.snapshot.params['date'];
   this.userService.getBusBySourceAndDestination(this.myBusFrom,this.myBusTo).subscribe((data)=>
   {this.allBuses = data;
    console.log(data)});
    this.reservation.source = this.myBusFrom;
    this.reservation.destination = this.myBusTo
    this.reservation.reservationDate = this.mydate;
  }
  date:Date = new Date();

  public reservation = {
    reservationId:100,
    reservationStatus:'UnBooked',
    reservationType : 'Cash',
    reservationDate: '',
    reservationTime:'',
    source:'',
    destination:'',
    busId:null
  }
myData:any = {

};
  
  getReserved(bus:any){
    console.log(bus);
    let resType:any = prompt("What is your reservation type online or by Cash");
    this.reservation.reservationType = resType;
    this.reservation.reservationStatus = 'booked';
    this.reservation.busId = bus;
    this.reservation.reservationTime = this.date.getHours()+":"+this.date.getMinutes();
    console.log(this.reservation)
    console.log(this.user);
    this.user.reservation = this.reservation
    this.share.setReservationData(this.reservation);
    // this.userService.addReservation(this.reservation).subscribe( (data) => console.log(data));
    // this.userService.addReservationForUser(this.user,this.user.userName).subscribe( (data) => console.log(data));
    this.userService.addReservationForUser(this.user.userName,this.reservation).subscribe( (data) => console.log(data));
    alert("Reservation done successfully");
  }
}
