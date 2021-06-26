package com.rizki.moviecatalogue.utils

import com.rizki.moviecatalogue.data.source.local.entity.MovieEntity
import com.rizki.moviecatalogue.data.source.local.entity.TvShowEntity
import com.rizki.moviecatalogue.data.source.remote.response.MovieResponse
import com.rizki.moviecatalogue.data.source.remote.response.TvShowResponse

object DataDummy {
    fun generateDummyMovies(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                "a11",
                "Alita: Battle Angel (2019)",
                "An angel falls. A warrior rises.",
                "Action, Science Fiction, Adventure",
                "2h 2m",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "a12",
                "Avengers: Infinity War (2018)",
                "An entire universe. Once and for all.",
                "Action, Science Fiction, Adventure",
                "2h 29m",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "04/27/2018",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "a13",
                "Aquaman (2018)",
                "Home Is Calling",
                "Action, Fantasy, Adventure",
                "2h 23m",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "12/21/2018",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vEj13Ro7d2qjgeHI0eyqb7wMjvO.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "a14",
                "Bohemian Rhapsody (2018)",
                "Fearless lives forever",
                "Music, Drama, History",
                "2h 15m",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "11/02/2018",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "a15",
                "Cold Pursuit (2019)",
                "Meet Nels Coxman. Citizen of the Year.",
                "Action, Crime, Thriller",
                "1h 59m",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "02/08/2019",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "a16",
                "Creed II (2018)",
                "There's More to Lose than a Title",
                "Drama",
                "2h 10m",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "11/21/2018",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "a17",
                "Fantastic Beasts: The Crimes of Grindelwald (2018)",
                "Fate of One. Future of All.",
                "Adventure, Fantasy, Drama",
                "2h 14m",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "11/16/2018",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/u5QrKhSCGoFsB8aAvZZJ1b53k16.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "a18",
                "Glass (2019)",
                "You Cannot Contain What You Are",
                "Thriller, Drama, Science Fiction",
                "2h 9m",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "01/18/2019",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "a19",
                "How to Train Your Dragon: The Hidden World (2019)",
                "The friendship of a lifetime",
                "Animation, Family, Adventure",
                "1h 44m",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "01/09/2019",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "a120",
                "Spider-Man: Into the Spider-Verse (2018)",
                "More Than One Wears the Mask",
                "Action, Adventure, Animation, Science Fiction, Comedy",
                "1h 57m",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "12/14/2018",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg"
            )
        )

        return movies
    }

    fun generatedDummyTvShows(): List<TvShowEntity> {
        val tvShows = ArrayList<TvShowEntity>()

        tvShows.add(
            TvShowEntity(
                "b11",
                "Who Killed Sara? (2021)",
                null.toString(),
                "Drama, Crime, Mystery",
                "40m",
                "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                "NETFLIX",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg"

            )
        )

        tvShows.add(
            TvShowEntity(
                "b12",
                "The Flash (2014)",
                "The fastest man alive.",
                "Drama, Sci-Fi & Fantasy",
                "44m",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "The CW",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "b13",
                "The Good Doctor (2017)",
                "His mind is a mystery, his methods are a miracle.",
                "Drama",
                "43m",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "ABC",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "b14",
                "The Falcon and the Winter Soldier (2021)",
                "Honor the shield.",
                "Sci-Fi & Fantasy, Action & Adventure, Drama, War & Politics",
                "50m",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "Disney+",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6kbAMLteGO8yyewYau6bJ683sw7.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "b15",
                "Grey's Anatomy (2005)",
                "The life you save may be your own.",
                "Drama",
                "43m",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "ABC",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
            )
        )

        tvShows.add(
            TvShowEntity(
                "b16",
                "Love, Death & Robots (2019)",
                null.toString(),
                "Animation, Sci-Fi & Fantasy",
                "15m",
                "Terrifying creatures, wicked surprises and dark comedy converge in this NSFW anthology of animated stories presented by Tim Miller and David Fincher.",
                "NETFLIX",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/asDqvkE66EegtKJJXIRhBJPxscr.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "b17",
                "Invincible (2021)",
                null.toString(),
                "Animation, Action & Adventure, Drama, Sci-Fi & Fantasy",
                "45m",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                "Amazon",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "b18",
                "Lucifer (2016)",
                "It's good to be bad.",
                "Crime, Sci-Fi & Fantasy",
                "45m",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "FOX & NETFLIX",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "b19",
                "Riverdale (2017)",
                "Small town. Big secrets.",
                "Mystery, Drama, Crime",
                "45m",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "The CW",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "b20",
                "Jupiter's Legacy (2021)",
                "No legacy lives forever.",
                "Sci-Fi & Fantasy, Action & Adventure, Drama, Mystery",
                "45m",
                "When the world's first generation of superheroes received their powers in the 1930s become the revered elder guard in the present, their superpowered children struggle to live up to the legendary feats of their parents.",
                "NETFLIX",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9yxep7oJdkj3Pla9TD9gKflRApY.jpg"
            )
        )

        return tvShows
    }

    fun generateRemoteDummyMovies(): List<MovieResponse> {
        val movies = ArrayList<MovieResponse>()

        movies.add(
            MovieResponse(
                "a11",
                "Alita: Battle Angel (2019)",
                "An angel falls. A warrior rises.",
                "Action, Science Fiction, Adventure",
                "2h 2m",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )

        movies.add(
            MovieResponse(
                "a12",
                "Avengers: Infinity War (2018)",
                "An entire universe. Once and for all.",
                "Action, Science Fiction, Adventure",
                "2h 29m",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "04/27/2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"
            )
        )

        movies.add(
            MovieResponse(
                "a13",
                "Aquaman (2018)",
                "Home Is Calling",
                "Action, Fantasy, Adventure",
                "2h 23m",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "12/21/2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vEj13Ro7d2qjgeHI0eyqb7wMjvO.jpg"
            )
        )

        movies.add(
            MovieResponse(
                "a14",
                "Bohemian Rhapsody (2018)",
                "Fearless lives forever",
                "Music, Drama, History",
                "2h 15m",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "11/02/2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"
            )
        )

        movies.add(
            MovieResponse(
                "a15",
                "Cold Pursuit (2019)",
                "Meet Nels Coxman. Citizen of the Year.",
                "Action, Crime, Thriller",
                "1h 59m",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "02/08/2019",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg"
            )
        )

        movies.add(
            MovieResponse(
                "a16",
                "Creed II (2018)",
                "There's More to Lose than a Title",
                "Drama",
                "2h 10m",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "11/21/2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg"
            )
        )

        movies.add(
            MovieResponse(
                "a17",
                "Fantastic Beasts: The Crimes of Grindelwald (2018)",
                "Fate of One. Future of All.",
                "Adventure, Fantasy, Drama",
                "2h 14m",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "11/16/2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/u5QrKhSCGoFsB8aAvZZJ1b53k16.jpg"
            )
        )

        movies.add(
            MovieResponse(
                "a18",
                "Glass (2019)",
                "You Cannot Contain What You Are",
                "Thriller, Drama, Science Fiction",
                "2h 9m",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "01/18/2019",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg"
            )
        )

        movies.add(
            MovieResponse(
                "a19",
                "How to Train Your Dragon: The Hidden World (2019)",
                "The friendship of a lifetime",
                "Animation, Family, Adventure",
                "1h 44m",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "01/09/2019",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg"
            )
        )

        movies.add(
            MovieResponse(
                "a120",
                "Spider-Man: Into the Spider-Verse (2018)",
                "More Than One Wears the Mask",
                "Action, Adventure, Animation, Science Fiction, Comedy",
                "1h 57m",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "12/14/2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg"
            )
        )

        return movies
    }

    fun generatedRemoteDummyTvShows(): List<TvShowResponse> {
        val tvShows = ArrayList<TvShowResponse>()

        tvShows.add(
            TvShowResponse(
                "b11",
                "Who Killed Sara? (2021)",
                null.toString(),
                "Drama, Crime, Mystery",
                "40m",
                "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                "NETFLIX",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg"

            )
        )

        tvShows.add(
            TvShowResponse(
                "b12",
                "The Flash (2014)",
                "The fastest man alive.",
                "Drama, Sci-Fi & Fantasy",
                "44m",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "The CW",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg"
            )
        )

        tvShows.add(
            TvShowResponse(
                "b13",
                "The Good Doctor (2017)",
                "His mind is a mystery, his methods are a miracle.",
                "Drama",
                "43m",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "ABC",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg"
            )
        )

        tvShows.add(
            TvShowResponse(
                "b14",
                "The Falcon and the Winter Soldier (2021)",
                "Honor the shield.",
                "Sci-Fi & Fantasy, Action & Adventure, Drama, War & Politics",
                "50m",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "Disney+",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6kbAMLteGO8yyewYau6bJ683sw7.jpg"
            )
        )

        tvShows.add(
            TvShowResponse(
                "b15",
                "Grey's Anatomy (2005)",
                "The life you save may be your own.",
                "Drama",
                "43m",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "ABC",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
            )
        )

        tvShows.add(
            TvShowResponse(
                "b16",
                "Love, Death & Robots (2019)",
                null.toString(),
                "Animation, Sci-Fi & Fantasy",
                "15m",
                "Terrifying creatures, wicked surprises and dark comedy converge in this NSFW anthology of animated stories presented by Tim Miller and David Fincher.",
                "NETFLIX",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/asDqvkE66EegtKJJXIRhBJPxscr.jpg"
            )
        )

        tvShows.add(
            TvShowResponse(
                "b17",
                "Invincible (2021)",
                null.toString(),
                "Animation, Action & Adventure, Drama, Sci-Fi & Fantasy",
                "45m",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                "Amazon",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg"
            )
        )

        tvShows.add(
            TvShowResponse(
                "b18",
                "Lucifer (2016)",
                "It's good to be bad.",
                "Crime, Sci-Fi & Fantasy",
                "45m",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "FOX & NETFLIX",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg"
            )
        )

        tvShows.add(
            TvShowResponse(
                "b19",
                "Riverdale (2017)",
                "Small town. Big secrets.",
                "Mystery, Drama, Crime",
                "45m",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "The CW",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg"
            )
        )

        tvShows.add(
            TvShowResponse(
                "b20",
                "Jupiter's Legacy (2021)",
                "No legacy lives forever.",
                "Sci-Fi & Fantasy, Action & Adventure, Drama, Mystery",
                "45m",
                "When the world's first generation of superheroes received their powers in the 1930s become the revered elder guard in the present, their superpowered children struggle to live up to the legendary feats of their parents.",
                "NETFLIX",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9yxep7oJdkj3Pla9TD9gKflRApY.jpg"
            )
        )

        return tvShows
    }
}