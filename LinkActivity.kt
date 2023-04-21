//package com.example.splashscreen
//
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import androidx.lifecycle.Observer
//import androidx.lifecycle.ViewModelProvider
//import com.example.splashscreen.viewmodel.LinkViewModel
//
//class LinkActivity: AppCompatActivity() {
//    private lateinit var viewModel: LinkViewModel
//    private lateinit var  textView: TextView
//    private lateinit var button: Button
//    private lateinit var  textNumber:EditText
//
//    override fun onCreate(savedInstanceState: Bundle?){
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.link_activity)
//        textView = findViewById(R.id.linkView)
//        button = findViewById(R.id.button)
//        textNumber = findViewById(R.id.TextNumber)
//        val repository = Repository()
//        val viewModelFactory = MainViewModelFactory(repository)
//        viewModel = ViewModelProvider(this, viewModelFactory).get(LinkViewModel::class.java)
//        viewModel.getPost()
////        viewModel.myResponse.observe(this, Observer { response ->
////            if (response.isSuccessful){
////                Log.d("Response", response.body()?.id.toString())
////                Log.d("Response", response.body()?.email.toString())
////
////                textView.text = response.body()?.email!!
////                Log.d("Response", response.body()?.first_name.toString())
////                Log.d("Response", response.body()?.last_name.toString())
////            }else{
////                Log.d("Response", response.errorBody().toString())
////                textView.text = response.code().toString()
////            }
////        })
//
//
////        viewModel.myResponse2.observe(this, Observer { response ->
////            if (response.isSuccessful){
////                Log.d("Response", response.body()?.id.toString())
////                Log.d("Response", response.body()?.email.toString())
////                textView.text = response.body()?.email!!
////                Log.d("Response", response.body()?.first_name.toString())
////                Log.d("Response", response.body()?.last_name.toString())
////            }else{
////                Log.d("Response", response.errorBody().toString())
////                textView.text = response.code().toString()
////            }
////        })
//
//        button.setOnClickListener{
//            val myNumber:String = textNumber.text.toString()
//            viewModel.getPost2(Integer.parseInt(myNumber))
//            viewModel.myResponse2.observe(this, Observer { response ->
//                if (response.isSuccessful){
//                    textView.text =  response.body().toString()
//                }else{
//                    textView.text = response.code().toString()
//                }
//            })
//
//        }
//
//        button.setOnClickListener{
//            val myNumber:String = textNumber.text.toString()
//            viewModel.getCustomPost(Integer.parseInt(myNumber))
//            viewModel.myCustomPost.observe(this, Observer { response ->
//                if (response.isSuccessful){
//                    textView.text =  response.body().toString()
//
//                }else{
//                    textView.text = response.code().toString()
//                }
//            })
//
//        }
//
//    }
//
//
//
//
//}