import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {UserData} from "../../services/userdata.service";

@Component({
  selector: 'menup-component',
  templateUrl: './menu-p.component.html',
  styleUrls: ['./menu-p.component.css']
})
export class MenuPComponent implements OnInit {

  name: string;
  code: string;

  cssType: string;
  constructor(private router: Router) {
    this.name = UserData.getUsuario().nome;
    this.code = UserData.getUsuario().matricula;
  }

  ngOnInit() {
    if(window.screen.width < 768){
      this.cssType = 'sidebar-mobile fixed-sidebar';
    }else{
      this.cssType = 'sidebar fixed-sidebar';
    }

  }

  goHistorico(){
    this.router.navigate(['historico-a/'+this.code]);
  }

  goHome(){
    this.router.navigate(['home-aluno/'+this.code]);
  }

  goPerfil(){
    this.router.navigate(['perfil-a/'+this.code]);
  }

}
