import {Component, OnInit} from '@angular/core';

import * as $ from 'jquery';
import {AccountService} from '../services/account.service';
import {TokenService} from '../services/token.service';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css'],
})
export class AccueilComponent implements OnInit {

  userInfos: any;

  constructor(private account: AccountService, private token: TokenService) {
  }

  envir: any;

  ngOnInit(): void {
    this.account.authStatus.subscribe(
      res => {
        this.userInfos = this.token.getInfos();
        this.envir = this.token.getEnv();
      }
    )

    if (this.userInfos.admin == true) {
      $('.card').toggleClass('active')
    }

    if (localStorage.tablSize) {
      let tablCard = [$("#card0"), $("#card1"), $("#card2"), $("#card3"), $("#card4")]
      let tablSize = [];
      tablSize = (localStorage.tablSize).split(',')

      for (let i = 0; i <= (tablSize.length / 2); i++) {
        let hLoad = tablSize[0]
        let wLoad = tablSize[1]
        let cardLoad = tablCard[0]

        cardLoad.width(wLoad)
        cardLoad.height(hLoad)

        tablSize.shift();
        tablSize.shift();
        tablCard.shift();
      }
    }
  }

  saveBtn() {
    let tablCard = [$("#card0"), $("#card1"), $("#card2"), $("#card3"), $("#card4")]
    let tablSize = []

    for (let i = 0; i < tablCard.length; i++) {
      let hSave = tablCard[i].height();
      let wSave = tablCard[i].width();

      tablSize.push(hSave)
      tablSize.push(wSave)
    }
    localStorage.tablSize = tablSize
  }

  deployer(id, idPlus, idMoins) {
    document.getElementById(id).style.display = 'block'

    document.getElementById(idPlus).style.visibility = 'hidden'
    document.getElementById(idMoins).style.visibility = 'visible'
  }

  cacher(id, idPlus, idMoins) {
    document.getElementById(id).style.display = ''

    document.getElementById(idPlus).style.visibility = 'visible'
    document.getElementById(idMoins).style.visibility = 'hidden'
  }

  zoomCarousel() {
    $('.carousel-inner').toggleClass('active')
    $('.carousel-caption').toggleClass('active')
  }

}
