/**
 *
 *  @author Batorski Bartłomiej PD2654
 *
 */

package zad2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MyPropertyChangeListener implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Change value of: "+ evt.getPropertyName() + " from: " + evt.getOldValue() + " to: " + evt.getNewValue());
    }
}
