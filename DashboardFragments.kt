package com.example.splashscreen.fragments


import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.funlibrary.FunActivity

import com.example.splashscreen.LoginActivity
import com.example.splashscreen.R
import com.example.splashscreen.databinding.FragmentDashboardBinding


class DashboardFragments: androidx.fragment.app.Fragment(){
//    private lateinit var home2:TextView
    private var email:String? = ""
//    private lateinit var dashboardFragment1: Button
//    private lateinit var dashboardFragment2: Button
//    private lateinit var logOut:Button
//    private lateinit var cameraButton:Button
//    private lateinit var clickImage: ImageView

    private var CAMERA_PERMISSION_CODE = 101
    private val CAMERA_REQUEST: Int = 1888
    private lateinit var photo: Bitmap
    private var _dashboardFragmentBinding:FragmentDashboardBinding? = null
    val dashboardFragmentBinding  get() = _dashboardFragmentBinding!!


    // Define the pic id
    private val pic_id = 123

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val view = inflater.inflate(R.layout.fragment_dashboard, parent, false)
        _dashboardFragmentBinding = FragmentDashboardBinding.inflate(inflater,parent,false)
//        home2 = view.findViewById(R.id.home2)
        email = arguments?.getString("email")
//        home2.text  = arguments?.getString("email")
//        dashboardFragment1 = view.findViewById(R.id.dashboardFragment1)
//        dashboardFragment2 = view.findViewById(R.id.dashboardFragment2)
//        cameraButton = view.findViewById(R.id.camera_button)
//        clickImage = view.findViewById(R.id.click_image)
        dashboardFragmentBinding.cameraButton.setOnClickListener{
            checkPermission(android.Manifest.permission.CAMERA,
                CAMERA_PERMISSION_CODE)
        }
//        logOut = view.findViewById(R.id.logOut)
        dashboardFragmentBinding.logOut.setOnClickListener{
            val preferences = context?.getSharedPreferences("login", Context.MODE_PRIVATE)
            val  editor = preferences?.edit();
            editor?.remove("token")
            editor?.apply()
            startActivity(Intent(activity, LoginActivity::class.java))
            activity?.finish()
        }


       dashboardFragmentBinding.dashboardFragment1.setOnClickListener {
            dashboardFragment1()
        }
        dashboardFragmentBinding.dashboardFragment2.setOnClickListener {
            dashboardFragment2(data1)
        }
        dashboardFragmentBinding.funLibrary.setOnClickListener{
            Intent(context, FunActivity::class.java).apply {
                startActivity(this)
            }
        }




        // Defines the xml file for the fragment
        return dashboardFragmentBinding.root
    }




    private  fun dashboardFragment1(){
        val fragment  = DashboardFragment1()
//        val bundle = Bundle()
//        bundle.putString("email",email+"\nDashboardFragment1")
//        fragment.arguments = bundle
        // Begin the transaction
        // Begin the transaction
        val ft = activity?.supportFragmentManager?.beginTransaction()
        ft?.replace(R.id.placeholderForDashboardFragment, fragment)
        ft?.commit()
    }

    private  fun dashboardFragment2(data: Intent?){
        val fragment  = DashboardFragment2()
        val bundle = Bundle()
        bundle.putString("displayingImage","$data")
        fragment.arguments = bundle
        // Begin the transaction
        // Begin the transaction
        val ft = activity?.supportFragmentManager?.beginTransaction()
        ft?.replace(R.id.placeholderForDashboardFragment, fragment)
        ft?.addToBackStack("secondFragment")

        ft?.commit()
    }

    //Function to check and request permission
    private fun checkPermission(permission: String, requestCode: Int){
        if (context?.let { ContextCompat.checkSelfPermission(it, permission) } == PackageManager.PERMISSION_DENIED){

            //Requesting the permission
            requestPermissions( arrayOf(permission), requestCode)

//            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            startActivityForResult(intent, picId)
        }else{
            Toast.makeText(activity, "permission already granted", Toast.LENGTH_SHORT).show()
            // Create the camera_intent ACTION_IMAGE_CAPTURE
            // it will open the camera for capture the image
            val camera_intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            // Start the activity with camera_intent,
            // and request pic id
            startActivityForResult(camera_intent, pic_id);

        }
    }
    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE){
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(activity, "camera Permission Granted", Toast.LENGTH_SHORT ).show()
                // it will open the camera for capture the image
                val camera_intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

                // Start the activity with camera_intent,
                // and request pic id
                startActivityForResult(camera_intent, pic_id);

            }else{
                Toast.makeText(activity, "camera Permission Granted", Toast.LENGTH_SHORT ).show()
            }
        }
    }


    // this method will help to retrive the image
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode:Int, resultCode:Int, data:Intent?) {
        // Match the request 'picId' with requestCode
        if (requestCode == DashboardFragment2.picId && resultCode == Activity.RESULT_OK){
//            //BitMap is dataStructure of Image file which store the image in memory
//            val photo: Bitmap = data?.extras?.get("data") as Bitmap
//            //set the image in imageView for display
//            clickImageId.setImageBitmap(photo)

            data1 = data
            photo = (data?.extras!!["data"] as Bitmap?)!!
            dashboardFragmentBinding.clickImage.setImageBitmap(photo)


            Log.d("displaying Image", "$photo")
        }
    }
    fun sum(a: Int, b: Int): Int {
        return a+b

    }
    fun swap(array:Array<Int?>, low:Int, high:Int){
        var temp = array[low]
        array[low] = array[high]
        array[high]= temp
    }

    fun reverseAnArray1(array: Array<Int?>): String {
        var low = 0
        var high = array.size -1
        while (low < high){
            swap(array,low,high)
            low++
            high--
        }
        return array.contentToString()

    }
     companion object{


         public  var data1: Intent? = null

     }





}