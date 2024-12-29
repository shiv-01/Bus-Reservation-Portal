import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { ShareObjectService } from 'src/app/services/share-object.service';

@Component({
  selector: 'app-login-menu',
  templateUrl: './login-menu.component.html',
  styleUrls: ['./login-menu.component.scss']
})
export class LoginMenuComponent implements OnInit {

  constructor(private userService:UserService,private router:Router,private share:ShareObjectService) { }
  public user:any = {
    userName:'',
    password:''
  }
  ngOnInit(): void {
    
  }
  public userData:any = {

  }

  login(){
    this.userService.loginUser(this.user.userName,this.user.password).subscribe(
      (data)=>{this.userData = data;
        this.share.setMessage(this.userData);
        console.log(data);
        console.log(this.userData);
        if(this.userData == null || this.userData == undefined){
          alert("Invalid Credentials First Register Yourself");
        }
        else{
          alert("Login Successfull");
          this.router.navigate(['/home'])
        }
      });
  }
}
