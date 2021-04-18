package frsf.cidisi.faia.exercise.search.caperucita;

import frsf.cidisi.faia.state.EnvironmentState;

public class CaperucitaEnvironmentState extends EnvironmentState {

	private int[][] mapa;
    private int[] posicionCaperucita;
    private int[] posicionDulces;
    private int[] posicionLobo;
    private int[] posicionFlores;
    private int[] posicionArboles;
	
    public CaperucitaEnvironmentState() {
    	mapa = new int[8][13];
        this.initState();
    }
    
    
	@Override
	public void initState() {
		// TODO inicializar la matriz 
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int[] getPosicionCaperucita() {
        return posicionCaperucita;
    }
	
	public void setPosicionMapa(int fil, int col, int value) {
        this.mapa[fil][col] = value;
    }
	
	public int[][] getMapa() {
        return mapa;
    }

}
