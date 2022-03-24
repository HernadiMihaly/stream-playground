package brickset;

public class mainClass {
    public static void main(String[] args) {
        LegoSetRepository lego= new LegoSetRepository();

        //1.
        System.out.println();
        System.out.println(lego.numberOfDuplos());

        //2.
        System.out.println();
        lego.printMoreThanGivenPieces(2000);


        //3.
        System.out.println();
        lego.printNSortedNames(10);

        //4.
        System.out.println();
        System.out.println(lego.numberOfOnePieceLegosWithWeight());

        //5.
        System.out.println();
        lego.printBiggestSet();
    }
}
