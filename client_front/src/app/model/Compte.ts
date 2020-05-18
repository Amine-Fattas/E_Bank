import { Agent } from './Agent';
import { Client } from './client';

export class Compte{
	typeCompte: string="CC"
	numCompte: number;
	 rib: string="";
	 dateCreation: Date;
	 solde: number=0;
	 etat: boolean=true;
	 fraisOuverture: number=0;
	 client: Client=null;
     agent: Agent=null;
     
     constructor(){}
}
