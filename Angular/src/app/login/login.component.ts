import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { JwtService } from '../jwt.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit{
  loginForm!: FormGroup;
  errorMessage: string = '';
  constructor(
    private service: JwtService,
    private fb: FormBuilder,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
    })
  }

  // submitForm() {
  //   this.service.login(this.loginForm.value).subscribe(
  //     (response) => {
  //       console.log(response);
  //       console.log(response.data.token);
  //       if (response.data.token != null) {
  //         alert("Hello, Your token is " + response.data.token);
  //         const jwtToken = response.data.token;
  //         localStorage.setItem('jwt', jwtToken);
  //         this.router.navigateByUrl("/dashboard");
  //       }
  //     }
  //   )
  // }

  // submitForm() {
  //   console.log(this.loginForm.value.email);
  //   this.service.login(this.loginForm.value).subscribe(
  //     (response: any) => {
  //       console.log(response);
  //       const jwtToken = response.data.token;
  //       if (jwtToken) {
  //         // Decode the JWT token to get user information
  //        // const decodedToken = this.decodeJwtToken(jwtToken);
  //       //  console.log(decodedToken.sub);
  //         // Check if the user is a manager (Assuming "role" property indicates the user's role)
  //         //if (decodedToken.role === 'MANAGER') {
  //         //   alert("Hello, Your token is " + jwtToken);
  //         //   localStorage.setItem('jwt', jwtToken);
  //         //   this.router.navigateByUrl("/dashboard");
  //         // } else {
  //         //   // Handle case where user is not a manager (e.g., redirect to a different page)
  //         //   alert("You are not authorized to access the dashboard.");
  //         // }
  //         this.service.getManagers().subscribe(
  //           (managers: any[]) => {
  //             const isManager = managers.some(manager => manager.email === this.loginForm.value.email);
  //             if (isManager) {
  //               console.log("You're a manager");
  //               alert("Hello, Your token is " + jwtToken);
  //               localStorage.setItem('jwt', jwtToken);
  //               this.router.navigateByUrl("/dashboard");
  //             } else {
  //               console.log("Invalid inputs");
  //               this.errorMessage = "Invalid email or password";
  //               this.router.navigateByUrl("/login");
  //             }
  //           },
  //           (error) => {
  //             console.error('Error retrieving managers:', error);
  //             // Handle error (e.g., display error message)
  //           }
  //         );
  //       }
  //     },
  //     (error) => {
  //       console.error('Login error:', error);
  //       // Handle login error (e.g., display error message)
  //       // For example:
  //       // this.errorMessage = "An error occurred during login";
  //     }
  //   )
  // }


  submitForm() {
    this.errorMessage = ''; // Clear previous error message
    console.log(this.loginForm.value.email);
    try {
      this.service.login(this.loginForm.value).subscribe(
        (response: any) => {
          console.log(response);
          const jwtToken = response.data.token;
          if (jwtToken) {
            this.service.getManagers().subscribe(
              (managers: any[]) => {
                const isManager = managers.some(manager => manager.email === this.loginForm.value.email);
                if (isManager) {
                  console.log("You're a manager");
                  alert("Hello, Your token is " + jwtToken);
                  localStorage.setItem('jwt', jwtToken);
                  this.router.navigateByUrl("/dashboard");
                } else {
                  this.router.navigateByUrl("/invalid");
                  console.log("Login unsuccessful");
                  this.errorMessage = "Invalid email or password"; // Set error message
                }
              },
              (error) => {
                console.error('Error retrieving managers:', error);
                this.errorMessage = "An error occurred during login"; // Set error message
              }
            );
          }
          else {
            this.router.navigateByUrl("/invalid");
            console.log("Login unsuccessful");
            this.errorMessage = "Invalid email or password"; // Set error message
          }
        },
        (error) => {
          console.error('Login error:', error);
          this.errorMessage = "An error occurred during login"; // Set error message
        }
      );
    } catch (error) {
      console.error('Error:', error);
      this.errorMessage = "An error occurred during login"; // Set error message
    }
  }

  // Function to decode JWT token (Assuming you have a function to decode JWT token)
  decodeJwtToken(token: string): any {
    const tokenPayload = token.split('.')[1];
    const decodedPayload = atob(tokenPayload);
    return JSON.parse(decodedPayload);
  }

}
