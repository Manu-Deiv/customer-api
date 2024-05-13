export class Barcode{

    private _code: string

    constructor (code: string){
        if (code.length > 13){
            throw new Error("Code's product above 13 doesn't exist. Please verify.")
        }
        this._code = code
    }

    get code(): string{
        return this._code
    }
    
}