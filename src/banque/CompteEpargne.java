package banque;

import java.util.Date;
import java.util.List;

public class CompteEpargne extends Compte{
    private double taux;
    public CompteEpargne() {
        super();
    }

    public CompteEpargne(int code, double solde, double taux) {
        this.taux = taux;
    }
    public CompteEpargne(int code, double solde, List<Operation> operations, double taux) {
        super(code, solde, operations);
        this.taux = taux;
    }

    @Override
    public void retirer(double mt) {
        if(mt>solde) throw new RuntimeException("Solde insuffisant");
        Retrait r=new Retrait(operations.size()+1,new Date(),mt);
        operations.add(r);
        solde=solde-mt;
    }
    @Override
    public void updateSolde() {
     solde=solde+(solde*taux/1000);
    }
}
