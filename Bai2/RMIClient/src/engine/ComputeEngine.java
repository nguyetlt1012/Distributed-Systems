package engine;

import compute.Compute;
import compute.Task;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ComputeEngine extends UnicastRemoteObject implements Compute {

    public ComputeEngine() throws RemoteException{
    }
    @Override
    public <T> T executeTask(Task<T> t)  {
        return t.execute();
    }

    public static void main(String[] args) {
//        if(System.getSecurityManager() == null){
//           System.setSecurityManager(new SecurityManager());
//        }
        try{
            String name = "compute";
           // Compute engine = new ComputeEngine();
          //  Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);
            Registry registry = LocateRegistry.createRegistry(1880);
            registry.rebind(name, new ComputeEngine());
            System.out.println("compute bound");
        } catch (Exception e){
            System.err.println("compute exception: ");
            e.printStackTrace();
        }
    }
}
