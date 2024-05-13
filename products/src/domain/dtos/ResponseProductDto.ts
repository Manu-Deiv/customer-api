
/**
 * Class representing a DTO (Data Transfer Object) for response a product.
 */
export class ResponseProductDto {

    
    private _id? : null | string;
    private _name: string;
    private _code: string;
    private _description: string;
    private _value: number;
    private _created_at?:  null | Date;
    private _updated_at?:  null | Date;

    /**
     * Constructor of the ResponseProductDto class.
     * @param {string} id - The name of the product.
     * @param {string} name - The name of the product.
     * @param {string} code - The code of the product.
     * @param {string} description - The description of the product.
     * @param {number} value - The value of the product.
     * @param {Date} created_at - The created_at of the product.
     * @param {Date} updated_at - The updated_at of the product.
     */
    constructor(id: string, name: string, code: string, description: string, value: number, created_at: Date, updated_at: Date){
        this._id = id
        this._name = name;
        this._code = code;
        this._description = description;
        this._value = value;
        this._created_at = created_at;
        this._updated_at = updated_at;
    }

    /**Getters */
    public get id() : string {
        return this._id
    }
    
    public get name() : string {
        return this._name
    }
    
    public get code() : string {
        return this._code
    }

    public get description() : string {
        return this._description 
    }
    
    public get value() : number {
        return this._value 
    }

    public get created_at() : Date {
        return this._created_at 
    }
    public get updated_at() : Date {
        return this._updated_at 
    }
}
