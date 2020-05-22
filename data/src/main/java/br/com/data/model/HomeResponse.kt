package br.com.data.model

data class HomeResponse(
    val listGender : List<GenderResponse>,
    val publicity : List<Any>,
    val notice : List<NewsResponse>,
    val show : List<ShowResponse>,
    val release : List<ReleaseResponse>,
    val band : List<BandResponse>
)