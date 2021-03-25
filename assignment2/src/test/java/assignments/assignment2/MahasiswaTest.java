package assignments.assignment2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MahasiswaTest {
    
    @Test
    public void testToString() {
        Mahasiswa mahasiswa = new Mahasiswa("Ryaas", 20022808200017L);
        assertEquals("Ryaas", mahasiswa.toString());
    }

}
