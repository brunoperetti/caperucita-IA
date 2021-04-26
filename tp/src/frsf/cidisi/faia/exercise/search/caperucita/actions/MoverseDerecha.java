package frsf.cidisi.faia.exercise.search.caperucita.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.exercise.search.caperucita.CaperucitaAgentState;
import frsf.cidisi.faia.exercise.search.caperucita.CaperucitaEnvironmentState;
import frsf.cidisi.faia.exercise.search.caperucita.CaperucitaPerception;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class MoverseDerecha extends SearchAction {

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		CaperucitaAgentState caperucitaState = (CaperucitaAgentState) s;
        int fil = caperucitaState.getPosicionFila();
        int col = caperucitaState.getPosicionColumna();
		
        int j=1;
        boolean flag= false;
        
        while (caperucitaState.getPosicionMapa(fil,col+j)!=CaperucitaPerception.ARBOL_PERCEPTION) {
        	//mientras la celda de derecha no sea arbol
        	caperucitaState.setPosicionColumna(col+j);
        	j++;
        	flag=true;
        }

        if (flag==true) {
        	return caperucitaState;
        }
        else {
        	return null;   
        }
	}

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		
		CaperucitaEnvironmentState environmentState = (CaperucitaEnvironmentState) est;
		CaperucitaAgentState caperucitaAgentState = ((CaperucitaAgentState) ast);
		
		int fil = environmentState.getPosicionCaperucita()[0];
		int col = environmentState.getPosicionCaperucita()[1];
		
		int i=1;
		boolean flag = false;
		
		while (environmentState.getPosicionMapaCaperucita(fil,col+i)!=CaperucitaPerception.ARBOL_PERCEPTION) {
        	//mientras la celda de arriba no sea arbol
			environmentState.setPosicionColumnaCaperucita(col+i);
        	caperucitaAgentState.setPosicionColumna(col+i); //esto No sabemos si va, porque ya está en el otro execute.

        	i++;
        	flag=true;
        }

        if (flag=true) {
        	environmentState.moverLobo();
        	return environmentState;
        	
        	
        }
        else return null;      
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
