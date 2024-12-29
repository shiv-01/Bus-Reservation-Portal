import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {

  baseurl='http://localhost:8083/'

  constructor(private http:HttpClient) { }

  public loginAdmin(username:any,password:any){
    return this.http.get("http://localhost:8083/loginuser/"+username+"/"+password);
  }

  public deleteUser(id:any){
    return this.http.delete(this.baseurl+"deleteuser/"+id);
  }

  public addBus(bus:any){
    return this.http.post(this.baseurl+"addbusbyadmin",bus);
  }

  public deleteBus(busid:any){
    return this.http.delete(this.baseurl+"deletebusbyadmin/"+busid);
  }

  public addRoute(route:any){
    return this.http.post(this.baseurl+"addroutebyadmin",route);
  }

  public deleteRoute(routeId:any){
    return this.http.delete(this.baseurl+"deleteroutebyadmin/"+routeId);
  }

  public updateRoute(route:any){
    return this.http.put(this.baseurl+"updateroutebyadmin/",route);
  }

  public deleteFeedback(feedbackid:any){
    return this.http.delete(this.baseurl+"deletefeedbackbyadmin/"+feedbackid)
  }

  public viewFeedback(feedbackid:any){
    return this.http.get(this.baseurl+"viewfeedbackbyadmin/"+feedbackid)
  }

}
