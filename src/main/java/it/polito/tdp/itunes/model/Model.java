package it.polito.tdp.itunes.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.itunes.db.ItunesDAO;

public class Model {
	
	ItunesDAO dao ;
	Graph<Track,DefaultWeightedEdge> grafo;
	Map<Integer,Track> idMap = new HashMap<>();
	
	public Model() {
		dao = new ItunesDAO();
		this.dao.getAllTracks(idMap);
	}


	public List<Genre> getAllGenres(){
		return this.dao.getAllGenres();
	}
	
	public void creaGrafo(Genre g)
	{
		grafo = new SimpleWeightedGraph<Track,DefaultWeightedEdge>(DefaultWeightedEdge.class);
		Graphs.addAllVertices(this.grafo, this.dao.getVertici(g));
		
		for(Adiacenze a : this.dao.getAdiacenze(g, idMap))
		{
			Graphs.addEdgeWithVertices(this.grafo, a.getT1(), a.getT2(),a.getPeso());
		}
	}
	
	public int getNVertici()
	{
		return this.grafo.vertexSet().size();
	}
	
	public int getNArchi()
	{
		return this.grafo.edgeSet().size();
	}
	
	public List<Adiacenze> getDurataMax(Genre g)
	{
		List<Adiacenze> TrackMaxDurata =new LinkedList<Adiacenze>();
		double durataMax = this.dao.getDurataMax(g, idMap);
		
		for(Track t:this.grafo.vertexSet())
		{
			for(DefaultWeightedEdge dwe : this.grafo.edgesOf(t))
			{
				if(this.grafo.getEdgeWeight(dwe)==durataMax)
				{
					Adiacenze a =new Adiacenze(this.grafo.getEdgeSource(dwe), this.grafo.getEdgeTarget(dwe),this.grafo.getEdgeWeight(dwe));
					TrackMaxDurata.add(a);
				}
			}
		}
		return TrackMaxDurata;
		
	}
	public List<Track> getVertici(){
		return new ArrayList<>(this.grafo.vertexSet());
	}
	
	public boolean grafoCreato()
	{
		if(this.grafo ==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
