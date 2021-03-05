package com.exercise.moviecatalogue.utils

import com.exercise.moviecatalogue.data.source.local.entity.MoviesModel
import com.exercise.moviecatalogue.data.source.local.entity.TvShowsModel
import com.exercise.moviecatalogue.data.source.remote.response.MoviesResponse
import com.exercise.moviecatalogue.data.source.remote.response.TvShowsResponse

object DataDummy {

    fun generateDummyMovies(): List<MoviesModel> {

        val movies = ArrayList<MoviesModel>()

        movies.add(
            MoviesModel(
                "mo-1",
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "Drama, Romance, Music",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
                "2h 16m",
                "2018"
            )
        )

        movies.add(
            MoviesModel(
                "mo-2",
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "Action, Science Fiction, Adventure",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                "2h 2m",
                "2019"
            )
        )

        movies.add(
            MoviesModel(
                "mo-3",
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "Action, Adventure, Fantasy",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                "2h 23m",
                "2018"
            )
        )

        movies.add(
            MoviesModel(
                "mo-4",
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "Music, Drama, History",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "2h 15m",
                "2018"
            )
        )

        movies.add(
            MoviesModel(
                "mo-5",
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "Action, Crime, Thriller",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                "1h 59m",
                "2019"
            )
        )

        movies.add(
            MoviesModel(
                "mo-6",
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "Drama",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
                "2h 10m",
                "2018"
            )
        )

        movies.add(
            MoviesModel(
                "mo-7",
                "Overlord",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                "Horror, War, Science Fiction",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/l76Rgp32z2UxjULApxGXAPpYdAP.jpg",
                "1h 50m",
                "2018"
            )
        )

        movies.add(
            MoviesModel(
                "mo-8",
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "Thriller, Drama, Science Fiction",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                "2h 9m",
                "2019"
            )
        )

        movies.add(
            MoviesModel(
                "mo-9",
                "Serenity",
                "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
                "Thriller, Mystery, Drama",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zPfjb0ULVgn3oEnPtS81gfJ5IKO.jpg",
                "1h 42m",
                "2019"
            )
        )

        movies.add(
            MoviesModel(
                "mo-10",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "Adventure, Action, Science Fiction",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "2h 29m",
                "2018"
            )
        )

        return movies
    }

    fun generateDummyTvShows(): List<TvShowsModel> {

        val tvShows = ArrayList<TvShowsModel>()

        tvShows.add(
            TvShowsModel(
                "tv-1",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "Crime, Drama, Mystery",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "42m per eps",
                "2012"
            )
        )

        tvShows.add(
            TvShowsModel(
                "tv-2",
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "Sci-Fi & Fantasy, Action & Adventure",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg",
                "49m per eps",
                "2019"
            )
        )

        tvShows.add(
            TvShowsModel(
                "tv-3",
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "Comedy, Sci-Fi & Fantasy, Animation",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg",
                "25m per eps",
                "1986"
            )
        )

        tvShows.add(
            TvShowsModel(
                "tv-4",
                "Fairy Tail",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "Action & Adventure, Animation",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1T6XCwWpmg1B4jrzAlcFCnJGQVD.jpg",
                "25m per eps",
                "2009"
            )
        )

        tvShows.add(
            TvShowsModel(
                "tv-5",
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "Animation, Comedy",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qlClTwL0GSGZUH7xwJU5PER5wnJ.jpg",
                "22m per eps",
                "1999"
            )
        )

        tvShows.add(
            TvShowsModel(
                "tv-6",
                "Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "Drama, Sci-Fi & Fantasy",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "44m per eps",
                "2014"
            )
        )

        tvShows.add(
            TvShowsModel(
                "tv-7",
                "Game of Thrones",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "Sci-Fi & Fantasy, Drama",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                "1h per eps",
                "2011"
            )
        )

        tvShows.add(
            TvShowsModel(
                "tv-8",
                "Gotham",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "Drama, Crime, Sci-Fi",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
                "43m per eps",
                "2014"
            )
        )

        tvShows.add(
            TvShowsModel(
                "tv-9",
                "Naruto Shipudden",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "Animation, Action & Adventure",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hKkY4Hf5tDKCwVzzeo42vp1RxPQ.jpg",
                "25m per eps",
                "2007"
            )
        )

        tvShows.add(
            TvShowsModel(
                "tv-10",
                "Supergirl",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "Drama, Sci-Fi & Fantasy",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4ka8vAzAFUZFKxWyfGfwVcSXuZo.jpg",
                "42m per eps",
                "2015"
            )
        )

        return tvShows
    }


