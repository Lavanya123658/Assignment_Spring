import { Component } from '@angular/core';
import { JwtService } from '../jwt.service';

@Component({
  selector: 'app-emp-wise-leaves',
  templateUrl: './emp-wise-leaves.component.html',
  styleUrls: ['./emp-wise-leaves.component.scss']
})
export class EmpWiseLeavesComponent {
  constructor(private service:JwtService){
    this.getSummary();
  }

  leaveSummary:any = null;

  getSummary(){
    this.service.getLeaveSummary().subscribe(
      (resp)=>{
        console.log(resp);
        this.leaveSummary=resp;
        console.log(this.leaveSummary)
      },
      (err)=>console.log(err)
    );
  }

}
