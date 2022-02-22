package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }


    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void addVoisinFavorisWithSuccess(){
        Neighbour neighbourFavoris = service.getNeighbours().get(0);
        assertFalse(service.getFavorisNeihgbours().contains(neighbourFavoris));
        service.addVoisinFavoris(neighbourFavoris);
        assertTrue(service.getFavorisNeihgbours().contains(neighbourFavoris));
    }

    @Test
    public  void removeFromeFavorisWithSuccess(){
        Neighbour deleteFavoris = service.getNeighbours().get(0);
        assertFalse(service.getFavorisNeihgbours().contains(deleteFavoris));
        service.addVoisinFavoris(deleteFavoris);
        assertTrue(service.getFavorisNeihgbours().contains(deleteFavoris));
        service.removeFromeFavoris(deleteFavoris);
        assertFalse(service.getFavorisNeihgbours().contains(deleteFavoris));
    }

    @Test
    public void getFavorisNeihgboursWithSuccess(){
        assertTrue(service.getFavorisNeihgbours().size()==0);
        Neighbour neighbourFavoris = service.getNeighbours().get(0);
        service.addVoisinFavoris(neighbourFavoris);
        assertTrue(service.getFavorisNeihgbours().size()==1);
    }

    @Test
    public void IsFavorisWithSuccess(){
        Neighbour neighbour = service.getNeighbours().get(0);
        assertFalse(service.IsFavoris(neighbour));
        service.addVoisinFavoris(neighbour);
        assertTrue(service.IsFavoris(neighbour));
    }
}
