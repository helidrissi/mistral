import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  baseUrl = "http://localhost:8080/users";

  constructor(private http: HttpClient) {
  }

  // getUser(id: string) {
  //   return this.http.get(`${this.baseUrl}/${id}`);
  // }
  // getUsers()
  // {

  //   return this.http.get("");
  // }


  AddUser(data: { firstName: string, lastName: string, email: string, password: string }) {

    return this.http.post(this.baseUrl, data)

  }
}
