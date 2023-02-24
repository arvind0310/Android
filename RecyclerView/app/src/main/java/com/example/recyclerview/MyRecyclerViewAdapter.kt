package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(val fruitList: List<Fruit>) : RecyclerView.Adapter<MyViewHolder>() {
    /*var fruitList = listOf<String>("Apple", "Guavava", "Grapes","banana","Pineapple","Kait","DatePlum","Lemon","Pear","Orange")*/

    /* basically create List item template or create a view which will eventually hold data in future */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder { // createView of List items(UI screen) when start
        val layoutInflator = LayoutInflater.from(parent.context) // create an inflator
        val ListView = layoutInflator.inflate(
            R.layout.list_item,
            parent,
            false
        ) // i did 'true' and it cause app crash
        return MyViewHolder(ListView)
    }

    /* basically to show the values */
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        /* returned from onCreateViewHolder i.e the TextView value & ---- position = 0,1,2,3,.. */
        //        holder.myTextView.text = "Hi from onBind $position"

        val fruit = fruitList[position]
        /*holder.myTextView.text = fruit.name*/ // beter to set these name in MyViewHolder itself
        holder.bind(fruit) // pass the returned value to this fun
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }
}

/* will hold the view returned by onCreateViewHolder */
class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(fruit: Fruit) {
        myTextView.text = fruit.name

        view.setOnClickListener {
            Toast.makeText(view.context,"${fruit.name} is selected",Toast.LENGTH_LONG).show()
        }
    }

    val myTextView = view.findViewById<TextView>(R.id.tvName)

}
