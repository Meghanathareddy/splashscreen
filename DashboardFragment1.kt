package com.example.splashscreen.fragments


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.splashscreen.*
import com.example.splashscreen.databinding.DashboardfragmentOneBinding
import com.example.splashscreen.model.Data
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class DashboardFragment1: Fragment() {

//    private var ImgUrl: ArrayList<String> = ArrayList()
//    private lateinit var recyclerView: RecyclerView
    private lateinit var Manager: LinearLayoutManager

//    private  var userList: List<Data> = ArrayList()
    private lateinit var adapter: CustomAdapter
    private lateinit var viewModel: DashboardFragment1ViewModel
    private lateinit var _dashboardFragmment1:DashboardfragmentOneBinding
    val dashboardFragmment1 get() = _dashboardFragmment1!!
    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _dashboardFragmment1 = DashboardfragmentOneBinding.inflate(inflater,parent,false)

//        val view = inflater.inflate(R.layout.dashboardfragment_one, parent, false)

        setupRecyclerView()


//
//        recyclerView = view.findViewById(R.id.recyclerview)
//        Manager = LinearLayoutManager(context)
//        recyclerView.layoutManager = Manager
//        adapter = context?.let { Adapter(ImgUrl, it) }!!
//        recyclerView.adapter = adapter

        // Defines the xml file for the fragment
        return dashboardFragmment1.root
    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DashboardFragment1ViewModel::class.java)

        viewModel.usersListResponses.observe(viewLifecycleOwner) {
//            userList = it
            adapter.mList = it
            adapter.notifyDataSetChanged()

        }
        viewModel.usersListResponse()


    }





    private fun setupRecyclerView() {
//        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerview)
        //this creates a vertical layout Manager
        dashboardFragmment1.recyclerview?.layoutManager = LinearLayoutManager(activity)
        //This will pass the ArrayList to our Adapter
        adapter = CustomAdapter(ArrayList())
        //Setting the Adapter with the recyclerview
        dashboardFragmment1.recyclerview?.adapter = adapter

    }

    @SuppressLint("SimpleDateFormat")
    fun getCurrentTime(): String {
        val calendar = Calendar.getInstance()
        val mdformat = SimpleDateFormat("HH:mm")
        val strDate = "" + mdformat.format(calendar.time)
       return strDate
    }

}



//    fun setupRecyclerView(view:View?){
//        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerview)
//
//        //this creates a vertical layout Manager
//        recyclerView?.layoutManager = LinearLayoutManager(activity)
//
//        val data = ArrayList<Items>()
//
//        //This loop will create 20 view containing
//        // the image with the count of view
//        for (i in 1..20){
//            data.add(Items(imageView, "item" +i))
//        }
//
//        //This will pass the ArrayList to our Adapter
//        val adapter = CustomAdapter(data)
//
//        //Setting the Adapter with the recyclerview
//        recyclerView?.adapter = adapter
//
//
//    }


//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        //getting hte recyclerview by its id
//        val recyclerView = view1.findViewById<RecyclerView>(R.id.recyclerview)
//
        //this creates a vertical layout Manager
//        recyclerView.layoutManager = LinearLayoutManager(activity)
//
//        val data = ArrayList<ItemsViewModel>()
//
//        //This loop will create 20 view containing
//        // the image with the count of view
//        for (i in 1..20){
//            data.add(ItemsViewModel(R.drawable.ic_launcher_background, "${home1.text}" +i))
//        }
//
//        //This will pass the ArrayList to our Adapter
//        val adapter = CustomAdapter(data)
//
//        //Setting the Adapter with the recyclerview
//        recyclerView.adapter = adapter

//    }



