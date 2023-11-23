package es.uca.mps.matrix;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ MatrixTest.class, OpmatrixTest.class })
public class AllTests {

}
