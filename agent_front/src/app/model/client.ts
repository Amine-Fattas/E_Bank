import { Compte } from './Compte';

export class Client{

    public id:number;
    public nom:string="";
    public prenom:string="";
    public cin:string="";
    public email:string="";
    public sexe:string="";
    public numTel:number;
    public dateNaissance:Date;
    public compte:Compte;
 
    constructor(){}
 }


	