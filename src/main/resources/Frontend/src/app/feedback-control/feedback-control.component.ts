import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { AdminServiceService } from '../admin-service.service';

@Component({
  selector: 'app-feedback-control',
  templateUrl: './feedback-control.component.html',
  styleUrls: ['./feedback-control.component.scss']
})
export class FeedbackControlComponent implements OnInit {

  @ViewChild("openDelForm") ele1!:ElementRef;
  @ViewChild("openViewForm") ele2!:ElementRef;

  Feedback:any={
    feedbackId:'',
    driverRating:'',
    serviceRating:'',
    overallRating:'',
    comments:'',
    feedbackdate:'',
    users:null,
    bus:null
  }

  constructor(private adminsvc:AdminServiceService) { }

  ngOnInit(): void {
  }

  opendelform(){
    this.ele1.nativeElement.style.display='block';
  }

  submitdelform(busid:any){
    this.adminsvc.deleteFeedback(this.Feedback.feedbackId);
    this.ele1.nativeElement.style.display='none';
  }

  closeform(){
    this.ele1.nativeElement.style.display='none';
    this.ele2.nativeElement.style.display='none';
  }

  openviewtable(){
    this.ele2.nativeElement.style.display='block';
  }

  getFeedbackDetails(id:any){
    this.adminsvc.viewFeedback(id).subscribe((data)=>{
      console.log(data);
    });
  }
}
