import {HttpClient} from '@angular/common/http';

import {interval, Subscription} from 'rxjs';


import {Component, Input, OnInit} from '@angular/core';
import * as $ from 'jquery';
import {AccountService} from '../services/account.service';
import {TokenService} from '../services/token.service';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {TranslateService} from '@ngx-translate/core';

import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import {data} from 'jquery';
import {DomSanitizer} from '@angular/platform-browser';

@Component({
  selector: 'sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  selectedFile: File;
  retrievedImage: any;
  retrievedImageM: any;
  base64Data: any;
  retrieveResonse: any;
  base64Data1: any;
  retrieveResonse1: any;
  message: string;
  imagePath: any
  imageName: any;
  class: any;
  Users: any[] = [];
  currentuser: null;
  userInfos: any = null;
  closeResult: string;
  subscription: Subscription;
  cst: any;
  testt: any;
  env: any;
  envir: any
  lgn: string;
  translateChild: any;
  XX: any;

  constructor(private account: AccountService, private token: TokenService, private router: Router, private toastr: ToastrService,
              private modalService: NgbModal, private httpClient: HttpClient, private _sanitizer: DomSanitizer) {
  }

  searchText = '';
  searchText1 = '';
  menu1 = [

    {
      libelle: 'Calendrier (CAL)',
      menu: '/menu',
      pgm: 'CAL',


    },
    {
      libelle: 'Pays (PAY)',
      menu: '/menu',
      pgm: 'PAY',


    },
    {
      libelle: 'Devis (DEV)',
      menu: '/menu',
      pgm: 'DEV',


    },
    {
      libelle: 'Langues (LAN)',
      menu: '/menu',
      pgm: 'LAN',


    },
    {
      libelle: 'Modes de Paiement (TPA)',
      menu: '/menu',
      pgm: 'TPA',


    },
    {
      libelle: 'Table Arrondis / Tranches de Prix (TAP)',
      menu: '/menu',
      pgm: 'TAP',


    },
    {
      libelle: 'Sélection Modéles Etiquette Code Barre (TME)',
      menu: '/menu',
      pgm: 'TME',


    },
    {
      libelle: 'Titre Sociaux /Civilités (CIV)',
      menu: '/menu',
      pgm: 'CIV',


    },
    {
      libelle: 'Fonctions Exercées /Société (FEE)',
      menu: '/menu',
      pgm: 'FEE',


    },
    {
      libelle: 'Fonctions Externes (FIE)',
      menu: '/menu',
      pgm: 'FIE',


    },
    {
      libelle: 'Table des Services (TSE)',
      menu: '/menu',
      pgm: 'TSE',


    },
    {
      libelle: 'Organisme Renseignements Commerciaux (ORC)',
      menu: '/menu',
      pgm: 'ORC',


    },
    {
      libelle: 'Marques Matériels (MAR)',
      menu: '/menu',
      pgm: 'MAR',


    },
    {
      libelle: 'Gammes Matériels (GAM)',
      menu: '/menu',
      pgm: 'GAM',


    },
    {
      libelle: 'Types Matériels (TYP)',
      menu: '/menu',
      pgm: 'TYP',


    },
    {
      libelle: 'Niveaux d Etat du Matériel (NEM)',
      menu: '/menu',
      pgm: 'NEM',


    },
    {
      libelle: 'Caractéristique Techniques (CTE)',
      menu: '/menu',
      pgm: 'CTE',


    },
    {
      libelle: 'Profils Techniques (PTE)',
      menu: '/menu',
      pgm: 'PTE',


    }]

  menuFSA = [

    {
      libelle: 'Tables diverses (TDI)',
      menu: '/menu',
      pgm: 'TDI'

    },
    {
      libelle: 'Paramètres généraux (PGX)',
      menu: '/menu',
      pgm: 'PGX'

    },
    {
      libelle: 'Libellés dinfos édités/documents (IDO)',
      menu: '/menu',
      pgm: 'IDO'

    },
    {
      libelle: 'Message Clients Affichés /Ecran (MSG)',
      menu: '/menu',
      pgm: 'MSG'

    },
    {
      libelle: 'Compétence Personnel (TAT)',
      menu: '/menu',
      pgm: 'TAT'

    },
    {
      libelle: 'Familles & Catégories de Matériel (FCM)',
      menu: '/menu',
      pgm: 'FCM'

    },
    {
      libelle: 'Familles & Sous-Familles Articles (FSA)',
      menu: '/menu',
      pgm: 'FSA'

    },
    {
      libelle: 'Repertoire Specifique (RSP)',
      menu: '/menu',
      pgm: 'RSP'

    },

    {
      libelle: 'Paramétrage des Taux de TVA (PTV)',
      menu: '/menu',
      pgm: 'PTV'

    }, {
      libelle: 'Postes de Cessions Internes (PCI)',
      menu: '/menu',
      pgm: 'PCI'

    },
    {
      libelle: 'Tables des Natures d intervention (TNO)',
      menu: '/menu',
      pgm: 'TNO'

    },
    {
      libelle: 'Opérations Standards (OPE)',
      menu: '/menu',
      pgm: 'OPE'

    },
    {
      libelle: 'Critères de Classification des Taches (CTT)',
      menu: '/menu',
      pgm: 'CTT'

    },
    {
      libelle: 'Nomenclature des Taches (TBA)',
      menu: '/menu',
      pgm: 'TBA'

    },
    {
      libelle: 'Profils des visites Types (PVT)',
      menu: '/menu',
      pgm: 'PVT'

    },
    {
      libelle: 'Activités Fournisseurs (ATF)',
      menu: '/menu',
      pgm: 'ATF'

    }, {
      libelle: 'Secteurs Géographique (SEC)',
      menu: '/menu',
      pgm: 'SEC'

    },
    {
      libelle: 'Familles Clients (FCL)',
      menu: '/menu',
      pgm: 'FCL'

    }

  ]

  menu2 = [

    {
      libelle: 'Divisions Internes (DVS)',
      menu: '/menu',
      pgm: 'DVS'

    },
    {
      libelle: 'Répertoire Activités Clients (ACC)',
      menu: '/menu',
      pgm: 'ACC'

    },
    {
      libelle: 'Niveaux Suivi Clients/Prospects (NIS)',
      menu: '/menu',
      pgm: 'NIS'

    }]

  menu3 = [

    {
      libelle: 'Ateliers/Véhicule Dépannage (ATE)',
      menu: '/menu',
      pgm: 'ATE'

    },
  ]

  menu4 = [

    {
      libelle: 'Postes de Repgroupement (POS)',
      menu: '/menu',
      pgm: 'ATE'

    },
    {
      libelle: 'Titres du Plan Comptable (TPC)',
      menu: '/menu',
      pgm: 'TPC'

    }

  ]

  menuGC = [

    {
      libelle1: 'Base multi-activites',
      libelle2: 'Service commercial',
      libelle3: 'Reparation-s.a.v',
    },


  ]


  menuBM = [

    {
      libelle1: 'Fichiers Multi-societes',

      libelle2: 'Fichiers/Societe/Agence'
    },

  ]


  getImage() {

    //Make a call to Sprinf Boot to get the Image Bytes.

    // this.httpClient.get('http://localhost:9000/image/get/'+this.userInfos.email)

    this.httpClient.get('http://localhost:8080/image/get/' + this.XX)
      .subscribe(
        res => {

          this.retrieveResonse = res;

          this.base64Data = this.retrieveResonse.picByte;

          this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;


        }
      );
  }

  getImage1() {

    //Make a call to Sprinf Boot to get the Image Bytes.

    this.httpClient.get('http://localhost:8080/image/get/' + this.envir)

      .subscribe(
        res => {

          this.retrieveResonse1 = res;


          this.base64Data1 = this.retrieveResonse1.picByte;

          this.retrievedImageM = 'data:image/jpeg;base64,' + this.base64Data1;
          // this.retrievedImageM = 'data:image/jpg;base64,' + (this._sanitizer.bypassSecurityTrustResourceUrl(this.base64Data1) as any).changingThisBreaksApplicationSecurity;
        }
      );
  }

  ngOnInit(): void {


    console.log(this.lgn)
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

    $(function () {
      if (window.localStorage.getItem('sideb') == 'close') {
        $('.btn-infoo').animate({}, 0).css({'rotate': '-90deg'})
        $('#sticky-footer').toggleClass('open')
      } else {
        $('.btn-infoo').animate({}, 0).css({'rotate': '0deg'})
        $('#sticky-footer').toggleClass('')
      }

      $(document).mousemove("mousemove", function (event) {
        if ($('#sidebar').hasClass('')) {
          if ((event.clientX <= 20) && (event.clientY >= 0 && event.clientY <= 945)) {
            $('#sidebar').toggleClass('active');
            $('#sticky-footer').toggleClass('open').css({'transition': 'all 0.5s'})
          }
        }
      })

      $(document).mouseleave("mouseleave", function (event) {
        if ($('#sidebar').hasClass('active')) {
          if (event.clientX < 0) {
            $('#sidebar').toggleClass('');
            $('#sticky-footer').toggleClass('')
          }
        }
      })

      var sidebar = window.localStorage.getItem('sideb')
      if (sidebar == 'close') {
        $('#sidebar').toggleClass('active').css({'transition': 'all 0.5s'})
        $('#sticky-footer').toggleClass('').css({'transition': 'all 0.5s'})
      } else {
        $('#sidebar').toggleClass('')
      }

      $('.btn-infoo').click(function (e) {
        e.preventDefault();
        if ($('#sidebar').hasClass('active')) {
          var etat: string = 'close'
          window.localStorage.setItem('sideb', etat)
        } else {
          etat = 'open'
          window.localStorage.setItem('sideb', etat)
        }
      })
    });

    this.account.authStatus.subscribe(
      res => {
        this.currentuser = this.token.getInfos();
        this.userInfos = this.token.getInfos();
        this.envir = this.token.getEnv();
        this.XX = this.token.getId();
      }
    )


    const source = interval(100);

    this.subscription = source.subscribe(val => this.getImage());
    this.subscription = source.subscribe(val => this.getImage1());


  }


  //emit value in sequence every 10 second


  openSidebar() {
    $('#sidebar').toggleClass('active').css({'transition': 'all 0.5s'});
    $('#sticky-footer').toggleClass('open').css({'transition': 'all 0.5s'});
    if ($('#sidebar').hasClass('active')) {
      $('.btn-infoo').animate({}, 0).css({'rotate': '-90deg'})
    } else {
      $('.btn-infoo').animate({}, 0).css({'rotate': '0deg'})
    }
  }

  // doAsyncTask().then(
  //   () => console.log("Task Complete!"),
  //   () => console.log("Task Errored!"),
  // );

  logout() {
    window.localStorage.removeItem('sideb');
    this.token.remove();
    this.account.changeStatus(false);
    let lang = window.localStorage.getItem('lang');
    if (lang == 'en') {
      this.toastr.info(
        `Logout`,
        'You are disconnected!',
        {
          timeOut: 3000,
          positionClass: 'toast-bottom-left',
        }
      )
    } else {
      this.toastr.info(
        `Déconnexion`,
        'Vous êtes déconnecté !',
        {
          timeOut: 3000,
          positionClass: 'toast-bottom-left',
        }
      )
    }
    ;
    this.router.navigateByUrl("/login");
  }

  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }


  changeLanguage(language: string) {
    if (language == 'fr') {
      this.translateChild.use(language)
      localStorage.setItem('lang', language)

      this.lgn = "Français"
      this.class = "sl-flag flag-fr"
    } else if (language == 'en') {
      this.translateChild.use(language)
      localStorage.setItem('lang', language)

      this.lgn = "English"
      this.class = "sl-flag flag-eng"
    } else {
      this.translateChild.use(language)
      localStorage.setItem('lang', language)

      this.lgn = "Français"
      this.class = "sl-flag flag-fr"
    }

  }

}
