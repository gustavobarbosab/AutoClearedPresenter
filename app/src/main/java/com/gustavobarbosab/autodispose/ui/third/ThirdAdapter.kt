package com.gustavobarbosab.autodispose.ui.third

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gustavobarbosab.autodispose.R
import com.gustavobarbosab.autodispose.domain.Person
import kotlinx.android.synthetic.main.item_third.view.*

class ThirdAdapter : RecyclerView.Adapter<ThirdAdapter.ViewHolder>() {

    var people: List<Person> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_third, parent, false)
        )

    override fun getItemCount(): Int = people.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = people[position]
        holder.bind(person)
    }

    inner class ViewHolder(root: View) : RecyclerView.ViewHolder(root) {

        fun bind(person: Person) {
            Glide
                .with(itemView.context)
                .load(person.avatarUrl)
                .centerCrop()
                .into(itemView.personPhoto)

            itemView.personName.text = person.completeName
        }
    }
}