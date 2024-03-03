import { Component, OnInit } from '@angular/core';
import { JwtService } from '../jwt.service';
import { FormGroup, FormBuilder, Validators ,NgForm} from '@angular/forms';

@Component({
  selector: 'app-displayleave',
  templateUrl: './displayleave.component.html',
  styleUrls: ['./displayleave.component.scss']
})
export class DisplayleaveComponent implements OnInit{
  registerForm!: FormGroup ;
  leavesedit!:any[];
  showModal: boolean = false;
 // updateForm!:FormGroup;


  leaves:any = null;
  constructor(private service:JwtService,private fb: FormBuilder){
    this.getLeaveDetails();
  }

  // ngOnInit(): void {
  //   this.registerForm=this.fb.group({
  //     name:['',[Validators.required]],
  //     maxLeaves:['',Validators.required]
  //   })
  // }
  ngOnInit(): void {

    this.registerForm=this.fb.group({
      name:['',[Validators.required]],
      maxLeaves:['',Validators.required]
    })
    this.service.getLeaveTypes().subscribe(
      (response: any[]) => {
        this.leavesedit = response;
      }
    );
  }
  leaveToUpdate={
    //console.log(this.leaveToUpdate);
    id:null,
    name:"",
    maxLeaves:null
  }


  getLeaveDetails(){
    this.service.getLeaves().subscribe(
      (resp)=>{
        console.log(resp);
        this.leaves=resp;
        console.log("this is",this.leaves.id);
      },
      (err)=>{
        console.log(err);
      }
    )
  }

  delete(leave:any){
    this.service.deleteLeaves(leave.id).subscribe(
      (resp)=>{
        console.log(resp);
        this.getLeaveDetails();
      },
      (err)=>console.log(err)
    );
  }

  edit(leaveIn:any){
    console.log("inedit");
    this.leaveToUpdate=leaveIn;
    console.log(this.leaveToUpdate);
    this.showModal = true;
    // ($('#exampleModal') as any).modal('show');
  }

  update(){
    this.service.updateLeave(this.leaveToUpdate).subscribe(
      (resp)=>{
        console.log(resp);
      },
      (err)=>console.log(err)
    );
  }

  submitForm() {
    const leaveTypeData = this.registerForm.value;
    console.log(leaveTypeData);

    // Check if the leave type already exists
    const leaveTypeExists = this.leavesedit.find(leave => leave.name === leaveTypeData.name);
    console.log(leaveTypeExists);
    if (leaveTypeExists!=undefined) {
      // Update existing leave type
      console.log(leaveTypeExists.maxLeaves);
      leaveTypeExists.maxLeaves = leaveTypeData.maxLeaves;

      // Call the service method to update the leave type
      this.service.updateLeaveType(leaveTypeExists).subscribe(
        (response) => {
          this.getLeaveDetails();
          console.log("Leave type updated:", response);

        },
        (error) => {
          console.error("Error updating leave type:", error);
        }
      );
    } else {
      // Create new leave type
      this.service.createLeaves(leaveTypeData).subscribe(
        (response) => {

          console.log("New leave type created:", response);
          this.getLeaveDetails();

        },
        (error) => {
          console.error("Error creating new leave type:", error);
        }
      );
    }

  }
}

