import { Agent } from './Agent';
import { Client } from './client';

export class Compte{
    public typeCompte:string;
    public numCompte:number;
	public rib:string;
	public  dateCreation:Date;
	public solde:number;
	public  etat:boolean;
    public fraisOuverture:number;
    public agent:Agent=new Agent();
    public client:Client=new Client();
    
    constructor(){}
    set agentC(value) {
        this.agent = value;
      }

}