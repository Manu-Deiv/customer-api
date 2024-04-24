
/**
 * Class representing a DTO (Data Transfer Object) for response a product.
 */
export class ResponseProductDto {

    // Private properties representing the product attributes
    private _name: string;
    private _description: string;
    private _code: string;
    private _value: number;

    /**
     * Constructor of the ResponseProductDto class.
     * @param {string} name - The name of the product.
     * @param {string} description - The description of the product.
     * @param {string} code - The code of the product.
     * @param {number} value - The value of the product.
     */
    constructor(name: string, code: string, description: string, value: number){
        this._name = name;
        this._code = code;
        this._description = description;
        this._value = value;
    }

    /**Getters */
    public get name() : string {
        return this._name
    }

    public get description() : string {
        return this._description 
    }
    
    public get code() : string {
        return this._code
    }
    
    public get value() : number {
        return this._value 
    }
}
