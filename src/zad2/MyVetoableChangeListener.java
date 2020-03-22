/**
 *
 *  @author Batorski Bartłomiej PD2654
 *
 */


package zad2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class MyVetoableChangeListener implements VetoableChangeListener {
    private static final double MIN_PRICE = 1000;

    @Override
    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
        double newValue = (double)evt.getNewValue();
        if( newValue < MIN_PRICE) {
            throw new PropertyVetoException("Price change to: " + newValue + " not allowed", evt);
        }
    }
}
