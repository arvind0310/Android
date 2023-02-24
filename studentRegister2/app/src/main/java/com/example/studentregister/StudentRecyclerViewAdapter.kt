package com.example.studentregister

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentregister.db.Student

class StudentRecyclerViewAdapter():RecyclerView.Adapter<StudentViewHolder>() {
    private val studentList = ArrayList<Student>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context) // layoutInflater -> an object
        val listItem = layoutInflater.inflate(R.layout.list_item,parent,false)
        return StudentViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(studentList[position])
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    fun setList(students:List<Student>){
        studentList.clear()
        studentList.addAll(students)
    }

}

class StudentViewHolder(private val view: View):RecyclerView.ViewHolder(view){
    fun bind(student: Student){
        val nameTextView = view.findViewById<TextView>(R.id.tvName)
        val emailTextView = view.findViewById<TextView>(R.id.tvEmail)
        nameTextView.text = student.name
        emailTextView.text = student.email
    }

}