import { Injectable } from '@angular/core';
import { Subject, Observable, BehaviorSubject } from 'rxjs';
import { Agent } from '../model/Agent';

@Injectable({
  providedIn: 'root'
})
export class AgentService {
 

    /*subject: Subject<any> = new Subject<any>();
    observable: Observable<any> = this.subject.asObservable();*/
    agent:BehaviorSubject<Agent>=new BehaviorSubject<Agent>(new Agent());
    currentAgent:Observable<Agent>=this.agent.asObservable();

  constructor() { }

  changeAgent(ag: Agent){
    this.agent.next(ag)
  }
}
