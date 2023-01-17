package es.upm.miw.iwvg_devops.code;

import java.util.stream.Stream;

//agregado para simular corrección de busqueda 3
public class Searches {
     public Stream<Double> findDecimalFractionByUserName(String nameUser) {
        return new UsersDatabase().findAll()
                .filter(user -> nameUser.equals(user.getName()))
                .flatMap(user -> user.getFractions().stream())
                .map(Fraction::decimal);
    }

    public Stream<String> findUserIdBySomeProperFraction(){
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions()
                        .stream()
                        .anyMatch(Fraction::isPropper))
                .map(User::getId);
    }

    public Fraction findFractionAdditionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> id.equals(user.getId()))
                .flatMap(user -> user.getFractions().stream())
                .reduce(new Fraction(0,1), Fraction::addition);
    }

    public Fraction findFractionSubtractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> name.equals(user.getName()))
                .flatMap(user -> user.getFractions().stream()
                        .filter(i -> null != i && i.getDenominator() != 0)
                ).reduce(Fraction::subtraction)
                .orElse(new Fraction(0,1));
    }
}