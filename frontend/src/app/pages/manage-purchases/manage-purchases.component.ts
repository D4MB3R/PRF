import { Component, OnInit } from '@angular/core';
import { Purchase } from 'src/app/models/purchase.model';
import { PurchaseService } from 'src/app/services/purchase.service';

@Component({
  selector: 'app-manage-purchases',
  templateUrl: './manage-purchases.component.html',
  styleUrls: ['./manage-purchases.component.css']
})
export class ManagePurchasesComponent implements OnInit {

  purchases: Purchase[] = [];

  constructor(private purchaseService: PurchaseService) { }

  ngOnInit(): void {
    this.purchaseService.getPurchases().subscribe(
      res => {
        this.purchases = res;
      }
    )
  }

}
