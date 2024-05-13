import { string } from "../valueObjects/string";

/**
 * Class representing a product.
 */
export class Product {
    /** The unique identifier of the product. */
    private _id?: string;
    
    /** The name of the product. */
    private _name: string;
    
    /** The code of the product. */
    private _code: string;
    
    /** The description of the product. */
    private _description: string;
    
    /** The value of the product. */
    private _value: number;
    
    /** The date when the product was created. */
    private _created_at?: Date;
    
    /** The date when the product was last updated. */
    private _updated_at?: Date;

    /**
     * @param {string} id - The unique identifier of the product.
     * @param {string} name - The name of the product.
     * @param {string} code - The code of the product.
     * @param {string} description - The description of the product.
     * @param {number} value - The value of the product.
     * @param {Date} created_at - The date when the product was created.
     * @param {Date} updated_at - The date when the product was last updated.
     */
    constructor(
        name: string, 
        code: string, 
        description: string, 
        value: number, 
        id?: string, 
        created_at?: Date, 
        updated_at?: Date
    ) {
        this._id = id;
        this._name = name;
        this._description = description;
        this._value = value;
        this._created_at = created_at;
        this._updated_at = updated_at;
        if (code.length > 13){
            throw new Error("Code's product above 13 doesn't exist. Please verify.")
        }
        this._code = code;
    }

    get id(): string | undefined{
        return this._id
    }
    get name(): string{
        return this._name
    }
    get code(): string{
        return this._code
    }
    get description(): string{
        return this._description
    }
    get value(): number{
        return this._value
    }
    get created_at(): Date | undefined{
        return this._created_at
    }
    get updated_at(): Date | undefined{
        return this._updated_at
    }
}
