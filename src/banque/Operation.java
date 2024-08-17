package banque;

import java.util.Date;

public class Operation {
    private int numero;
    private Date dateOperation;
    private double montant;
    public Operation() {
    }

    public Operation(int numero, Date dateOperation, double montant) {
        this.numero = numero;
        this.dateOperation = dateOperation;
        this.montant = montant;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
