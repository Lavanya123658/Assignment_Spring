import { Component } from '@angular/core';

@Component({
  selector: 'app-registration-parent',
  templateUrl: './registration-parent.component.html',
  styleUrls: ['./registration-parent.component.scss']
})
export class RegistrationParentComponent {
  registrationType: string = 'employee';
}
