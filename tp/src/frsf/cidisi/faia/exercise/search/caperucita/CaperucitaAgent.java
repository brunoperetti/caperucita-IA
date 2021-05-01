package frsf.cidisi.faia.exercise.search.caperucita;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.exercise.search.caperucita.actions.MoverseAbajo;
import frsf.cidisi.faia.exercise.search.caperucita.actions.MoverseArriba;
import frsf.cidisi.faia.exercise.search.caperucita.actions.MoverseDerecha;
import frsf.cidisi.faia.exercise.search.caperucita.actions.MoverseIzquierda;
import frsf.cidisi.faia.exercise.search.caperucita.actions.ReiniciarPartida;
import frsf.cidisi.faia.exercise.search.caperucita.actions.TomarDulce;
import frsf.cidisi.faia.solver.search.BreathFirstSearch;
import frsf.cidisi.faia.solver.search.DepthFirstSearch;
import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.Search;
import frsf.cidisi.faia.solver.search.UniformCostSearch;

public class CaperucitaAgent extends SearchBasedAgent{
	
	public CaperucitaAgent() { //constructor de agente caperucita

        // Meta de caperucita
        CaperucitaGoal goal = new CaperucitaGoal();

        // Estado de agente caperucita
        CaperucitaAgentState caperucitaState = new CaperucitaAgentState();
        this.setAgentState(caperucitaState);

        // Creaci�n de operadores
        Vector<SearchAction> operators = new Vector<SearchAction>();
        
       // operators.addElement(new TomarDulce());
        operators.addElement(new MoverseArriba());
        operators.addElement(new MoverseAbajo());
        operators.addElement(new MoverseDerecha());
        operators.addElement(new MoverseIzquierda());
        


        // Crear el problema que va a resolver caperucita
        Problem problem = new Problem(goal, caperucitaState, operators);
        this.setProblem(problem);
    }

	@Override
	public void see(Perception p) {
		this.getAgentState().updateState(p);
	}

	@Override
	public Action selectAction() {
		//Create the search strategy
			//DepthFirstSearch strategy = new DepthFirstSearch();

		
	     IStepCostFunction costFunction = new CostFunction();
	     UniformCostSearch strategy = new UniformCostSearch(costFunction);
		
	         
	      //BreathFirstSearch strategy = new BreathFirstSearch();
        /**
         * Another search strategy examples:
         * 
         * Depth First Search:
         * DepthFirstSearch strategy = new DepthFirstSearch();
         * 
         * Breath First Search:
         * BreathFirstSearch strategy = new BreathFirstSearch();
         * 
         * Uniform Cost:
         * IStepCostFunction costFunction = new CostFunction();
         * UniformCostSearch strategy = new UniformCostSearch(costFunction);
         * 
         * A Star Search:
         * IStepCostFunction cost = new CostFunction();
         * IEstimatedCostFunction heuristic = new Heuristic();
         * AStarSearch strategy = new AStarSearch(cost, heuristic);
         * 
         * Greedy Search:
         * IEstimatedCostFunction heuristic = new Heuristic();
         * GreedySearch strategy = new GreedySearch(heuristic);
         */

        // Create a Search object with the strategy
        Search searchSolver = new Search(strategy);

        /* Generate an XML file with the search tree. It can also be generated
         * in other formats like PDF with PDF_TREE */
        searchSolver.setVisibleTree(Search.XML_TREE);

        // Set the Search searchSolver.
        this.setSolver(searchSolver);

        // Ask the solver for the best action
        Action selectedAction = null;
        try {
            selectedAction =
                    this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(CaperucitaAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Return the selected action
        return selectedAction;
        
        
	}
	
	
		
	    

}