package com.example.nttdata_app_filmes.model

data class Filme(
    val adult: Boolean,
    val backdrop_path: String,
    val budget: Int,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val runtime: Int,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)

fun mockFilme() = listOf(

    Filme(

        adult = false,
        title = "Uncharted",
        backdrop_path = "/rr7E0NoGKxvbkb89eR1GwfoYjpA.jpg",
        budget = 63000000,
        homepage = "http://www.foxmovies.com/movies/fight-club",
        id = 1,
        imdb_id = "tt0137523",
        original_language = "en",
        original_title = "Fight Club",
        overview = "A ticking-time-bomb insomniac and a slippery soap salesman channel primal male aggression into a shocking new form of therapy. Their concept catches on, with underground \"fight clubs\" forming in every town, until an eccentric gets in the way and ignites an out-of-control spiral toward oblivion.",
        popularity = 48.503,
        poster_path = "/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg",
        release_date = "1999-10-15",
        runtime = 139,
        tagline = "Mischief. Mayhem. Soap.",
        video = false,
        vote_average = 8.4,
        vote_count = 23990

    ),

    Filme(
        adult = false,
        backdrop_path = "/rr7E0NoGKxvbkb89eR1GwfoYjpA.jpg",
        budget = 63000000,
        homepage = "http://www.foxmovies.com/movies/fight-club",
        id = 2,
        imdb_id = "tt0137523",
        original_language = "en",
        original_title = "Fight Club",
        overview = "A ticking-time-bomb insomniac and a slippery soap salesman channel primal male aggression into a shocking new form of therapy. Their concept catches on, with underground \"fight clubs\" forming in every town, until an eccentric gets in the way and ignites an out-of-control spiral toward oblivion.",
        popularity = 48.503,
        poster_path = "/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg",
        release_date = "1999-10-15",
        runtime = 139,
        tagline = "Mischief. Mayhem. Soap.",
        title = "Fight Club",
        video = false,
        vote_average = 7.4,
        vote_count = 23990

    ),

    Filme(

        adult = false,
        backdrop_path = "/rr7E0NoGKxvbkb89eR1GwfoYjpA.jpg",
        budget = 63000000,
        homepage = "http://www.foxmovies.com/movies/fight-club",
        id = 3,
        imdb_id = "tt0137523",
        original_language = "en",
        original_title = "Fight Club",
        overview = "A ticking-time-bomb insomniac and a slippery soap salesman channel primal male aggression into a shocking new form of therapy. Their concept catches on, with underground \"fight clubs\" forming in every town, until an eccentric gets in the way and ignites an out-of-control spiral toward oblivion.",
        popularity = 48.503,
        poster_path = "/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg",
        release_date = "1999-10-15",
        runtime = 139,
        tagline = "Mischief. Mayhem. Soap.",
        title = "Barbie",
        video = false,
        vote_average = 4.4,
        vote_count = 23990

    ),

    Filme(

        adult = false,
        backdrop_path = "/rr7E0NoGKxvbkb89eR1GwfoYjpA.jpg",
        budget = 63000000,
        homepage = "http://www.foxmovies.com/movies/fight-club",
        id = 4,
        imdb_id = "tt0137523",
        original_language = "en",
        original_title = "Fight Club",
        overview = "A ticking-time-bomb insomniac and a slippery soap salesman channel primal male aggression into a shocking new form of therapy. Their concept catches on, with underground \"fight clubs\" forming in every town, until an eccentric gets in the way and ignites an out-of-control spiral toward oblivion.",
        popularity = 48.503,
        poster_path = "/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg",
        release_date = "1999-10-15",
        runtime = 139,
        tagline = "Mischief. Mayhem. Soap.",
        title = "Bob Sponja",
        video = false,
        vote_average = 8.4,
        vote_count = 23990

    ),

    Filme(

        adult = false,
        backdrop_path = "/rr7E0NoGKxvbkb89eR1GwfoYjpA.jpg",
        budget = 63000000,
        homepage = "http://www.foxmovies.com/movies/fight-club",
        id = 5,
        imdb_id = "tt0137523",
        original_language = "en",
        original_title = "Fight Club",
        overview = "A ticking-time-bomb insomniac and a slippery soap salesman channel primal male aggression into a shocking new form of therapy. Their concept catches on, with underground \"fight clubs\" forming in every town, until an eccentric gets in the way and ignites an out-of-control spiral toward oblivion.",
        popularity = 48.503,
        poster_path = "/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg",
        release_date = "1999-10-15",
        runtime = 139,
        tagline = "Mischief. Mayhem. Soap.",
        title = "O Senhor dos Aneis",
        video = false,
        vote_average = 8.4,
        vote_count = 23990

    ),

    Filme(

        adult = false,
        backdrop_path = "/rr7E0NoGKxvbkb89eR1GwfoYjpA.jpg",
        budget = 63000000,
        homepage = "http://www.foxmovies.com/movies/fight-club",
        id = 6,
        imdb_id = "tt0137523",
        original_language = "en",
        original_title = "Fight Club",
        overview = "A ticking-time-bomb insomniac and a slippery soap salesman channel primal male aggression into a shocking new form of therapy. Their concept catches on, with underground \"fight clubs\" forming in every town, until an eccentric gets in the way and ignites an out-of-control spiral toward oblivion.",
        popularity = 48.503,
        poster_path = "/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg",
        release_date = "1999-10-15",
        runtime = 139,
        tagline = "Mischief. Mayhem. Soap.",
        title = "Harry Potter e a Pedra Filosofal",
        video = false,
        vote_average = 8.4,
        vote_count = 23990

    )


)



