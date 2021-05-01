package frsf.cidisi.faia.exercise.search.caperucita.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.exercise.search.caperucita.CaperucitaAgentState;
import frsf.cidisi.faia.exercise.search.caperucita.CaperucitaEnvironmentState;
import frsf.cidisi.faia.exercise.search.caperucita.CaperucitaPerception;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class MoverseArriba extends SearchAction {

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
			
		
		CaperucitaAgentState caperucitaState = (CaperucitaAgentState) s;

        int fil = caperucitaState.getPosicionFila();
        int col = caperucitaState.getPosicionColumna();
		
        int i=1;
        boolean flag= false;
        
         while (caperucitaState.getPosicionMapa(fil-i,col)!=CaperucitaPerception.ARBOL_PERCEPTION  && ((fil-i)>0)) {
        	//mientras la celda de arriba no sea arbol
        	caperucitaState.setPosicionFila(fil-i);
        	caperucitaState.sumarCeldaVisitada();
        	
        	flag=true;
        	
        	if(caperucitaState.getMapa()[fil-i][col] == CaperucitaPerception.LOBO_PERCEPTION) {
        		caperucitaState.restarVida();
        	}
        	
        	if(caperucitaState.getMapa()[fil-i][col] == CaperucitaPerception.DULCE_PERCEPTION) {
        		caperucitaState.sumarDulceRecolectado();
        		caperucitaState.restarCosto();
        		caperucitaState.getMapa()[fil-i][col] = CaperucitaPerception.VACIO_PERCEPTION;        		
        	}
        
        	i++;
        }

        if (flag==true) {
        	
        	return caperucitaState;
        }
        else return null;       	
        
	}

	@Override
	public Double getCost() {
		return new Double(1);
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {

		
		CaperucitaEnvironmentState environmentState = (CaperucitaEnvironmentState) est;
		CaperucitaAgentState caperucitaAgentState = ((CaperucitaAgentState) ast);
		
		int fil = environmentState.getPosicionCaperucita()[0];
		int col = environmentState.getPosicionCaperucita()[1];
		
		int i=1;
		boolean flag = false;
		
		while (environmentState.getPosicionMapaCaperucita(fil-i,col)!=CaperucitaPerception.ARBOL_PERCEPTION && ((fil-i)>=0)) {
        	//mientras la celda de arriba no sea arbol
			environmentState.setPosicionFilaCaperucita(fil-i);
			caperucitaAgentState.sumarCeldaVisitada();
        	caperucitaAgentState.setPosicionFila(fil-i); //esto No sabemos si va, porque ya está en el otro execute.
        	environmentState.sumarCeldaVisitada();
        	
        	flag=true;
        	
        	if(environmentState.getMapa()[fil-i][col] == CaperucitaPerception.LOBO_PERCEPTION) {
        		caperucitaAgentState.restarVida();
        		environmentState.restarVidaAgente();
        		
        	}
        	
           	if(environmentState.getMapa()[fil-i][col] == CaperucitaPerception.DULCE_PERCEPTION) {
        		environmentState.sumarDulceRecolectado();
        		caperucitaAgentState.restarCosto();
        		environmentState.getMapa()[fil-i][col] = CaperucitaPerception.VACIO_PERCEPTION;        		
        	}
           	i++;
           	
        }

        if (flag=true) {
        	//environmentState.moverLobo();
        	return environmentState;
        	
        	
        }
        else return null;      
		
	}

	@Override
    public String toString() {
        return "MoverseArriba";
    }

}
