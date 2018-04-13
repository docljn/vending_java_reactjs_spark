import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    VendingMachine machine;

    @Before
    public void before(){
        machine = new VendingMachine();
    }

    @Test
    public void startsWithEmptyCoinSlot(){
        assertEquals((Integer)0, machine.getAvailableCredit());
    }

    @Test
    public void startsWithEmptyCoinHopper(){
        assertEquals((Integer)0, machine.getCashCount());
    }

    @Test
    public void startsWithEmptyChangeHopper(){
        assertEquals((Integer)0, machine.getChangeCount());
    }

    @Test
    public void setupFillsChangeHopper(){
        machine.setup();
        assertEquals((Integer)14000, machine.getChangeCount());
    }

    @Test
//    TODO: FAiling
    public void startsWithEmptyDisplayCabinet(){
        assertEquals(0, machine.availableItems().keySet());
    }

    @Ignore
    @Test
    public void setupFillsDisplayCabinet(){
        machine.setup();
        assertEquals(true, true);

    }

}
