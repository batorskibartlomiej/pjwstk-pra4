/**
 *
 *  @author Batorski Bartłomiej PD2654
 *
 */

package zad1;



import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;

public class Calc {
    private HashMap<String, Method> methods = new HashMap<String, Method>();
    private MathContext mc = new MathContext(7);

    public Calc() {
        try {
            Class bigDecimalClass = Class.forName("java.math.BigDecimal");
            Method method = bigDecimalClass.getMethod("add", BigDecimal.class);
            methods.put("+", method);
            method = bigDecimalClass.getMethod("subtract", BigDecimal.class);
            methods.put("-", method);
            method = bigDecimalClass.getMethod("multiply", BigDecimal.class);
            methods.put("*", method);
            method = bigDecimalClass.getMethod("divide", BigDecimal.class, MathContext.class);
            methods.put("/", method);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public String doCalc(String arg) {
        String[] items = arg.split("\\s+");
        String operation = items[1];
        String leftArg = items[0];
        String rightArg = items[2];

        BigDecimal arg1 = null;
        BigDecimal arg2 = null;
        Method method = null;
        BigDecimal result = null;
        try {
            arg1 = new BigDecimal(leftArg);
            arg2 = new BigDecimal(rightArg);
            method = methods.get(operation);
            result = (BigDecimal) method.invoke(arg1, arg2);
            return result.toString();
        } catch (IllegalArgumentException e) {
            try {
                result = (BigDecimal) method.invoke(arg1, arg2, mc);
                return result.toString();
            } catch (Exception e2) {
                return "Invalid command to calc";
            }
        } catch (Exception e) {
            return "Invalid command to calc";
        }
    }
}