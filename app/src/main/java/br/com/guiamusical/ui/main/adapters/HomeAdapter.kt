package br.com.guiamusical.ui.main.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import br.com.domain.entity.*
import br.com.guiamusical.R
import br.com.guiamusical.databinding.*

class HomeAdapter(private val context: Context, private val data : List<Any>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binder = when(viewType){
            1 -> {
                DataBindingUtil.inflate<CardTitleBinding>(
                    inflater,
                    R.layout.card_title,
                    parent,
                    false
                )
            }
            2 -> {
                DataBindingUtil.inflate<CardNewsV1Binding>(
                    inflater,
                    R.layout.card_news_v1,
                    parent,
                    false
                )
            }
            22 -> {
                DataBindingUtil.inflate<CardNewsV3Binding>(
                    inflater,
                    R.layout.card_news_v3,
                    parent,
                    false
                )
            }
            3 -> {
                DataBindingUtil.inflate<CardBandBinding>(
                    inflater,
                    R.layout.card_band,
                    parent,
                    false
                )
            }
            5 -> {
                DataBindingUtil.inflate<CardListGenderBinding>(
                    inflater,
                    R.layout.card_list_gender,
                    parent,
                    false
                )
            }
            else -> {
                DataBindingUtil.inflate<CardTitleBinding>(
                    inflater,
                    R.layout.card_title,
                    parent,
                    false
                )
            }
        }
        return ViewHolder(binder)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemViewType(position: Int): Int {
        return when(val model = data[position]){
            is String -> 1
            is News -> {
                if(model.id != 1L){
                    2
                } else {
                    22
                }
            }
            is Band -> 3
            is Show -> 4
            is List<*> -> 5
            is Release -> 6
            else -> -1
        }
    }

    class ViewHolder(private val binder: ViewDataBinding) : RecyclerView.ViewHolder(binder.root) {

        fun bind(data : Any) {
            when(binder){
                is CardNewsV1Binding -> {
                    binder.model = data as News
                }
                is CardNewsV3Binding -> {
                    binder.model = data as News
                }
                is CardBandBinding -> {
                    binder.model = data as Band
                }
                is CardTitleBinding -> {
                    binder.title = data as String
                }
                is CardListGenderBinding -> {
                    binder.list = data as List<Gender>
                }
            }
        }

    }
}