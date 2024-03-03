import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { JwtService } from '../jwt.service';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.scss']
})
export class ManagerComponent {
  registerForm!: FormGroup ;

  constructor(
    private service:JwtService,
    private fb: FormBuilder
  ){}


  ngOnInit(): void {
    this.registerForm=this.fb.group({
      name:['',[Validators.required]],
      email:['',[Validators.required,Validators.email]],
      password:['',[Validators.required]],
      mobile:['',[Validators.required]],
      personalEmail:['',[Validators.required,Validators.email]],
      dateOfJoining:['',[Validators.required]]
    })
  }

  submitForm(){
    console.log(this.registerForm.value);
    this.service.managerregister(this.registerForm.value).subscribe(
      (response)=>{
      console.log(response);
      alert("successfully registered");
      }
    )
  }
}
