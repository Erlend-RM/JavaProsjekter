import java.util.*;
import java.util.concurrent.locks.*;

public class Banksystem {
    public static void main(String[] args) {
        Bankkonto k = new Bankkonto();
        Thread ola = new Thread(new Kunde(k, "Ola"));
        Thread anne = new Thread(new Kunde(k, "Anne"));
        ola.start();
        anne.start();
        try {
            ola.join();
            anne.join();
        }
        catch (InterruptedException e) {

        }
        System.out.println("Kontoen er paa kr: " + k.status());
    }
}

class Bankkonto {
    private int saldo = 0;
    Lock laas = new ReentrantLock();

    public void settInn (int kr) {
        laas.lock();
        try{
            int nySaldo = saldo + kr;
            saldo = nySaldo;
        }
        finally {
            laas.unlock();
        }
        
    }

    public int status() {
        return saldo;
    }
}

class Kunde implements Runnable {
    Bankkonto konto;
    String navn;

    Kunde (Bankkonto k, String n) {
        konto = k;
        navn = n;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1_000_000; i++) {
            konto.settInn(1);
        } 
    }
}