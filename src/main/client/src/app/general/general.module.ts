import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {NavComponent} from "./nav/nav.component";
import {RouterModule} from "@angular/router";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {HomeComponent} from './home/home.component';
import {TranslateModule} from '@ngx-translate/core';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    NgbModule.forRoot(),
    TranslateModule
  ],
  declarations: [NavComponent, HomeComponent],
  exports: [NavComponent, TranslateModule]
})
export class GeneralModule {
}
