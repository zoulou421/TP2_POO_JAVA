package banque;

import java.util.List;

public class TestApplication {
    public static void main(String[] args) {
      Compte cpt1=new CompteCourant(1,8000,5000);
      Compte cpt2=new CompteEpargne(2,3000,5.5);

      cpt1.verser(50000);
      cpt1.retirer(3000);
      cpt1.virement(400,cpt2);

      cpt1.verser(4000);
      cpt1.retirer(7000);

      System.out.println("Solde du compte 1: "+cpt1.consulterSolde());
      System.out.println("Solde du compte 2: "+cpt2.consulterSolde());

      System.out.println("Total des versements compte 1: "+cpt1.totalVersements());
      System.out.println("Solde des retraits compte 1: "+cpt2.totalRetraits());

        List<Operation>operationList=cpt1.getOperations();
        for (Operation o:operationList){
            System.out.println(o.getNumero()+"---"+o.getDateOperation()+"----"+o.getMontant());
        }

        System.out.println("------first way-----------");

        for (Operation o:operationList){
            System.out.println(o.getClass().getSimpleName()+"---"+o.getNumero()+"---"+o.getDateOperation()+"----"+o.getMontant());
        }

        System.out.println("------second way: -Versement----------");

        for (Operation o:operationList){
            if(o instanceof  Versement)
            System.out.println(o.getClass().getSimpleName()+"---"+o.getNumero()+"---"+o.getDateOperation()+"----"+o.getMontant());
        }


    }
}
