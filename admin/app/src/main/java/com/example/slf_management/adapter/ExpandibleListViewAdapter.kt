package com.example.slf_management.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.TextView
import android.widget.Toast
import com.example.slf_management.R
import com.example.slf_management.items.ComentarioItem
import org.w3c.dom.Text

class ExpandibleListViewAdapter (var context: Context, var expandableListView: ExpandableListView, var header : MutableList<String>, var body : MutableList<MutableList<ComentarioItem>>): BaseExpandableListAdapter() {
    override fun getGroup(groupPosition: Int): String {
        return  header[groupPosition]
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        if(convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.layout_group, null)
        }
        val title = convertView?.findViewById<TextView>(R.id.groupMaterial)
        title?.text = getGroup(groupPosition)
        title?.setOnClickListener{
            if(expandableListView.isGroupExpanded(groupPosition))
                expandableListView.collapseGroup(groupPosition)
            else
                expandableListView.expandGroup(groupPosition)
            Toast.makeText(context, getGroup(groupPosition), Toast.LENGTH_SHORT).show()
        }
        return convertView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return body[groupPosition].size
    }

    override fun getChild(groupPosition: Int, childPosition: Int): ComentarioItem {
        return body[groupPosition][childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        if(convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.layout_child, null)
        }
        val nombre = convertView?.findViewById<TextView>(R.id.nombreComentario)
        nombre?.text = getChild(groupPosition, childPosition).toString()
        val comentario = convertView?.findViewById<TextView>(R.id.comentario)
        comentario?.text = getChild(groupPosition, childPosition).toString()
        val fecha = convertView?.findViewById<TextView>(R.id.fecha)
        fecha?.text = getChild(groupPosition, childPosition).toString()
        //title?.setOnClickListener{
            //Toast.makeText(context, getChild(groupPosition, childPosition), Toast.LENGTH_SHORT).show()
       // }
        return convertView
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return header.size
    }
}