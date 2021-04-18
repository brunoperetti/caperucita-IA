package frsf.cidisi.faia.exercise.search.caperucita.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.exercise.search.caperucita.CaperucitaAgentState;
import frsf.cidisi.faia.exercise.search.caperucita.CaperucitaEnvironmentState;
import frsf.cidisi.faia.exercise.search.caperucita.CaperucitaPerception;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class TomarDulce extends SearchAction {

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {

		CaperucitaAgentState caperucitaState = (CaperucitaAgentState) s;

        int fil = caperucitaState.getPosicionFila();
        int col = caperucitaState.getPosicionColumna();

        // si hay dulce, lo toma, sino, retorna null //
        if (caperucitaState.hayDulceEnPosicion(fil,col)) {
            // si toma el dulce, entonces seteamos esa posicion del mapa en vacio
        	
        	caperucitaState.sumarDulceRecolectado();
        	caperucitaState.setPosicionMapa(fil, col, CaperucitaPerception.VACIO_PERCEPTION);
        	
            return caperucitaState;
        }
        
        return null;
		
	}

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		CaperucitaEnvironmentState environmentState = (CaperucitaEnvironmentState) est;
        CaperucitaAgentState caperucitaState = ((CaperucitaAgentState) ast);

        int fil = environmentState.getPosicionCaperucita()[0];
        int col = environmentState.getPosicionCaperucita()[1];

        if (environmentState.getMapa()[fil][col] == CaperucitaPerception.DULCE_PERCEPTION) {
            // Actualizar mapa del ambiente.
            environmentState.setPosicionMapa(fil, col, CaperucitaPerception.VACIO_PERCEPTION);

            // Activalizar estado del agente. ¿¿POR QUE?? ¿no lo hace el otro execute??
     /*????*/  caperucitaState.setPosicionMapa(fil, col, CaperucitaPerception.VACIO_PERCEPTION);//???????
            
            return environmentState;
        }

        return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
