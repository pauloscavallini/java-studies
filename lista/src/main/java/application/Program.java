package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();

        lista.add("Maria");
        lista.add("Alex");
        lista.add("Bob");
        lista.add("Anna");
        lista.add(2, "Marco");

        System.out.println(lista.size());

        // metodo .remove()
//        lista.remove("Anna"); // compara com elemento e remove
//        lista.remove(1); // remove a partir do indice

        // predicate (removendo item na lista onde o primeiro char é 'M')
        lista.removeIf(x -> x.charAt(0) == 'M');

        for (String x : lista) {
            System.out.println(x);
        }

        System.out.println("Index of Bob: " + lista.indexOf("Bob"));
        System.out.println("Index of Marco: " + lista.indexOf("Marco")); // -1 retornado quando não encontrado

        // filtar
        List<String> result = lista
                .stream()
                .filter(x -> x.charAt(0) == 'A')
                .collect(Collectors.toList());

        for (String x : result) {
            System.out.println(x);
        }

        String name = lista
                .stream()
                .filter(x -> x.charAt(0) == 'A')
                .findFirst() // buscando apenas o PRIMEIRO elemento dado o filtro
                .orElse(null); // caso não encontrado retornar null

        System.out.println(name);
    }
}
