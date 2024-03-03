import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LeaveType } from './leave-type.model';


const BASE_URL=["http://localhost:8080/"];

@Injectable({
  providedIn: 'root'
})
export class JwtService {

  constructor(private http: HttpClient) {}

     managerregister(signRequest:any):Observable<any>{
        return this.http.post(BASE_URL+'api/auth/register/manager',signRequest)
     }
     employeeregister (signRequest:any):Observable<any>{
      return this.http.post(BASE_URL+'api/auth/add/employee',signRequest)
   }
    login(loginRequest:any):Observable<any>{
      return this.http.post(BASE_URL+'api/auth/login',loginRequest);
    }
     getManagers(): Observable<any[]> {
      return this.http.get<any[]>(BASE_URL + 'api/auth/managerlist');
    }

    createLeaves(signRequest:any):Observable<any>{
      return this.http.post(BASE_URL+'api/auth/leaves/create',signRequest);
    }

    getLeaveTypes(): Observable<any[]> {
      return this.http.get<any[]>(BASE_URL + 'api/auth/leaveslist');
    }
    updateLeaveType(leaveTypeData: LeaveType): Observable<LeaveType> {
      return this.http.put<LeaveType>(BASE_URL + 'api/auth/updateLeave', leaveTypeData);
    }
    public getLeaves(){
      return this.http.get(BASE_URL + 'api/auth/leaveslist');
    }
    public deleteLeaves(id:any){
      return this.http.delete(BASE_URL+'api/auth/deleteLeave?id='+id);
    }

    public updateLeave(leave:any){
      return this.http.put(BASE_URL+'api/auth/update',leave);
    }
    public getLeaveSummary(){
      return this.http.get(BASE_URL+'api/auth/leaveSummary');
    }

    public getFilteredSummary(fromDate:any,toDate:any){
      let params = new HttpParams()
      .set('fromDate', fromDate)
      .set('toDate', toDate);
      return this.http.get(BASE_URL+'api/auth/leaves/filtered',{params});
    }
}
