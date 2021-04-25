package frsf.cidisi.faia.exercise.search.caperucita;

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
	public Perception getPercept() {
		
		CaperucitaPerception perception = new CaperucitaPerception();

        int fil = this.getEnvironmentState().getPosicionCaperucita()[0];
        int col = this.getEnvironmentState().getPosicionCaperucita()[1];

        perception.setSensorArriba(this.getCeldasArriba(fil, col));
        perception.setSensorIzquierda(this.getCeldasDerecha(fil, col));
        perception.setSensorDerecha(this.getCeldasIzquierda(fil, col));
        perception.setSensorAbajo(this.getCeldasAbajo(fil, col));
        
        return perception;

	}
	
	//M�TODOS PARA OBTENER LAS CELDAS DEL AMBIENTE
		
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
