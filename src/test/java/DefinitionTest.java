import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

	@Test
	public void definition_instantiatesCorrectly_true() {
		Definition testDef = new Definition("an instrument");
		assertEquals(true, testDef instanceof Definition);
	}
	
	@Test
	public void word_getsDefinition_correctString() {
		Definition testDef = new Definition("an instrument");
		assertEquals("an instrument", testDef.getDef());
	}

	@Test
	public void all_returnsAllInstancesOfDefinition_true() {
		Definition def1 = new Definition("an instrument");
		Definition def2 = new Definition("a musical instrument");
		assertTrue(Definition.all().contains(def1));
		assertTrue(Definition.all().contains(def2));
	}

	@Test
	public void newId_defsInstantiateWithAnID_true() {
		Definition testDef = new Definition("an instrument");
		assertEquals(Definition.all().size(), testDef.getId());
	}

	@Test
	public void find_returnsDefWithSameId_def2() {
		Definition def1 = new Definition("an instrument");
		Definition def2 = new Definition("a musical instrument");
		assertTrue(Definition.all().contains(def1));
		assertTrue(Definition.all().contains(def2));
	}

	@Test
	public void find_returnsNullWhenNoDefinitionFound_null() {
		assertTrue(Definition.find(999) == null);
	}

	@Test
	public void clear_emptiesAllDefsFromArrayList() {
		Definition def1 = new Definition("an instrument");
		Definition.clear();
		assertEquals(Definition.all().size(), 0);
	}
}
