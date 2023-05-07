package com.example.Semicolon.Back;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.*;
import java.util.*;

public class Movie {
    public String id, title, description, imgUrl;
    public String[] genres, directors, writers, mainCast;
    public double rating, releaseYear, lengthInMinutes;

    public Movie(String id, String title, String[] genres, double releaseYear, String description, String imgUrl, double length, String[] directors, String[] writers, String[] mainCast, double rating) {
        this.id = id; //apiId
        this.title = title;
        this.genres = genres;
        this.releaseYear = releaseYear;
        this.description = description;
        this.imgUrl = imgUrl;
        this.lengthInMinutes = length;
        this.directors = directors;
        this.writers = writers;
        this.mainCast = mainCast;
        this.rating = rating;
    }
    public Movie(Movie movie){
        this.id = movie.id; //apiId
        this.title = movie.title;
        this.genres = movie.genres;
        this.releaseYear = movie.releaseYear;
        this.description = movie.description;
        this.imgUrl = movie.imgUrl;
        this.lengthInMinutes = movie.lengthInMinutes;
        this.directors = movie.directors;
        this.writers = movie.writers;
        this.mainCast = movie.mainCast;
        this.rating = movie.rating;
    }

    public Movie() {
    }

    public double getReleaseYear() {
        return releaseYear;
    }

