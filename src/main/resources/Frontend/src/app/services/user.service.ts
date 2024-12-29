import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseurl from './helper';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  public addUser(users:any){
    return this.http.post(`${baseurl}/adduser`,users);
  }

  public getAllBus(){
    return this.http.get("http://localhost:8083/getallbus");
  }

  public getBusBySourceAndDestination(myBusFrom:any,myBusTo:any){
    return this.http.get("http://localhost:8083/getbusbysourceanddestination/"+myBusFrom+"/"+myBusTo);
  }

  public addReservation(reservation:any){
    return this.http.post(`${baseurl}/addreservation`,reservation);
  }

  // Method Created By Mam
  // public addReservationForUser(user:any,username:any){
  //   console.log(username);
  //   return this.http.post(`${baseurl}/addreservationforuser/${username}`,user);
  // }
  public addReservationForUser(username:any,reservation:any){
    console.log(username);
    return this.http.put(`${baseurl}/addreservationforuser/${username}`,reservation);
  }
  public getUserDetaills(username:any){
      return this.http.get("http://localhost:8083/getuserbyusername/"+username);
  }

  public loginUser(username:any,password:any){
    return this.http.get("http://localhost:8083/loginuser/"+username+"/"+password);
  }


  public deleteReservation(reservation:any,username:any){
    return this.http.put(`${baseurl}/deletereservationforuser/${username}`,reservation);
  }
}
