import { Component, OnInit ,ElementRef,ViewChild} from '@angular/core';
import { AdminServiceService } from '../admin-service.service';

@Component({
  selector: 'app-route-control',
  templateUrl: './route-control.component.html',
  styleUrls: ['./route-control.component.scss']
})
export class RouteControlComponent implements OnInit {

  Route={
    routeId:'',
    routeFrom:'',
    routeTo:'',
    distance:''
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

  submitaddform(route:any){
    this.adminsvc.addRoute(this.Route);
    this.ele.nativeElement.style.display='none';
  }

  submitdelform(routeid:any){
    this.adminsvc.deleteRoute(this.Route.routeId);
    this.ele1.nativeElement.style.display='none';
  }

  closeform(){
    this.ele.nativeElement.style.display='none';
    this.ele1.nativeElement.style.display='none';
  }

}
