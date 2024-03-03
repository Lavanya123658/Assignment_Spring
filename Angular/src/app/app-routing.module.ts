import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegistrationParentComponent } from './registration-parent/registration-parent.component';
import { ManagerComponent } from './manager/manager.component';
import { EmployeeComponent } from './employee/employee.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { InvalidComponent } from './invalid/invalid.component';
// import { SettingsComponent } from './settings/settings.component';
// import { EditLeaveTypeComponent } from './edit-leave-type/edit-leave-type.component';
import { DisplayleaveComponent } from './displayleave/displayleave.component';
import { EmpWiseLeavesComponent } from './emp-wise-leaves/emp-wise-leaves.component';
import { DatewiseleavesComponent } from './datewiseleaves/datewiseleaves.component';

const routes: Routes = [
  {path:"",component:EmployeeComponent},
  {path: "employeeregister",component:EmployeeComponent},
  {path:"managerregister",component:ManagerComponent},
  {path:"login",component:LoginComponent},
  {path:"dashboard",component:DashboardComponent},
  {path:"invalid",component:InvalidComponent},
  // { path: 'settings', component: SettingsComponent },
  // {path:'editleave',component:EditLeaveTypeComponent},
  {path:'displayleave',component:DisplayleaveComponent},
  {path:'empwise',component:EmpWiseLeavesComponent},
  {path:'datewise',component:DatewiseleavesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
