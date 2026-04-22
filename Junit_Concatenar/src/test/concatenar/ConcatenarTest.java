package test.concatenar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.concatenar.Concatenar;
class ConcatenarTest {

	@Test
	void testConcatenarNull() {
		Concatenar cont = new Concatenar();
		
		String resultado = cont.concatenar("a", "a");
				
		assertNotNull(resultado);
	}
	
	@Test
	void testConcatenar() {
		Concatenar cont = new Concatenar();
		
		String resultado = cont.concatenar("a", "b");
				
		assertEquals("ab",resultado);
	}

}
