package frsf.cidisi.faia.exercise.search.caperucita;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class CaperucitaAgentState extends SearchBasedAgentState {

	
	private int[] posicionActual;
	private int[] posicionInicial;
    private int cantDulcesRecolectados;
    private int vidasRestantes;
	private int[][] mapa;

	public CaperucitaAgentState() { //constructor
		posicionActual = new int[2];
		posicionInicial = new int[2];
        cantDulcesRecolectados = 0;
        vidasRestantes = 3;
        mapa = new int[8][13];
        this.initState();
    }
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SearchBasedAgentState clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateState(Perception p) {
		
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initState() {
		// TODO Auto-generated method stub
		
		//cargar situacion inicial
		
	}
	
	public int getPosicionFila() {
        return posicionActual[0];
    }

    public int getPosicionColumna() {
        return posicionActual[1];
    }
    
    public void setPosicionFila(int value) {
    	this.posicionActual[0] = value;
    }
    
    public void setPosicionColumna(int value) {
    	this.posicionActual[1] = value;
    }
    
    public int[][] getMapa() {
        return mapa;
    }
    
    public int getPosicionMapa(int row, int col) {
        return mapa[row][col];
    }
    
    public void setPosicionMapa(int fil, int col, int value) {
        this.mapa[fil][col] = value;
    }
    
    public void sumarDulceRecolectado () {
    	this.cantDulcesRecolectados= this.cantDulcesRecolectados+1;
    }
    
    public boolean hayDulceEnPosicion (int fil, int col) {
		if (mapa[fil][col]==CaperucitaPerception.DULCE_PERCEPTION) {
			return true;
		}
		else return false;
    	
    }
    
    public boolean hayLoboEnPosicion (int fil, int col) {
		if (mapa[fil][col]==CaperucitaPerception.LOBO_PERCEPTION) {
			return true;
		}
		else return false;
    	
    }
    
    public boolean tieneVidas () {
		if (vidasRestantes > 1) {
			return true;
		}
    	
		else return false;
    }
    
    public void reiniciarPartida() {
		/*
		 * descontar vida caperucita
			reiniciar contador de dulces a cero
			volver caperucita a estado inicial 
			volver ambiente a estado inicial

		 */
    	
    	vidasRestantes= vidasRestantes-1;
    	cantDulcesRecolectados = 0;
    	posicionActual = posicionInicial;
    	
    }

}
