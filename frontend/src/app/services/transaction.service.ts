import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Transaction } from '../models/transaction.model';
import { environment } from 'src/environments/environment';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  constructor(private http: HttpClient) { }

  getTransactions(): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(environment.springUrl + 'transactions').pipe(
      map(data => data.map(data => new Transaction().deserialize(data)))
    );
  }

  makeTransaction(date_of_purchase: String, purchase_id: number, price: number) {
    this.http.post(environment.springUrl + 'transactions', {"date_of_purchase": date_of_purchase, "purchase_id": purchase_id, "price": price}).subscribe();
  }
}
