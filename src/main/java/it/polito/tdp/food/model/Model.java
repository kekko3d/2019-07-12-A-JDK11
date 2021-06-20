package it.polito.tdp.food.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.db.FoodDao;


public class Model {

	private FoodDao dao;
	private SimpleWeightedGraph <Food, DefaultWeightedEdge> grafo;
	private Map <Integer, Food> idMap;
	private Integer NPIETANZE = 1;
	
	public Model () {
		dao = new FoodDao();
	}
	
	
	public void creaGrafo(Integer num) {
		DefaultWeightedEdge b;
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		idMap = new HashMap <Integer, Food>();
		
		for(Food f : dao.listVertici(num)) {
			idMap.put(f.getFood_code(), f);
			
		}
		
		
		
		Graphs.addAllVertices(grafo, idMap.values());
		
		
		//vetici
	

		for(Adiacenza e : dao.listAdiacenze()) {
			
			if(idMap.containsKey(e.getF1())
					&& idMap.containsKey(e.getF2())){
				
				//questo if e il seguente servono a non aggiungere lo stesso arco più volte
				if(this.grafo.containsVertex(idMap.get(e.getF1())) ||
						this.grafo.containsVertex(idMap.get(e.getF2()))) {


					b = this.grafo.getEdge(idMap.get(e.getF1()), idMap.get(e.getF2()));
					if(b == null) {
						Graphs.addEdgeWithVertices(this.grafo, idMap.get(e.getF1()), idMap.get(e.getF2()), e.getPeso());
					}
				}
			}
		}
		
		System.out.print("Grafo Creato:");
		System.out.println('\n' + "NUMERO VERTEX: "+ grafo.vertexSet().size() );
		System.out.println("NUMERO EDGES: " + grafo.edgeSet().size() );		
		
		
	}
	

	public  List<foodAndCalories> getBestFive(Food cibo) {
		List <foodAndCalories> temp = new LinkedList <foodAndCalories> ();

		for(DefaultWeightedEdge  e : grafo.edgesOf(cibo)) {
			temp.add(new foodAndCalories(Graphs.getOppositeVertex(grafo, e, cibo), grafo.getEdgeWeight(e)));
		}

		Collections.sort(temp, new Comparator<foodAndCalories>() {
			@Override
			public int compare(foodAndCalories o1, foodAndCalories o2) {
				return (int) o2.getCalories() - (int) o1.getCalories();
			}
		});

		List <foodAndCalories> result = new LinkedList <foodAndCalories> (temp.subList(0, 5));

		
		return result;
		
		
	}
	
	public  List<foodAndCalories> getFoodWithMostCalories(Food cibo) {
		List <foodAndCalories> temp = new LinkedList <foodAndCalories> ();

		for(DefaultWeightedEdge  e : grafo.edgesOf(cibo)) {
			temp.add(new foodAndCalories(Graphs.getOppositeVertex(grafo, e, cibo), grafo.getEdgeWeight(e)));
		}

		Collections.sort(temp, new Comparator<foodAndCalories>() {
			@Override
			public int compare(foodAndCalories o1, foodAndCalories o2) {
				return (int) o2.getCalories() - (int) o1.getCalories();
			}
		});


		
		return temp;
		
		
	}


	public List<Food> getVertex() {
		List <Food> foods = new LinkedList <Food> (grafo.vertexSet());
		return foods;
	}
	
	
	public void Init(int k, Food f) {
		Integer TEMP = 0;
		LinkedList <Event> events = new LinkedList <Event> ();
		List <Machine> machines = new LinkedList <Machine> ();
		for(int i = 0; i< k; i++ ) {
			machines.add(new Machine (i, false));
		}
		simulation(TEMP, events, f, machines, k);
	}
	
	
	private void simulation(Integer TEMP, LinkedList<Event> events, Food f, List<Machine> machines, int k) {
		LinkedList <foodAndCalories> listaViciniOrdinata = new LinkedList<foodAndCalories> (getFoodWithMostCalories(f));
		LinkedList <Food> listAllFood =  new LinkedList <Food> (idMap.values());
		//for machines sono finite aggiungi cibo
		foodAndCalories ciboPerProva;
		foodAndCalories cibo =listaViciniOrdinata.getFirst();

		System.out.println(cibo);

		while(TEMP < 2000) {

			for (int c = 0; c < k ; c++) {

				if(TEMP.equals(machines.get(c).getTime())){
					System.out.println("hbugyvuyfgvelp");

					Integer id = machines.get(c).getId();
					machines.get(c).setBusy(false);
					events.add(new Event(id, false, TEMP));
					System.out.println(new Event(id, false, TEMP));
				}
			}
			
			for (int c = 0; c < k ; c++) {
				//se la macchina è libera

				if(!machines.get(c).isBusy()) {


					//partendo dalla lista del cibo fornito prendo a mano
					//a mano tutti i cibi con le calorie più alte 
					//finché non trovo quello che non ho ancora cucinato
					for(int i = 0; i < getFoodWithMostCalories(cibo.getFood()).size(); i++) {

						//se la lista contiene il cibo allora ho trovato il cibo che voglio cucinare
						ciboPerProva = getFoodWithMostCalories(cibo.getFood()).get(i);

						if(listAllFood.contains(ciboPerProva.getFood())){
							listAllFood.remove(ciboPerProva.getFood());
							cibo = ciboPerProva;
							System.out.println("sbjsabjsbjs");
							//prendo il cibo che mi  serve per scegliere 
							//la prossima pietanza da cucinare
							System.out.println(cibo);
							//rimuovo il cibo così sono sicuro di non ricucinarlo
							Integer id = machines.get(c).getId();
							machines.get(c).setBusy(true);
							machines.get(c).setTime(machines.get(c).getTime() + (int) cibo.getCalories());
							NPIETANZE++;
							System.out.println(new Event(id, true, TEMP));
							events.add(new Event(id, true, TEMP));
							break;							
						}

					}

				}
			}
			TEMP++;
			System.out.println(TEMP);


		}

		for(int a = 0; a < events.size(); a++) {
			System.out.println(events.get(a));
			
		}
		System.out.println(NPIETANZE);
		System.out.println(events.getLast().getTim());
		System.out.println(TEMP);


		
	}

	
	
}
