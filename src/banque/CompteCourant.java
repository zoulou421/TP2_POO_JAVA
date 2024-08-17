package banque;

import java.util.Date;
import java.util.List;

public class CompteCourant extends Compte{
    private double decouvert;
    @Override
    public void retirer(double mt) {
       if(mt>solde+decouvert) throw new RuntimeException("Solde insuffisant");
       Retrait r=new Retrait(operations.size()+1,new Date(),mt);
       operations.add(r);
       solde=solde-mt;
    }

    @Override
    public void updateSolde() {
    }

    public CompteCourant() {
        super();
    }

    public CompteCourant(int code, double solde, double decouvert) {
        this.decouvert = decouvert;
    }

    public CompteCourant(int code, double solde, List<Operation> operations, double decouvert) {
        super(code, solde, operations);
        this.decouvert = decouvert;
    }
}
