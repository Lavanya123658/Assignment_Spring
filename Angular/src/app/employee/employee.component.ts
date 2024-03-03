import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { JwtService } from '../jwt.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})
export class EmployeeComponent {
  registerForm!: FormGroup ;
  managers!: any[];
  constructor(
    private service:JwtService,
    private fb: FormBuilder
  ){}


  ngOnInit(): void {
    this.initForm();
    this.loadManagers();
  }

  initForm(): void {
    this.registerForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      personalEmail: ['', Validators.email],
      mobile: ['', Validators.required],
      dateOfJoining: ['', Validators.required],
      managerId: ['', Validators.required]
    });
  }

  loadManagers(): void {
    this.service.getManagers().subscribe(
      (data: any[]) => {
        this.managers = data;
      },

    );
  }


  submitForm(){
    console.log(this.registerForm.value);
    this.service.employeeregister(this.registerForm.value).subscribe(
      (response)=>{
      console.log(response);
      alert("successfully registered");
      }
    )
  }
}
