package es.upm.miw.iwvg_devops.code;

import org.apache.logging.log4j.LogManager;
import java.util.stream.Stream;

public class Searches {
     public Stream<Double> findDecimalFractionByUserName(String nameUser) {
        return new UsersDatabase().findAll()
                .filter(user -> nameUser.equals(user.getName()))
                .flatMap(user -> user.getFractions().stream())
                .map(Fraction::decimal);
    }


}