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
	
	//MÉTODOS PARA OBTENER LAS CELDAS DEL AMBIENTE
	
	public int[] getCeldasArriba (int fil, int col) {
		//TODO
		int arrayEjemplo[] = null;
		return arrayEjemplo;
    }
	
	public int[] getCeldasAbajo (int fil, int col) {
		int arrayEjemplo[] = null;
		return arrayEjemplo;
    }
	
	public int[] getCeldasDerecha (int fil, int col) {
		int arrayEjemplo[] = null;
		return arrayEjemplo;
    }
	
	public int[] getCeldasIzquierda (int fil, int col) {
		int arrayEjemplo[] = null;
		return arrayEjemplo;
    }



}