    fun generateMovies(): List<MoviesResponse> {

        val movies = ArrayList<MoviesResponse>()

        movies.add(
            MoviesResponse(
                "mo-1",
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "Drama, Romance, Music",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
                "2h 16m",
                "2018"
            )
        )

        movies.add(
            MoviesResponse(
                "mo-2",
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "Action, Science Fiction, Adventure",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                "2h 2m",
                "2019"
            )
        )

        movies.add(
            MoviesResponse(
                "mo-3",
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "Action, Adventure, Fantasy",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                "2h 23m",
                "2018"
            )
        )

        movies.add(
            MoviesResponse(
                "mo-4",
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "Music, Drama, History",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "2h 15m",
                "2018"
            )
        )

        movies.add(
            MoviesResponse(
                "mo-5",
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "Action, Crime, Thriller",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                "1h 59m",
                "2019"
            )
        )

        movies.add(
            MoviesResponse(
                "mo-6",
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "Drama",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
                "2h 10m",
                "2018"
            )
        )

        movies.add(
            MoviesResponse(
                "mo-7",
                "Overlord",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                "Horror, War, Science Fiction",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/l76Rgp32z2UxjULApxGXAPpYdAP.jpg",
                "1h 50m",
                "2018"
            )
        )

        movies.add(
            MoviesResponse(
                "mo-8",
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "Thriller, Drama, Science Fiction",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                "2h 9m",
                "2019"
            )
        )

        movies.add(
            MoviesResponse(
                "mo-9",
                "Serenity",
                "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
                "Thriller, Mystery, Drama",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zPfjb0ULVgn3oEnPtS81gfJ5IKO.jpg",
                "1h 42m",
                "2019"
            )
        )

        movies.add(
            MoviesResponse(
                "mo-10",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "Adventure, Action, Science Fiction",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "2h 29m",
                "2018"
            )
        )

        return movies
    }

    fun generateTvShows(): List<TvShowsResponse> {

        val tvShows = ArrayList<TvShowsResponse>()

        tvShows.add(
            TvShowsResponse(
                "tv-1",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "Crime, Drama, Mystery",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "42m per eps",
                "2012"
            )
        )

        tvShows.add(
            TvShowsResponse(
                "tv-2",
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "Sci-Fi & Fantasy, Action & Adventure",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg",
                "49m per eps",
                "2019"
            )
        )

        tvShows.add(
            TvShowsResponse(
                "tv-3",
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "Comedy, Sci-Fi & Fantasy, Animation",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg",
                "25m per eps",
                "1986"
            )
        )

        tvShows.add(
            TvShowsResponse(
                "tv-4",
                "Fairy Tail",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "Action & Adventure, Animation",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1T6XCwWpmg1B4jrzAlcFCnJGQVD.jpg",
                "25m per eps",
                "2009"
            )
        )

        tvShows.add(
            TvShowsResponse(
                "tv-5",
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "Animation, Comedy",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qlClTwL0GSGZUH7xwJU5PER5wnJ.jpg",
                "22m per eps",
                "1999"
            )
        )

        tvShows.add(
            TvShowsResponse(
                "tv-6",
                "Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "Drama, Sci-Fi & Fantasy",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "44m per eps",
                "2014"
            )
        )

        tvShows.add(
            TvShowsResponse(
                "tv-7",
                "Game of Thrones",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "Sci-Fi & Fantasy, Drama",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                "1h per eps",
                "2011"
            )
        )

        tvShows.add(
            TvShowsResponse(
                "tv-8",
                "Gotham",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "Drama, Crime, Sci-Fi",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
                "43m per eps",
                "2014"
            )
        )

        tvShows.add(
            TvShowsResponse(
                "tv-9",
                "Naruto Shipudden",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "Animation, Action & Adventure",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hKkY4Hf5tDKCwVzzeo42vp1RxPQ.jpg",
                "25m per eps",
                "2007"
            )
        )

        tvShows.add(
            TvShowsResponse(
                "tv-10",
                "Supergirl",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "Drama, Sci-Fi & Fantasy",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4ka8vAzAFUZFKxWyfGfwVcSXuZo.jpg",
                "42m per eps",
                "2015"
            )
        )

        return tvShows
    }
}