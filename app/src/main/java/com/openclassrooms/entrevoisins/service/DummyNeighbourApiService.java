package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    private List<Neighbour> favorisNeighbourgs = new ArrayList<>();



    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    @Override
    public List<Neighbour> getFavorisNeihgbours() {
        return favorisNeighbourgs;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) { neighbours.remove(neighbour);
    }

    @Override
    public void removeFromeFavoris(Neighbour neighbour) {

        favorisNeighbourgs.remove(neighbour);

    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    @Override
    public void addVoisinFavoris(Neighbour neighbour) {

        favorisNeighbourgs.add(neighbour);

    }

    @Override
    public boolean IsFavoris(Neighbour neighbour) {
        return neighbours.contains(neighbour);
    }
}
