import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ShareObjectService {

  message:any;
  constructor() { }

  setMessage(data:any){
    this.message = data;
  }

  getMessage(){
    return this.message;
  }

  setReservationData(data:any){
     this.message = data;
  }

  getReservation(){
    return this.message;
  }
}
