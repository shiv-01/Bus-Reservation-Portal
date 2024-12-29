import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { ShareObjectService } from 'src/app/services/share-object.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  public userData:any = {

  }
  constructor(private userService:UserService,private router:Router,private share:ShareObjectService) { }
  ngOnInit(): void {
    this.userData = this.share.getMessage();
    console.log(this.userData);
  }

  getReserved(){
    this.router.navigate(['/reservation']);
  }

  reservation:any = this.share.getReservation();
  user:any = this.share.getMessage();

  deleteReservation(){
    this.userService.deleteReservation(this.reservation,this.user.userName).subscribe((data)=>{console.log(data)})
    alert("Reservation Cancelled Successfully");
  }

  addFeedback(){
    this.router.navigate(['/feedbacks'])
  }
}
