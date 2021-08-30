import {BrowserModule} from '@angular/platform-browser';
import {NgScrollbarModule} from 'ngx-scrollbar';

import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule, HTTP_INTERCEPTORS, HttpClient} from '@angular/common/http'

import {TranslateLoader, TranslateModule} from '@ngx-translate/core';
import {TranslateHttpLoader} from '@ngx-translate/http-loader';

import {AppComponent} from './app.component';
import {PageNotFoundComponent} from './partials/page-not-found/page-not-found.component';

import {LoginComponent} from './login/login.component';
import {AppRoutingModule} from './app-routing.module';


import {JwtInterceptor} from './services/jwt.interceptor';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ToastrModule} from 'ngx-toastr';
import {SidebarComponent} from './sidebar/sidebar.component';


import {AccueilComponent} from './accueil/Accueil.component';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {AdministrationComponent} from './administration/administration.component';


import {AddUserComponent} from './users/add-user/add-user.component';


@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,

    LoginComponent,
    SidebarComponent,

    AccueilComponent,
    AdministrationComponent,


    AddUserComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    NgScrollbarModule,

    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot(), // ToastrModule added
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }

    }),
    FontAwesomeModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: JwtInterceptor,
    multi: true,
  }

  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}

export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http);
}
