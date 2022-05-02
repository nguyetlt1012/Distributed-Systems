package client;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.math.BigDecimal;
import compute.Compute;
public class ComputePi {
    public static void main (String [] args){
//        if(System.getSecurityManager() == null){
//            System.setSecurityManager(new SecurityManager());
//        }
        try {
            String name = "compute";
            Registry registry = LocateRegistry.getRegistry( 1880);
            Compute comp = (Compute) registry.lookup(name);
            Pi task = new Pi(Integer.parseInt("3"));
            BigDecimal pi = comp.executeTask(task);
            System.out.println(pi);
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }
}
