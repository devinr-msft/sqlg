package org.umlg.sqlg.test.tp3.structure;

import com.tinkerpop.gremlin.structure.StructureStandardSuite;
import org.junit.runner.RunWith;
import org.umlg.sqlg.structure.SqlgGraph;
import org.umlg.sqlg.test.tp3.SqlgPostgresProvider;


/**
 * Executes the Standard Gremlin Structure Test Suite using SqlG.
 */
@RunWith(StructureStandardSuite.class)
@StructureStandardSuite.GraphProviderClass(provider = SqlgPostgresProvider.class, graph = SqlgGraph.class)
public class SqlgPostgresStructureStandardTest {
}