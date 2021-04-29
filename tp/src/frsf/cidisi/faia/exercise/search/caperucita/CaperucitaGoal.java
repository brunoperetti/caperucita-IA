package frsf.cidisi.faia.exercise.search.caperucita;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class CaperucitaGoal extends GoalTest{

	@Override
	public boolean isGoalState(AgentState agentState) {
		
		if ((((CaperucitaAgentState) agentState).estaEnCampoDeFlores()) && (((CaperucitaAgentState) agentState).tieneVidas())) {
					    
			return true;
        }
		
        return false;


}
	
}
