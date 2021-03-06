package zzpj;

import java.io.IOException;
import java.util.HashMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zzpj.entities.Entity;
import zzpj.entities.FilmEntity;
import zzpj.parser.CinemaCityRepertoireParser;
import zzpj.parser.FilmwebFilmParser;

@SpringBootApplication
public class CinemaParserApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(CinemaParserApplication.class, args);
//        CinemaCityRepertoireParser cinema = new CinemaCityRepertoireParser();
//
        FilmwebFilmParser filmParser = new FilmwebFilmParser("http://www.filmweb.pl/film/%C5%BBo%C5%82nierze+kosmosu-1997-207");
        FilmEntity film = filmParser.getFilm();
        System.out.println(film.getTitle());
        System.out.println(film.getDescription());

        HashMap columns = new HashMap();
        columns.put("title", "test");
        FilmEntity film2 = (FilmEntity) Entity.findOneByEntityAndColumns(new FilmEntity(), columns);
        System.out.println(film2.getTitle());
        System.out.println(film2.getDescription());
    }
}
