package br.com.guiamusical.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.domain.entity.Gender
import br.com.guiamusical.ui.main.adapters.GenderAdapter
import com.bumptech.glide.Glide

class BindingsUtils {

    companion object {

        @BindingAdapter("img_url")
        @JvmStatic
        fun setImage(imgView: ImageView, url: String){
            Glide.with(imgView).load(url).into(imgView)
        }

        @BindingAdapter("gender_list")
        @JvmStatic
        fun setGenderAdapter(recyclerView: RecyclerView, list: List<Gender>){
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, RecyclerView.HORIZONTAL, false)
            recyclerView.adapter = GenderAdapter(recyclerView.context, list)
        }

    }

}