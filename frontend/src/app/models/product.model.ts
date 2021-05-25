import { Deserializable } from "./deserializable.model";

export class Product implements Deserializable {

    id!: string;
    name!: string;
    price!: number;

    deserialize(input: any): this {
        Object.assign(this, input);
        return this;
    }
}
