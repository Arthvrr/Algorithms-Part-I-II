//javac -cp .:algs4.jar RandomWord.java
//java -cp .:algs4.jar RandomWord

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        int i = 1;  // compteur d'itérations
        String champion = "";  // le mot sélectionné

        while (!StdIn.isEmpty()) {  // vérifie si l'entrée standard est vide
            String word = StdIn.readString();  // lire un mot depuis l'entrée standard
            if (StdRandom.bernoulli(1.0 / i)) {  // Knuth's method
                champion = word;  // remplace le champion avec probabilité 1/i
            }
            i++;
        }

        StdOut.println(champion);  // affiche le mot sélectionné au hasard
    }
}

/**
 * Méthode de Knuth :
 * 
 * La logique derrière 1.0 / i est que, pour chaque mot, il y a une chance de 1 / i qu’il devienne le “champion”, 
 * remplaçant le précédent champion. Cette approche garantit que chaque mot a une chance égale d’être sélectionné à la fin,
 * tout en ne nécessitant pas de stockage des mots.
 * 
 * Par exemple, au premier mot (i = 1), la probabilité est 1.0 / 1 = 1.0 (100 %), donc le premier mot est toujours sélectionné.
 * Ensuite, au deuxième mot (i = 2), la probabilité est 1.0 / 2 = 0.5, donc il y a 50 % de chances que le deuxième mot devienne
 * le champion. Pour le troisième mot (i = 3), la probabilité devient 1.0 / 3 ≈ 0.33, et ainsi de suite.
 */