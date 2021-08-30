import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor() {
  }


  set(data: any) {
    localStorage.setItem('token', data.token);
    localStorage.setItem('id', data.id);

  }

  handle(data) {
    this.set(data);
  }

  getToken() {
    return localStorage.getItem('token');
  }

  getEnv() {
    return localStorage.getItem('envir');
  }


  getId() {
    return localStorage.getItem('id');
  }

  remove() {
    localStorage.removeItem('token');
    localStorage.removeItem('id');
    localStorage.removeItem('envir');
    localStorage.removeItem('test');
  }

  decode(payload) {

    return JSON.parse(this.b64_to_utf8(payload));
  }

  payload(token) {
    const payload = token.split('.')[1];
    return this.decode(payload);
  }

  b64_to_utf8(str) {
    return decodeURIComponent(escape(window.atob(str)));
  }

  isValid() {
    const token = this.getToken();
    const id = this.getId();

    if (token) {
      const payload = this.payload(token);
      if (payload) {
        return id == payload.id;
      }
    }
    return false;
  }

  getInfos() {

    const token = this.getToken();
    if (token) {
      const payload = this.payload(token);
      return payload ? payload : null;
    }

    return null
  }

  loggedIn() {
    return this.isValid();
  }
}
