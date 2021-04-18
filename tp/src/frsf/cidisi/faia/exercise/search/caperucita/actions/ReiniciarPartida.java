package frsf.cidisi.faia.exercise.search.caperucita.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.exercise.search.caperucita.CaperucitaAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class ReiniciarPartida extends SearchAction {

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {

		CaperucitaAgentState caperucitaState = (CaperucitaAgentState) s;
		
		int fil = caperucitaState.getPosicionFila();
        int col = caperucitaState.getPosicionColumna();
		
		if (caperucitaState.hayLoboEnPosicion(fil, col)){
		
			if (caperucitaState.tieneVidas()) {
				
				caperucitaState.reiniciarPartida();

			}
			
			else //termina el juego
				return null;
				
				
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
