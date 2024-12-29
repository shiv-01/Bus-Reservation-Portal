import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  constructor(private userService:UserService,private router:Router) { }
  public user = {
    userLoginId:'',
    userName: '',
    password: '',
    firstName: '',
    lastName: '',
    contact: '',
    email: '',
    reservation: null
  }
  ngOnInit(): void {
  }
  formSubmit(){
    this.userService.addUser(this.user).subscribe({
      error: (e) => {console.error(e);
                      alert("Some error occured");},

      complete: () =>{console.log("Successfully added");
                      this.router.navigate(['/']);}
  })
   }

   formReset(){
    this.user.userLoginId = '',
    this.user.userName = '',
    this.user.password = '',
    this.user.firstName = '',
    this.user.lastName = '',
    this.user.contact= '',
    this.user.email= '';
   }
}
