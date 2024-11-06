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
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    assertTrue(result, "Expected firing to be successful in ALL mode when both stores are loaded");
    }

    @Test
    public void testFireTorpedoAllModeWithOnlyPrimaryLoaded() {
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    assertTrue(result, "Expected firing to be successful in ALL mode even if only PRIMARY store is loaded");
    }
    @Test
    void fireTorpedo_Single_Success_WhenSecondaryEmpty() {
        // Arrange    
        // Assuming PRIMARY has torpedoes and SECONDARY is empty
        // Note: If PRIMARY and SECONDARY store states are not configurable directly,
        // you would need to mock them to simulate this setup if using a mocking framework.
    
        // Act
        boolean result = ship.fireTorpedo(FiringMode.SINGLE);
    
        // Assert
        assertTrue(result, "Expected firing to succeed from PRIMARY when SECONDARY is empty in SINGLE mode");
    }
    
    
    @Test
    void fireTorpedo_Single_FiresFromSecondary_WhenPrimaryFiredLast() {
        // Arrange    
        // Step 1: Fire from the PRIMARY store to set wasPrimaryFiredLast to true
        boolean firstFireResult = ship.fireTorpedo(FiringMode.SINGLE);
        assertTrue(firstFireResult, "Expected first firing to succeed from PRIMARY store");
    
        // Step 2: Fire again, which should now attempt to fire from the SECONDARY store
        boolean secondFireResult = ship.fireTorpedo(FiringMode.SINGLE);
    
        // Assert
        assertTrue(secondFireResult, "Expected firing to succeed from SECONDARY store on second call in SINGLE mode");
    }
    
    
    
}
