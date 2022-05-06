package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {
  private TorpedoStore primary; 
  private TorpedoStore secondary; 

  private GT4500 ship;

  @BeforeEach
  public void init(){
    primary = mock(TorpedoStore.class); 
    secondary = mock(TorpedoStore.class); 
    this.ship = new GT4500(primary, secondary); 
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(primary.isEmpty()).thenReturn(false); 
    when(primary.fire(1)).thenReturn(true); 
   
    // Act
    //boolean result = ship.fireTorpedo(FiringMode.SINGLE);
   ship.fireTorpedo(FiringMode.SINGLE); 
   
    // Assert
    //assertEquals(true, result);
    verify(primary, times(1)).fire(1); 
    verify(primary, times(1)).isEmpty(); 
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(primary.isEmpty()).thenReturn(false); 
    when(primary.fire(1)).thenReturn(true); 
    when(secondary.isEmpty()).thenReturn(false); 
    when(secondary.fire(1)).thenReturn(true); 

    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    //when(pr)

    // Assert
    //assertEquals(true, result);
    verify(primary, times(1)).isEmpty(); 
    verify(primary, times(1)).fire(1); 
    verify(secondary, times(1)).isEmpty(); 
    verify(secondary, times(1)).fire(1); 

  }
}
