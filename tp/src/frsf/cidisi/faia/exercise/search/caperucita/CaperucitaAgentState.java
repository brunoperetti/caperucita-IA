package frsf.cidisi.faia.exercise.search.caperucita;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;


public class CaperucitaAgentState extends SearchBasedAgentState {

	
	private int[] posicionActual;
	private int[] posicionInicial;
    private int cantDulcesRecolectados;
   

	private int vidasRestantes;
	private int[][] mapa;
	private int celdasVisitadas;

	
	
	public CaperucitaAgentState(int[][] m, int filAct, int colAct, int filIni, int colIni, int dulces, int vidas, int celdas) {
        mapa = m;
        posicionActual = new int[2];
        posicionActual[0] = filAct;
        posicionActual[1] = colAct;
        posicionInicial = new int[2];
        posicionInicial[0] = filIni;
        posicionInicial[1] = colIni;
        cantDulcesRecolectados = dulces;
        vidasRestantes = vidas;
        celdasVisitadas = celdas;
    }
	
	public CaperucitaAgentState() { //constructor
		posicionActual = new int[2];
		posicionInicial = new int[2];
        cantDulcesRecolectados = 0;
        vidasRestantes = 3;
        mapa = new int[9][14];
        this.initState();
    }
	
	@Override
	public boolean equals(Object obj) { //ojo, está hecho analogamente como el del pacman

		if (!(obj instanceof CaperucitaAgentState))
            return false;

        int[][] mapaObj = ((CaperucitaAgentState) obj).getMapa();
        int[] positionObj = ((CaperucitaAgentState) obj).getPosicionActual();
        int[] positionIniObj = ((CaperucitaAgentState) obj).getPosicionInicial();
        int dulcesObj =  ((CaperucitaAgentState) obj).getCantDulcesRecolectados();
        int vidasObj = ((CaperucitaAgentState) obj).getVidasRestantes();
        int celdasObj =  ((CaperucitaAgentState) obj).getCeldasVisitadas();

        for (int row = 0; row < mapa.length; row++) {
            for (int col = 0; col < mapa[0].length; col++) {
                if (mapa[row][col] != mapaObj[row][col]) {
                    return false;
                }
            }
        }

        if (posicionActual[0] != positionObj[0] || posicionActual[1] != positionObj[1]) {
            return false;
        }
        
        if (posicionInicial[0] != positionIniObj[0] || posicionInicial[1] != positionIniObj[1]) {
            return false;
        }
        
        if (cantDulcesRecolectados != dulcesObj ) {
            return false;
        }
        
        if (vidasRestantes != vidasObj ) {
            return false;
        }
        
        if (celdasVisitadas != celdasObj) {
        	return false;
        }
                
        return true;
		

	}

	@Override
	public SearchBasedAgentState clone() {
		int[][] nuevoMapa = new int[9][14];

        for (int row = 0; row < mapa.length; row++) {
            for (int col = 0; col < mapa[0].length; col++) {
            	nuevoMapa[row][col] = mapa[row][col];
            }
        }

        int[] nuevaPosicionActual = new int[2];
        nuevaPosicionActual[0] = posicionActual[0];
        nuevaPosicionActual[1] = posicionActual[1];
        
        int[] nuevaPosicionInicial = new int[2];
        nuevaPosicionInicial[0] = posicionInicial[0];
        nuevaPosicionInicial[1] = posicionInicial[1];

        CaperucitaAgentState nuevoEstado = new CaperucitaAgentState(nuevoMapa,
        		nuevaPosicionActual[0], nuevaPosicionActual[1], nuevaPosicionInicial[0], nuevaPosicionInicial[1],
        		this.cantDulcesRecolectados, this.vidasRestantes, this.celdasVisitadas);

        return nuevoEstado;
	}

