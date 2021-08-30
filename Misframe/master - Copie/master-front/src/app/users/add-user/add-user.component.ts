import {TokenService} from './../../services/token.service';
import {AccountService} from './../../services/account.service';
import {UsersService} from './../../services/users.service';
import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';


@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {
  envir: any
  showMsg: boolean = false;
  formUsers = new FormGroup({
    firstName: new FormControl('', [Validators.required]),
    lastName: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)]),


  })

  constructor(private userService: UsersService, private router: Router, private account: AccountService, private token: TokenService) {
  }

  ngOnInit(): void {

    this.account.authStatus.subscribe(
      res => {

        this.envir = this.token.getEnv();
      }
    )
  }

  createUser(): void {
    this.userService.AddUser(this.formUsers.value)
      .subscribe(data => {
        this.router.navigate(['/addUser']);
        this.showMsg = true;
        this.formUsers.reset();

      });

  };

}
