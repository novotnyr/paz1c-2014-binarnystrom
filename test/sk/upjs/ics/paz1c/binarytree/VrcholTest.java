package sk.upjs.ics.paz1c.binarytree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VrcholTest {
    private Vrchol strom;
    
    @Before
    public void setUp() {
         strom = new Vrchol(
                "+", new Vrchol("-", new
                            Vrchol("7"), new Vrchol("1")), 
                     new Vrchol("3"));
    }
    
    @Test
    public void testStdoutVisitor() {
        Visitor visitor = new Visitor() {
            @Override
            public void visit(Vrchol vrchol) {
                System.out.println("Vrchol: " + vrchol.getHodnota());
            }
        };
        
        strom.vypisDoHlbky(visitor);
    }

    @Test
    public void testPocitacMinusiekVisitor() {
        final int[] obalovacIntu = new int[1];
        
        Visitor pocitacPlusiek = new Visitor() {
            @Override
            public void visit(Vrchol vrchol) {
                if(vrchol.getHodnota().equals("-")) {
                    obalovacIntu[0]++;                            
                }
            }
        };
        strom.vypisDoHlbky(pocitacPlusiek);
        Assert.assertEquals(2, obalovacIntu[0]);
    }

    @Test
    public void testInlineDeklaracia() {
        strom.vypisDoHlbky(new Visitor() {
            @Override
            public void visit(Vrchol vrchol) {
                System.out.println("Ping!");
            }
        });
    }
    
}
