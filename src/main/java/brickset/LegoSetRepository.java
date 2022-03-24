package brickset;

import repository.Repository;

/**
 * Represents a repository of {@code LegoSet} objects.
 */
public class LegoSetRepository extends Repository<LegoSet> {


    public LegoSetRepository() {
        super(LegoSet.class, "brickset.json");
    }

    /**
     * Viszaadja a Duplo témába tartozó LEGO-k számát
     *
     * @return a Lego Duplo-k számát
     */
    public long numberOfDuplos(){
       return getAll().stream()
               .filter(legoSet -> legoSet.getTheme().equals("Duplo"))
               .count();
    }

    /**
     * Kiírja egy LEGO nevét, gyártási számát, valamint hogy hány darabból áll, ha több darabból áll, mint amennyit átadunk neki
     *
     * @param x LEGO darabszám, amitől nagyobbakat keresünk
     */
    public void printMoreThanGivenPieces(int x){

        getAll().stream()
                .filter(legoSet -> legoSet.getPieces()>x)
                        .forEach(legoSet ->
                                    System.out.println("name: " + legoSet.getName() + " | number: "
                                            + legoSet.getNumber() + " | number of pieces: " + legoSet.getPieces()));
                                };

    /**
     * Kiírja az első N LegoSet nevét ABC sorrendben, nagybetűvel
     *
     * @param N db LegoSet
     */
    public void printNSortedNames(int N){
        getAll().stream()
                .map(legoSet -> legoSet.getName().toUpperCase())
                .sorted()
                .limit(N)
                .forEach(System.out::println);
    }

    /**
     * Visszaadja azoknak a LEGO set-eknek a számát, melyek 1 darabosak, és fel van jegyezve a súlyuk
     *
     * @return az egy darabból álló, feljegyzett súlyú LEGO setek számát
     */
    public long numberOfOnePieceLegosWithWeight(){
        return getAll().stream()
                .filter(legoSet -> legoSet.getPieces()==1
                        && legoSet.getDimensions()!= null
                        && legoSet.getDimensions().getWeight()!= null)
                .count();
    }

    /**
     * Kiírja a legnagyobb darabszámú LEGO-set összes adatát
     */
    public void printBiggestSet()
    {
        getAll().stream()
                .reduce((x, y) -> y.getPieces() > x.getPieces() ? y : x)
                .ifPresent(System.out::println);
    }


}

