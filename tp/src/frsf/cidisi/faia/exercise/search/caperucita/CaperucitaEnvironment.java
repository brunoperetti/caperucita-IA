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
	
	public int[] getCeldasArriba (int fil, int col, CaperucitaEnvironmentState environmentState) {

		//int mapa[][] = this.getMapa();
		int arrayValoresArriba[] = null;
		int j=0;
		
		for (int i=fil-1;i>=0;i--) {
			arrayValoresArriba[j] = environmentState.getMapa()[i][col];
			j++;
		}
		
		return arrayValoresArriba;
		
		//Retorna los valores de las celdas de arriba de la posicion pasada como parametro. 
		//La posicion 0 del arrayValoresArriba representa el valor de la posicion mas cernana hacia arriba
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
	
	public int[] getCeldasArriba (int fil, int col) {
	return null; //todo
	}
	
	 @Override
	    public String toString() {
	        return environmentState.toString();
	    }



}
