package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GT4500Test {

    private GT4500 ship;

    @BeforeEach
    public void init() {
        this.ship = new GT4500();
    }

    @Test
    void fireTorpedo_Single_Success() {
        // Arrange

        // Act
        boolean result = ship.fireTorpedo(FiringMode.SINGLE);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void fireTorpedo_All_Success() {
        // Arrange

        // Act
        boolean result = ship.fireTorpedo(FiringMode.ALL);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void checkAlternation()
    {
        boolean firstFireResult = ship.fireTorpedo(FiringMode.SINGLE);

        assertTrue(firstFireResult, "Expected first firing to be successful");

        boolean secondFireResult = ship.fireTorpedo(FiringMode.SINGLE);

        assertTrue(secondFireResult, "Expected second firing to be successful");
    }

    @Test
    public void testFireTorpedoAllMode_BothStoresLoaded() {
    GT4500 ship = new GT4500();

    boolean result = ship.fireTorpedo(FiringMode.ALL);

    assertTrue(result, "Expected firing to be successful in ALL mode when both stores are loaded");
    }

    @Test
    public void testFireTorpedoAllModeWithOnlyPrimaryLoaded() {
    GT4500 ship = new GT4500();

    boolean result = ship.fireTorpedo(FiringMode.ALL);

    assertTrue(result, "Expected firing to be successful in ALL mode even if only PRIMARY store is loaded");
    }

    
}
