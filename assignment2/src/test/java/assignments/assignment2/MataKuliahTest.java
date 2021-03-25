package assignments.assignment2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MataKuliahTest {
    
    @Test
    public void testToString() {
        MataKuliah matakuliah = new MataKuliah("CS", "DDP2", 4, 10);
        assertEquals("DDP2", matakuliah.toString());
    }

}
