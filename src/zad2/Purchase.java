/**
 *
 *  @author Batorski Bartłomiej PD2654
 *
 */

package zad2;




import java.beans.*;

public class Purchase {
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private VetoableChangeSupport vetoableChangeSupport = new VetoableChangeSupport(this);

    private String prod;
    private String data;
    private double price;


    public Purchase(String prod, String data, double price) {
        this.prod = prod;
        this.data = data;
        this.price = price;
    }
    public void setData(String data) {
        propertyChangeSupport.firePropertyChange("data", this.data, data);
        this.data = data;
    }

    public void setPrice(double price) throws PropertyVetoException {
        vetoableChangeSupport.fireVetoableChange("price", this.price, price);
        propertyChangeSupport.firePropertyChange("price", this.price, price);
        this.price = price;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    public void addVetoableChangeListener(VetoableChangeListener listener) {
        vetoableChangeSupport.addVetoableChangeListener(listener);
    }
    public void removeVetoableChangeListener(VetoableChangeListener listener) {
        vetoableChangeSupport.removeVetoableChangeListener(listener);
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "prod='" + prod + '\'' +
                ", data='" + data + '\'' +
                ", price=" + price +
                '}';
    }
}
