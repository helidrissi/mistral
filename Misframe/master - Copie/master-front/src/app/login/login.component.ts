import {AccountService} from './../services/account.service';
import {TokenService} from './../services/token.service';
import {AuthService} from './../services/auth.service';
import {Component, OnInit} from '@angular/core';
import {FormGroup, FormControl, Validators} from '@angular/forms'
import {Router} from '@angular/router';

import {TranslateService} from '@ngx-translate/core';
import {AppComponent} from '../app.component';
import {typeofExpr} from '@angular/compiler/src/output/output_ast';
import {FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  lgn = window.localStorage.getItem('lang');

  env: any;
  class: any;


  formLogin = this.fb.group({

    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)]),
    envir: ['prod', [Validators.required]],
  })

  constructor(private authService: AuthService, private token: TokenService, private router: Router, private account: AccountService,
              public translateChild: TranslateService, public app: AppComponent, public fb: FormBuilder) {

    let browserLang: string = 'fr';
    browserLang = (browserLang.substring(0, 2));
    if (browserLang) {
      if (browserLang == 'fr') {
        translateChild.setDefaultLang('fr');
      } else if ((browserLang == 'en')) {
        translateChild.setDefaultLang('en');
      } else {
        translateChild.setDefaultLang('fr')
      }
      window.localStorage.setItem('lang', 'fr');
    }
  }

  ngOnInit(): void {

    if (this.lgn == 'en') {
      this.lgn = "English"
      this.class = "sl-flag flag-eng"
    } else if (this.lgn == 'fr') {
      this.lgn = "Français"
      this.class = "sl-flag flag-fr"
    } else {
      this.lgn = "Français"
      this.class = "sl-flag flag-fr"
    }

  }


  login() {
    this.authService.login(this.formLogin.get('email').value, this.formLogin.get('password').value).subscribe(res => this.handleResponse(res))

    localStorage.setItem('envir', this.formLogin.get('envir').value);
  }

  handleResponse(res) {
    this.token.handle(res);
    this.account.changeStatus(true);

    this.router.navigateByUrl("/");
  }

  useLanguage(language: string) {
    window.localStorage.setItem('lang', 'fr');
    this.translateChild.use(language);
    this.app.translateParent = this.translateChild;

    this.lgn = language;
    if (this.lgn == 'fr') {

      this.lgn = "Français"
      this.class = "sl-flag flag-fr"

    } else if (this.lgn == 'en') {
      this.lgn = "English"
      this.class = "sl-flag flag-eng"
    }

  }


}
