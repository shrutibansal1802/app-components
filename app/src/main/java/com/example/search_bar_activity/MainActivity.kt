package com.example.search_bar_activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.country_child.view.*

class MainActivity : AppCompatActivity() {

    lateinit var country_list: RecyclerView

    var countries: MutableList<String> = ArrayList()
    var displayList: MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()
        country_list = findViewById<RecyclerView>(R.id.country_list) as RecyclerView

        //country_list.layoutManager = LinearLayoutManager(this)
        country_list.layoutManager = GridLayoutManager(this,2)

        country_list.adapter = country_adapter(displayList,this)
    }

    class country_adapter(items : List<String>,ctx:Context): RecyclerView.Adapter<country_adapter.viewholder>(){//for adapter items and context are constructors

        var list = items
        var context = ctx
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
            return viewholder(LayoutInflater.from(context).inflate(R.layout.country_child,parent,false))
        //To change body of created functions use File | Settings | File Templates.
        }

        override fun getItemCount(): Int {
           return list.size  //To change body of created functions use File | Settings | File Templates.
        }

        override fun onBindViewHolder(holder: viewholder, position: Int) {
           holder.name?.text = list.get(position)  //to get text in layout view..



            //To change body of created functions use File | Settings | File Templates.
        }//an adapter for recycler view


        class viewholder(v: View) : RecyclerView.ViewHolder(v){

            //view holder for view in recycler view..

            val name = v.country_name

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main,menu)

        val searchItem = menu?.findItem(R.id.search_bar_icon)

        if (searchItem != null){
            val  searchView = searchItem.actionView as SearchView

            val edittext = findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
         //   edittext.hint = "Search here..."

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true //To change body of created functions use File | Settings | File Templates.
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    if (newText!!.isNotEmpty()){

                        displayList.clear()

                        val search = newText.toLowerCase()
                        countries.forEach {
                            if(it.toLowerCase().contains(search)){
                                displayList.add(it)
                            }
                        }
                        country_list.adapter?.notifyDataSetChanged()

                        }else{
                        displayList.clear()
                        displayList.addAll(countries)
                        country_list.adapter?.notifyDataSetChanged()
                    }

                    return true//To change body of created functions use File | Settings | File Templates.
                }
            })
        }

        return super.onCreateOptionsMenu(menu)
    }



    fun loadData(){
     countries.add("India")
        countries.add("USA")
        countries.add("UK")
        countries.add("Europe")
        countries.add("Italy")
        countries.add("India")
        countries.add("USA")
        countries.add("UK")
        countries.add("Europe")
        countries.add("Italy")
        countries.add("India")
        countries.add("USA")
        countries.add("UK")
        countries.add("Europe")
        countries.add("Italy")
        countries.add("India")
        countries.add("USA")
        countries.add("UK")
        countries.add("Europe")
        countries.add("Italy")
        countries.add("India")
        countries.add("USA")
        countries.add("UK")
        countries.add("Europe")
        countries.add("Italy")

       displayList.addAll(countries)
    }
}
