import { Deserializable } from "./deserializable.model";

export class Transaction implements Deserializable {

    transaction_id!: number;
    date_of_purchase!: string;
    purchase_id!: number;
    price!: number;

    deserialize(input: any): this {
        Object.assign(this, input);
        return this;
    }
}
