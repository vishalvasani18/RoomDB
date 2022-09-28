package com.wishto.roomdbmvvm.fragment.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.wishto.roomdbmvvm.R
import com.wishto.roomdbmvvm.model.User

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_row,
                parent,
                false)
        )
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]

        holder.itemView.findViewById<TextView>(R.id.id_txt).text = currentItem.id.toString()
        holder.itemView.findViewById<TextView>(R.id.firstName_txt).text = currentItem.first_name
        holder.itemView.findViewById<TextView>(R.id.lastName_txt).text = currentItem.last_name
        holder.itemView.findViewById<TextView>(R.id.age_txt).text = currentItem.age.toString()

        holder.itemView.findViewById<ConstraintLayout>(R.id.rowLayout).setOnClickListener {
            // warning : Sometime, you need to 'rebuild project' (on the toolbar, click Build > Rebuild Project) to be able to see the 'actionListFragmentToUpdateFragment()' suggestion.
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem) // <- Pass object to Update Fragment
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()
    }
}