import { ElementRef,ViewChild,Component, OnInit } from '@angular/core';
import { AdminServiceService } from '../admin-service.service';

@Component({
  selector: 'app-bus-control',
  templateUrl: './bus-control.component.html',
  styleUrls: ['./bus-control.component.scss']
})
export class BusControlComponent implements OnInit {

  bus={busId:'',
      busName:'',
      driverName:'',
      busType:'',
      routeFrom:'',
      routeTo:'',
      day:'',
      arrivalTime:'',
      departureTime:'',
      seats:'',
      availableSeats:''
      }

  @ViewChild("openAddForm") ele!:ElementRef;
  @ViewChild("openDelForm") ele1!:ElementRef;
  
  constructor(private adminsvc:AdminServiceService) { }

  ngOnInit(): void {
  }

  openaddform(){
    this.ele.nativeElement.style.display='block';
  }

  opendelform(){
    this.ele1.nativeElement.style.display='block';
  }

  submitaddform(buses:any){
    this.adminsvc.addBus(this.bus);
    this.ele.nativeElement.style.display='none';
  }

  submitdelform(busid:any){
    this.adminsvc.deleteBus(this.bus.busId);
    this.ele1.nativeElement.style.display='none';
  }

  closeform(){
    this.ele.nativeElement.style.display='none';
    this.ele1.nativeElement.style.display='none';
  }

}
