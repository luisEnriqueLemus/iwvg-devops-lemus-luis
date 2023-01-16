package es.upm.miw.iwvg_devops.code;

import java.util.stream.Stream;

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
}