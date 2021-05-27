import { Deserializable } from "./deserializable.model";

export class Purchase implements Deserializable{

    purchase_id!: number;
    name!: string;
    price!: number;

    deserialize(input: any): this {
        Object.assign(this, input);
        return this;
    }
}
