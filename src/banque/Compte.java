package banque;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Compte {
    protected   int code;
    protected double solde;
    protected List<Operation>operations=new ArrayList<>();
    public Compte() {
    }
    public Compte(int code, double solde, List<Operation> operations) {
        this.code = code;
        this.solde = solde;
        this.operations = operations;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public void verser(double mt){
     Versement v=new Versement(operations.size()+1,new Date(),mt);
     operations.add(v);
     solde+=mt;
    }

    public abstract void retirer(double mt);
    public void virement(double mt, Compte cpt2){
      retirer(mt);
      cpt2.verser(mt);
    }
    public double consulterSolde(){
        return solde;
    }
    public abstract void updateSolde();

    public double totalVersements(){
        double somme=0;
        for(Operation o:operations){
            if(o instanceof Versement){
                somme=somme+o.getMontant();
            }
        }
        return somme;
    }

    public double totalRetraits(){
        double somme=0;
        for(Operation o:operations){
            if(o instanceof Retrait){
                somme=somme+o.getMontant();
            }
        }
        return somme;
    }
}