    public List<Movie> initializeMovies(String path) {
        List<Movie> movieList = new ArrayList<>();
        String[] allGenres = new String[]{"---ALL GENRES---", "ACTION", "ADVENTURE", "ANIMATION", "BIOGRAPHY", "COMEDY",
                "CRIME", "DRAMA", "DOCUMENTARY", "FAMILY", "FANTASY", "HISTORY", "HORROR",
                "MUSICAL", "MYSTERY", "ROMANCE", "SCIENCE_FICTION", "SPORT", "THRILLER", "WAR",
                "WESTERN"};
        try {
            URL url = new URL(path);
            Scanner scanner = new Scanner(url.openStream());
            String temp = "";
            while (scanner.hasNext()) { //scan the webpage and save it as a string
                temp += scanner.nextLine();
            }
            movieList = new Gson().fromJson(temp, new TypeToken<List<Movie>>() {}.getType()); // get json from string
            return movieList;
        } catch (FileNotFoundException | MalformedURLException f) { // url not valid
            movieList.add(new Movie("error", " ", allGenres, 0, " ", "Error-404", 0, null, null, null, 0));
            return movieList;
        } catch (UnknownHostException o) { //no internet
            movieList.add(new Movie("error", " ", allGenres, 0, " ", "Error-502", 0, null, null, null, 0));
            return movieList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Movie> staticMovieList() {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("88f841f7-103a-40d1-ac68-f6c7db56ab85", "The Godfather", new String[]{"DRAMA"}, 1972.0, "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", "http://www.imdb.com/title/tt0068646/mediaviewer/rm1067457536", 0.0, new String[]{"Francis Ford Coppola"}, new String[]{"Mario Puzo", "Francis Ford Coppola"}, new String[]{null}, 9.2));
        movieList.add(new Movie("9c3a11f9-0c87-44c5-b87c-b4bfa57c29c3", "The Shawshank Redemption", new String[]{"DRAMA"}, 1994.0, "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.", "http://www.imdb.com/title/tt0111161/mediaviewer/rm1018725120", 0.0, new String[]{"Frank Darabont"}, new String[]{"Stephen King, Frank Darabont"}, new String[]{null}, 9.3));
        movieList.add(new Movie("4e1920ba-6963-4035-ac76-22baa7881111", "The Dark Knight", new String[]{"ACTION", "CRIME", "DRAMA"}, 2008.0, "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, the caped crusader must come to terms with one of the greatest psychological tests of his ability to fight injustice.", "http://www.imdb.com/title/tt0468569/mediaviewer/rm1388020992", 0.0, new String[]{"Christopher Nolan"}, new String[]{"Jonathan Nolan, Christopher Nolan"}, new String[]{null}, 9.0));
        movieList.add(new Movie("7b8459e8-b902-49f7-aa39-1788af7feb73", "Schindler's List", new String[]{"BIOGRAPHY", "DRAMA", "HISTORY"}, 1993.0, "In German-occupied Poland during World War II, Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazi Germans.", "http://www.imdb.com/title/tt0108052/mediaviewer/rm1415390976", 0.0, new String[]{"Steven Spielberg"}, new String[]{"Steven Zaillian", "Thomas Keneally"}, new String[]{null}, 8.9));
        movieList.add(new Movie("d7a5ae48-a01c-450e-952e-12ec8609812c", "Pulp Fiction", new String[]{"CRIME", "DRAMA"}, 1994.0, "The lives of two mob hit men, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption.", "http://www.imdb.com/title/tt0110912/mediaviewer/rm2115362048", 0.0, new String[]{"Quentin Tarantino"}, new String[]{"Quentin Tarantino", "Roger Avary"}, new String[]{null}, 8.9));
        movieList.add(new Movie("709d5f40-3972-48c1-b888-a5d88c8393b1", "The Lord of the Rings: The Return of the King", new String[]{"ADVENTURE", "DRAMA", "FANTASY"}, 2003.0, "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.", "http://www.imdb.com/title/tt0167260/mediaviewer/rm1366193664", 0.0, new String[]{"Peter Jackson"}, new String[]{"J.R.R. Tolkien", "Fran Walsh", "Philippa Boyens"}, new String[]{null}, 8.9));
        movieList.add(new Movie("d23a7a8c-9965-49be-a76b-ede8eec08773", "Star Wars: Episode V - The Empire Strikes Back", new String[]{"ACTION", "ADVENTURE", "FANTASY", "SCIENCE_FICTION"}, 1980.0, "After the rebels are brutally overpowered by the Empire on the ice planet Hoth, Luke Skywalker begins Jedi training with Yoda, while his friends are pursued by Darth Vader and a bounty hunter named Boba Fett all over the galaxy.", "http://www.imdb.com/title/tt0080684/mediaviewer/rm2272650240", 0.0, new String[]{"Irvin Kershner"}, new String[]{"Leigh Brackett", "Lawrence Kasdan", "George Lucas"}, new String[]{null}, 8.7));
        movieList.add(new Movie("e81d11a7-797c-4bdf-8d6f-99c1a51c4f6f", "The Good, the Bad and the Ugly", new String[]{"WESTERN"}, 1966.0, "A bounty hunting scam joins two men in an uneasy alliance against a third in a race to find a fortune in gold buried in a remote cemetery.", "http://www.imdb.com/title/tt0060196/mediaviewer/rm2080389376", 0.0, new String[]{"Sergio Leone"}, new String[]{"Luciano Vincenzoni", "Agenore Incrocci", "Furio Scarpelli", "Sergio Leone"}, new String[]{null}, 8.9));
        movieList.add(new Movie("1f4311ab-2353-4a05-84eb-f2b286d81b4f", "12 Angry Men", new String[]{"DRAMA"}, 1957.0, "A jury holdout attempts to prevent a miscarriage of justice by forcing his colleagues to reconsider the evidence.", "http://www.imdb.com/title/tt0050083/mediaviewer/rm1414083840", 0.0, new String[]{"Sidney Lumet"}, new String[]{"Reginald Rose"}, new String[]{null}, 8.9));
        movieList.add(new Movie("a734d21d-43b7-4f90-b390-da5afadd7a27", "The Lord of the Rings: The Two Towers", new String[]{"ADVENTURE", "DRAMA", "FANTASY"}, 2002.0, "While Frodo and Sam edge closer to Mordor with the help of the shifty Gollum, the divided fellowship makes a stand against Sauron´s new ally, Saruman, and his hordes of Isengard.", "http://www.imdb.com/title/tt0167261/mediaviewer/rm1520531968", 0.0, new String[]{"Peter Jackson"}, new String[]{"J.R.R. Tolkien", "Fran Walsh", "Philippa Boyens"}, new String[]{null}, 8.7));
        movieList.add(new Movie("ca196d3b-e535-468f-acf8-d9f30956cbe0", "One Flew Over the Cuckoo´s Nest", new String[]{"DRAMA"}, 1975.0, "A criminal pleads insanity after getting into trouble again and once in the mental institution rebels against the oppressive nurse and rallies up the scared patients.", "http://www.imdb.com/title/tt0073486/mediaviewer/rm1833422080", 0.0, new String[]{"Milos Forman"}, new String[]{"Lawrence Hauben", "Bo Goldman"}, new String[]{null}, 8.7));
        movieList.add(new Movie("07dde5a5-8d7e-475d-a2d6-33eefade3afb", "Inception", new String[]{"ACTION", "ADVENTURE", "SCIENCE_FICTION", "THRILLER"}, 2010.0, "A thief, who steals corporate secrets through use of dream-sharing technology, is given the inverse task of planting an idea into the mind of a CEO.", "http://www.imdb.com/title/tt1375666/mediaviewer/rm3200632320", 0.0, new String[]{"Christopher Nolan"}, new String[]{"Christopher Nolan"}, new String[]{null}, 8.8));
        movieList.add(new Movie("d70ac44b-6049-4353-afd8-f3ec00501493", "Goodfellas", new String[]{"BIOGRAPHY", "CRIME", "DRAMA"}, 1990.0, "The story of Henry Hill and his life in the mob, covering his relationship with his wife Karen Hill and his mob partners Jimmy Conway and Tommy DeVito in the Italian-American crime syndicate.", "http://www.imdb.com/title/tt0099685/mediaviewer/rm3500692992", 0.0, new String[]{"Martin Scorsese"}, new String[]{"Nicholas Pileggi", "Nicholas Pileggi"}, new String[]{null}, 8.7));
        movieList.add(new Movie("ff32ea3c-b23b-4229-8782-b75061b61afe", "The Matrix", new String[]{"ACTION", "SCIENCE_FICTION"}, 1999.0, "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.", "http://www.imdb.com/title/tt0133093/mediaviewer/rm2900531200", 0.0, new String[]{"Lana Wachowski", "Lilly Wachowski"}, new String[]{"Lana Wachowski", "Lilly Wachowski"}, new String[]{null}, 8.7));
        movieList.add(new Movie("5b5b2039-42b1-4ae4-80c3-5ba3acd5f173", "Seven", new String[]{"CRIME", "DRAMA", "MYSTERY", "THRILLER"}, 1995.0, "Two detectives, a rookie and a veteran, hunt a serial killer who uses the seven deadly sins as his modus operandi.", "http://www.imdb.com/title/tt0114369/mediaviewer/rm3092799488", 0.0, new String[]{"David Fincher"}, new String[]{"Andrew Kevin Walker"}, new String[]{null}, 8.6));
        movieList.add(new Movie("8c12601e-ad06-471e-837a-8e37617675fc", "The Silence of the Lambs", new String[]{"CRIME", "DRAMA", "THRILLER"}, 1991.0, "A young FBI cadet must receive the help of an incarcerated and manipulative cannibal killer to help catch another serial killer, a madman who skins his victims.", "http://www.imdb.com/title/tt0102926/mediaviewer/rm868723712", 0.0, new String[]{"Jonathan Demme"}, new String[]{"Thomas Harris", "Ted Tally"}, new String[]{null}, 8.6));
        movieList.add(new Movie("7f61f81a-303b-4a60-b9c7-467dc9a6d60f", "It´s a Wonderful Life", new String[]{"DRAMA", "FAMILY", "FANTASY"}, 1946.0, "An angel is sent from Heaven to help a desperately frustrated businessman by showing him what life would have been like if he had never existed.", "http://www.imdb.com/title/tt0038650/mediaviewer/rm1745242112", 0.0, new String[]{"Frank Capra"}, new String[]{"Frances Goodrich", "Albert Hackett", "Frank Capra"}, new String[]{null}, 8.6));
        movieList.add(new Movie("9ac8912a-ce57-4a20-a25f-d8a92cb2ad27", "Saving Private Ryan", new String[]{"ACTION", "DRAMA", "WAR"}, 1998.0, "Following the Normandy Landings, a group of U.S. soldiers go behind enemy lines to retrieve a paratrooper whose brothers have been killed in action.", "http://www.imdb.com/title/tt0120815/mediaviewer/rm2966508544", 0.0, new String[]{"Steven Spielberg"}, new String[]{"Robert Rodat"}, new String[]{null}, 8.6));
        movieList.add(new Movie("69e3668a-2824-445e-acd7-e93a6fc98557", "City of God", new String[]{"CRIME", "DRAMA"}, 2002.0, "Two boys growing up in a violent neighborhood of Rio de Janeiro take different paths: one becomes a photographer, the other a drug dealer.", "http://www.imdb.com/title/tt0317248/mediaviewer/rm874637312", 0.0, new String[]{"Fernando Meirelles", "Kátia Lund"}, new String[]{"Paulo Lins", "Bráulio Mantovani"}, new String[]{null}, 8.6));
        movieList.add(new Movie("8b7cf9bc-f1c4-417f-bdb1-dfd04ed6036d", "Life Is Beautiful", new String[]{"COMEDY", "DRAMA", "ROMANCE", "WAR"}, 1997.0, "When an open-minded Jewish librarian and his son become victims of the Holocaust, he uses a perfect mixture of will, humor, and imagination to protect his son from the dangers around their camp.", "http://www.imdb.com/title/tt0118799/mediaviewer/rm1606535168", 0.0, new String[]{"Roberto Benigni"}, new String[]{"Vincenzo Cerami", "Roberto Benigni"}, new String[]{null}, 8.6));
        movieList.add(new Movie("14f69b40-8bc8-4ec4-b07b-caa6689a06a1", "The Usual Suspects", new String[]{"CRIME", "MYSTERY", "THRILLER"}, 1995.0, "A sole survivor tells of the twisty events leading up to a horrific gun battle on a boat, which begin when five criminals meet at a seemingly random police lineup.", "http://www.imdb.com/title/tt0114814/mediaviewer/rm1422030848", 0.0, new String[]{"Bryan Singer"}, new String[]{"Christopher McQuarrie"}, new String[]{null}, 8.6));
        movieList.add(new Movie("8890e818-2738-40b9-93a9-fde79ebaf619", "Puss in Boots", new String[]{"ANIMATION", "ADVENTURE", "COMEDY"}, 2011.0, "An outlaw cat, his childhood egg-friend, and a seductive thief kitty set out in search for the eggs of the fabled Golden Goose to clear his name, restore his lost honor, and regain the trust of his mother and town.", "https://www.imdb.com/title/tt0448694/mediaviewer/rm407879168/?ref_=tt_ov_i", 0.0, new String[]{"Chris Miller"}, new String[]{"Tom Wheeler, Brian Lynch"}, new String[]{null}, 6.6));
        movieList.add(new Movie("93eec132-1428-4c98-b6be-54597c584f38", "Forrest Gump", new String[]{"DRAMA", "ROMANCE"}, 1994.0, "The presidencies of Kennedy and Johnson, the Vietnam War, the Watergate scandal and other historical events unfold from the perspective of an Alabama man with an IQ of 75, whose only desire is to be reunited with his childhood sweetheart.", "https://www.imdb.com/title/tt0109830/mediaviewer/rm1954748672/?ref_=tt_ov_i", 0.0, new String[]{"Robert Zemeckis"}, new String[]{"Eric Roth", "Winston Groom"}, new String[]{null}, 8.8));
        movieList.add(new Movie("ccbbd403-234e-4289-8da5-2fd6d0c67843", "It's a Wonderful Life", new String[]{"DRAMA", "FAMILY", "FANTASY"}, 1946.0, "An angel is sent from Heaven to help a desperately frustrated businessman by showing him what life would have been like if he had never existed.", "https://www.imdb.com/title/tt0038650/mediaviewer/rm1745242112/?ref_=tt_ov_i", 0.0, new String[]{"Frank Capra"}, new String[]{"Frances Goodrich", "Albert Hackett", "Frank Capra"}, new String[]{null}, 8.6));
        movieList.add(new Movie("ea5b5f27-d25c-44c5-9ed8-a12bfb668a67", "Saving Private Ryan", new String[]{"ACTION", "DRAMA", "WAR"}, 1998.0, "Following the Normandy Landings, a group of U.S. soldiers go behind enemy lines to retrieve a paratrooper whose brothers have been killed in action.", "https://www.imdb.com/title/tt0120815/mediaviewer/rm2966508544/?ref_=tt_ov_i", 0.0, new String[]{"Steven Spielberg"}, new String[]{"Robert Rodat"}, new String[]{null}, 8.6));
        movieList.add(new Movie("5fa98356-43b1-4829-b75c-b22cd5130cac", "The Lion King", new String[]{"ANIMATION", "ADVENTURE", "DRAMA", "FAMILY", "MUSICAL"}, 1994.0, "Lion cub and future king Simba searches for his identity. His eagerness to please others and penchant for testing his boundaries sometimes gets him into trouble.", "https://www.imdb.com/title/tt0110357/mediaviewer/rm1146323456/?ref_=tt_ov_i", 0.0, new String[]{"Roger Allers", "Rob Minkoff"}, new String[]{"Irene Mecchi", "Jonathan Roberts", "Linda Woolverton"}, new String[]{null}, 8.5));
        movieList.add(new Movie("05e5fc6e-f332-4fed-b368-81eb675d3afb", "Spirited Away", new String[]{"ANIMATION", "ADVENTURE", "FAMILY", "FANTASY", "MYSTERY"}, 2001.0, "During her family's move to the suburbs, a sullen 10-year-old girl wanders into a world ruled by gods, witches, and spirits, and where humans are changed into beasts.", "https://www.imdb.com/title/tt0245429/mediaviewer/rm4207852801/?ref_=tt_ov_i", 0.0, new String[]{"Hayao Miyazaki"}, new String[]{"Hayao Miyazaki"}, new String[]{null}, 8.6));
        movieList.add(new Movie("cc447f57-1b67-4b89-a08c-3ae38f70fc69", "Toy Story", new String[]{"ANIMATION", "ADVENTURE", "COMEDY", "FAMILY", "FANTASY"}, 1995.0, "A cowboy doll is profoundly threatened and jealous when a new spaceman action figure supplants him as top toy in a boy's bedroom.", "https://www.imdb.com/title/tt0114709/mediaviewer/rm3813007616/?ref_=tt_ov_i", 0.0, new String[]{"John Lasseter"}, new String[]{"John Lasseter", "Pete Docter", "Andrew Stanton"}, new String[]{null}, 8.3));
        movieList.add(new Movie("fb208114-334b-4288-927b-786de7a99197", "Avatar", new String[]{"ACTION", "ADVENTURE", "FANTASY", "SCIENCE_FICTION"}, 2009.0, "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.", "https://www.imdb.com/title/tt0499549/mediaviewer/rm1146323456/?ref_=tt_ov_i", 0.0, new String[]{"James Cameron"}, new String[]{"James Cameron"}, new String[]{null}, 7.8));
        movieList.add(new Movie("9b4869e0-59f6-4fc1-843d-44e36756dafc", "Knives Out", new String[]{"COMEDY", "CRIME", "DRAMA", "MYSTERY", "THRILLER"}, 2019.0, "A detective investigates the death of a patriarch of an eccentric, combative family.", "https://www.imdb.com/title/tt8946378/mediaviewer/rm1146323456/?ref_=tt_ov_i", 0.0, new String[]{"Rian Johnson"}, new String[]{"Rian Johnson"}, new String[]{null}, 7.9));
        movieList.add(new Movie("2c217b0f-f2c4-45d1-a376-bbe2cf1131a2", "Once Upon a Time in Hollywood", new String[]{"COMEDY", "DRAMA"}, 2019.0, "A faded television actor and his stunt double strive to achieve fame and success in the film industry during the final years of Hollywood's Golden Age in 1969 Los Angeles.", "https://www.imdb.com/title/tt7131622/mediaviewer/rm1146323456/?ref_=tt_ov_i", 0.0, new String[]{"Quentin Tarantino"}, new String[]{"Quentin Tarantino"}, new String[]{null}, 7.7));
        movieList.add(new Movie("a70170b1-b670-48ec-a469-11cc2cd7cffe", "Django Unchained", new String[]{"DRAMA", "WESTERN"}, 2012.0, "With the help of a German bounty hunter, a freed slave sets out to rescue his wife from a brutal Mississippi plantation owner.", "https://www.imdb.com/title/tt1853728/mediaviewer/rm1146323456/?ref_=tt_ov_i", 0.0, new String[]{"Quentin Tarantino"}, new String[]{"Quentin Tarantino"}, new String[]{null}, 8.4));
        movieList.add(new Movie("89f796e6-d144-4e3e-a4bc-5cfc21ab9f97", "The Wolf of Wall Street", new String[]{"BIOGRAPHY", "COMEDY", "CRIME", "DRAMA"}, 2013.0, "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.", "https://www.imdb.com/title/tt0993846/mediaviewer/rm1146323456/?ref_=tt_ov_i", 0.0, new String[]{"Martin Scorsese"}, new String[]{"Terence Winter"}, new String[]{null}, 8.2));
        return movieList;
    }
}


