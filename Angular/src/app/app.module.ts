import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
// import { EmpRegisterComponent } from './emp-register/emp-register.component';
import { ReactiveFormsModule } from '@angular/forms';
import { RegistrationParentComponent } from './registration-parent/registration-parent.component';
import { FormsModule } from '@angular/forms';
import { EmployeeComponent } from './employee/employee.component';
import { ManagerComponent } from './manager/manager.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { InvalidComponent } from './invalid/invalid.component';
// import { SettingsComponent } from './settings/settings.component';
// import { EditLeaveTypeComponent } from './edit-leave-type/edit-leave-type.component';
import { DisplayleaveComponent } from './displayleave/displayleave.component';
import { EmpWiseLeavesComponent } from './emp-wise-leaves/emp-wise-leaves.component';
import { DatewiseleavesComponent } from './datewiseleaves/datewiseleaves.component';
@NgModule({
  declarations: [
    AppComponent,
    RegistrationParentComponent,
    EmployeeComponent,
    ManagerComponent,
    LoginComponent,
    DashboardComponent,
    InvalidComponent,
    // SettingsComponent,
    // EditLeaveTypeComponent,
    DisplayleaveComponent,
    EmpWiseLeavesComponent,
    DatewiseleavesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
