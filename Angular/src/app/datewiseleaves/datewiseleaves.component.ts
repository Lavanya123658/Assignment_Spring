import { Component } from '@angular/core';
import { JwtService } from '../jwt.service';

@Component({
  selector: 'app-datewiseleaves',
  templateUrl: './datewiseleaves.component.html',
  styleUrls: ['./datewiseleaves.component.scss']
})
export class DatewiseleavesComponent {

  leaveSummary: any;
  fromDate: string='';
  toDate: string='';

  constructor(private service:JwtService) {
    this.fetchLeaveSummary();
   }

  ngOnInit(): void {
    // Fetch leave summary initially

  }

  fetchLeaveSummary() {
    // Fetch leave summary based on selected date range
    this.service.getFilteredSummary(this.fromDate, this.toDate).subscribe(
      (resp) => {
        this.leaveSummary=resp;
        console.log(this.leaveSummary)
      },
      (error) => {
        console.error('Error fetching leave summary:', error);
      }
    );
  }

  filterLeaveSummary() {
    // Call fetchLeaveSummary to apply filtering
    this.fetchLeaveSummary();
  }


}
