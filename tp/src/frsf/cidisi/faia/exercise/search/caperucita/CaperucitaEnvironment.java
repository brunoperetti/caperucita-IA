package frsf.cidisi.faia.exercise.search.caperucita;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class CaperucitaEnvironment extends Environment {
	
	
	public CaperucitaEnvironment() {
	    // Create the environment state
	    this.environmentState = new CaperucitaEnvironmentState();
	    }
	
	@Override
    public CaperucitaEnvironmentState getEnvironmentState() {
        return (CaperucitaEnvironmentState) super.getEnvironmentState();
    }

	
	@Override
    public boolean agentFailed(Action actionReturned) {

        CaperucitaEnvironmentState caperucitaEnvironmentState =
                this.getEnvironmentState();

        int vidas = caperucitaEnvironmentState.getVidasAgente();

        // FIXME: The pacman agent always has the same energy
        // If the agent has no energy, he failed
        if (vidas <= 0)
            return true;

        return false;
    }
	
	@Override
	public Perception getPercept() {
		
		CaperucitaPerception perception = new CaperucitaPerception();

        int fil = this.getEnvironmentState().getPosicionCaperucita()[0];
        int col = this.getEnvironmentState().getPosicionCaperucita()[1];

        
        // :::: MOVIMIENTO DEL LOBO
        CaperucitaEnvironmentState environmentState = this.getEnvironmentState();
        environmentState.moverLobo();
        
        perception.setSensorArriba(this.getCeldasArriba(fil, col));
        perception.setSensorIzquierda(this.getCeldasIzquierda(fil, col));
        perception.setSensorDerecha(this.getCeldasDerecha(fil, col));
        perception.setSensorAbajo(this.getCeldasAbajo(fil, col));
        
        return perception;

	}
	
	//MÉTODOS PARA OBTENER LAS CELDAS DEL AMBIENTE
		
	public int[] getCeldasAbajo (int fil, int col) {
		return ((CaperucitaEnvironmentState) this.environmentState)
                .getCeldasAbajo(fil, col);
    }
	
	public int[] getCeldasDerecha (int fil, int col) {
		return ((CaperucitaEnvironmentState) this.environmentState)
                .getCeldasDerecha(fil, col);
    }
	
	public int[] getCeldasIzquierda (int fil, int col) {
		return ((CaperucitaEnvironmentState) this.environmentState)
                .getCeldasIzquierda(fil, col);
    }
	
	public int[] getCeldasArriba (int fil, int col) {
		return ((CaperucitaEnvironmentState) this.environmentState)
                .getCeldasArriba(fil, col);
	}
	
	 @Override
	    public String toString() {
	        return environmentState.toString();
	    }



}
