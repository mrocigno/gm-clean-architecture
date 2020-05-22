package br.com.data.mapper

import br.com.data.model.ShowResponse
import br.com.domain.entity.Show
import br.com.infrastructure.net.Mapper

class ShowResponseToShow : Mapper<ShowResponse, Show>() {

    override fun transform(item: ShowResponse?): Show {
        return Show(
            id = item?.id ?: -1,
            title = item?.title ?: "",
            highlight = (item?.highlight ?: 0 > 0),
            description = item?.description ?: "",
            genderId = item?.genderId ?: -1,
            banner = item?.banner ?: "",
            establishment = item?.establishment ?: "",
            localization = item?.localization ?: "",
            thumbnailUrl = item?.thumbnailUrl ?: ""
        )
    }

}