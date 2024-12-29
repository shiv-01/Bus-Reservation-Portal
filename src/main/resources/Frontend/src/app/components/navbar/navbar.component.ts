import { AdminServiceService } from './../../admin-service.service';
import { Component, OnInit,ElementRef,ViewChild } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  public admin:any={
    userName:'',
    password:''
  }

  @ViewChild("popup") ele!:ElementRef;

  adminData:any={}

  constructor(private adminSvc:AdminServiceService,private router:Router) { }

  ngOnInit(): void {
  }
  
  onclickSubmit(user:any){
    // this.adminSvc.loginAdmin(this.admin.userName,this.admin.password).subscribe(
    //   (data)=>{this.adminData = data;
    //     console.log(data);
    //     console.log(this.adminData);
    //     if(this.adminData == null || this.adminData == undefined){
    //       alert("Invalid Credentials");
    //     }
    //     else{
    //       alert("Login Successfull");
         this.ele.nativeElement.style.display="none";
          this.router.navigate(['/admin'])
        // }
      // });
  }

  show(){
    this.ele.nativeElement.style.display="block";
  }
}