	@Override
	public void updateState(Perception p) {
		
		//actualizar mapa del agente acá
	
		CaperucitaPerception caperucitaPerception = (CaperucitaPerception) p;		
		
		int fil = this.getPosicionFila();
	    int col = this.getPosicionColumna();
		
		/*mapa[fil][col] = caperucitaPerception.getSensorIzquierda();
		mapa[fil][col] = caperucitaPerception.getSensorDerecha();
		mapa[fil][col] = caperucitaPerception.getSensorAbajo();
		mapa[fil][col] = caperucitaPerception.getSensorArriba();*/
		
		//for para cada asignacion, ojo con la ubicacion de las celdas, segun mapa de bruno
		
	    
	 
	    
	    // ---- ACTUALIZAR MAPA DEL AGENTE ----
	    
	    //actualiza mapa segun percepción detectarArriba
		int posArr=0;
	    for (int i=fil-1;i>=0;i--) {
		mapa[i][col] = caperucitaPerception.getSensorArriba()[posArr];
		posArr++;
		}
		
		//actualiza mapa segun percepción detectarAbajo
		int posAba=0;
		for (int i=fil+1;i<=8;i++) {
			mapa[i][col] = caperucitaPerception.getSensorAbajo()[posAba];
			posAba++;
		}
		
		//actualiza mapa segun percepción detectarDerecha
		int posDer=0;
		for (int j=col+1;j<=13;j++) {
			mapa[fil][j] = caperucitaPerception.getSensorDerecha()[posDer];
			posDer++;
		}
		
		//actualiza mapa segun percepción detectarIzq
		int posIzq=0;
		for (int j=col-1;j>=0;j--) {
			mapa[fil][j] = caperucitaPerception.getSensorIzquierda()[posIzq];
			posIzq++;
		}
		
		
		
		
		
	}

	@Override
	public String toString() {
			
		String str = "";

        str = str + " Posicion=(" + getPosicionFila() + "," + "" + getPosicionColumna() + ")";
        str = str + " -- Dulces: " + cantDulcesRecolectados + "";
        str = str + " -- Vidas: " + vidasRestantes + "\n";

        str = str + "Mapa del agente=[ \n";
        for (int row = 0; row < mapa.length; row++) {
            str = str + "[ ";
            for (int col = 0; col < mapa[0].length; col++) {
                if (mapa[row][col] == -1) {
                    str = str + "* ";
                } else {
                    str = str + mapa[row][col] + " ";
                }
            }
            str = str + " ]\n";
        }
        str = str + " ]";

        return str;
		
	}

	@Override
	public void initState() {		
		//Situación inicial de caperucita
		
		for (int fil = 0; fil < mapa.length; fil++) {
            for (int col = 0; col < mapa[0].length; col++) {
                mapa[fil][col] = CaperucitaPerception.DESCONOCIDO_PERCEPTION;
            }
        }
		
		//Se setean las flores
		mapa[7][7] = CaperucitaPerception.FLORES_PERCEPTION;
        mapa[8][7] = CaperucitaPerception.FLORES_PERCEPTION;
             
		
        this.setPosicionFila(5);
        this.setPosicionColumna(8);

        this.setDulcesRecolectados(0);
        this.setVidasRestantes(3);
		
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
    
    public void setDulcesRecolectados (int value) {
    	this.cantDulcesRecolectados = value;
    }
    
    public void setVidasRestantes (int value) {
    	this.vidasRestantes = value;
    }
    
    public int getCantDulcesRecolectados() {
		return cantDulcesRecolectados;
	}

	public void setCantDulcesRecolectados(int cantDulcesRecolectados) {
		this.cantDulcesRecolectados = cantDulcesRecolectados;
	}

	public int getCeldasVisitadas() {
        return celdasVisitadas;
    }
	public int getVidasRestantes() {
		return vidasRestantes;
	}
    
    
    public int[][] getMapa() {
        return mapa;
    }
    
    public int getPosicionMapa(int row, int col) {
        return mapa[row][col];
    }
    
    public int [] getPosicionActual () {
    	return posicionActual;
    }
    
    public int[] getPosicionInicial () {
    	return posicionInicial;
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
    
    public boolean estaEnCampoDeFlores() {

    	int fil = getPosicionFila();
    	int col = getPosicionColumna();
    	
    	if (mapa [fil][col] == CaperucitaPerception.FLORES_PERCEPTION) {
    		return true;
    	}
    	return false;
    }

	
}
