package frsf.cidisi.faia.exercise.search.caperucita.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.exercise.search.caperucita.CaperucitaAgentState;
import frsf.cidisi.faia.exercise.search.caperucita.CaperucitaPerception;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class MoverseAbajo extends SearchAction {

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {

		CaperucitaAgentState caperucitaState = (CaperucitaAgentState) s;

        int fil = caperucitaState.getPosicionFila();
        int col = caperucitaState.getPosicionColumna();
		
        int i=1;
        boolean flag= false;
        
        //agregar precond
        
        while (caperucitaState.getPosicionMapa(fil-i,col)!=CaperucitaPerception.ARBOL_PERCEPTION) {
        	//mientras la celda de arriba no sea arbol
        	caperucitaState.setPosicionFila(fil-i);
        	i++;
        	flag=true;
        }

        if (flag=true) {
        	return caperucitaState;
        }
        else return null;       	
		
		
	}

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		// TODO Auto-generated method stub
		
		//AC� VAN LAS PRECOND Y LAS POSTCOND
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
