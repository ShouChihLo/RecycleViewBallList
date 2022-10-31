package com.example.recycleviewballlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewballlist.databinding.ItemLayoutBinding

class BallAdapter(val ballList: List<Ball>): RecyclerView.Adapter<BallAdapter.ViewHolder>() {

    // inner class for holding view items (viewholder)
    //class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
    class ViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root) { // apply view binding
//        val ballImage: ImageView = view.findViewById(R.id.imageView)
//        val ballName: TextView = view.findViewById(R.id.textView)

        // assign the data content to the view holder
        fun bind(ball: Ball) {
//            ballImage.setImageResource(ball.imageId)
//            ballName.text = ball.name
            binding.imageView.setImageResource(ball.imageId)
            binding.textView.text = ball.name
        }
    }

    // create a new viewholder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        //val view = layoutInflater.inflate(R.layout.item_layout, parent, false)
        //val view = layoutInflater.inflate(R.layout.item_layout_card, parent, false)
        //val viewHolder = ViewHolder(view)
        val binding = ItemLayoutBinding.inflate(layoutInflater, parent, false)
        val viewHolder = ViewHolder(binding)
        // handle the item selection event
        viewHolder.itemView.setOnClickListener {
            // if bindingAdapterPosition is not working, use adapterPosition instead
            Toast.makeText(parent.context, ballList[viewHolder.bindingAdapterPosition].name, Toast.LENGTH_SHORT).show()
        }
        return viewHolder
    }

    // return the size of data source
    override fun getItemCount(): Int {
        return ballList.size
    }

    // get a viewholder and populate the data content
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ball = ballList[position]
        holder.bind(ball)
    }
}