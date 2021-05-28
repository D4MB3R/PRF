import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product.model';
import { ProductService } from 'src/app/services/product.service';
import { PurchaseService } from 'src/app/services/purchase.service';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  products: Product[] = [];

  constructor(private productService: ProductService, private purchaseService: PurchaseService) { }

  ngOnInit(): void {
    this.productService.getProducts().subscribe(
      res => {
        this.products = res;
      } 
    );
  }

  buyProduct(name: String, price: number) {
    this.purchaseService.insertPurchase(name, price);
  }

}
