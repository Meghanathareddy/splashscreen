package com.example.splashscreen.fragments

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
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
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import com.example.splashscreen.R
import com.example.splashscreen.databinding.DashboardfragmentTwoBinding
import com.example.splashscreen.fragments.DashboardFragments.Companion.data1
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


@Suppress("DEPRECATION")
class DashboardFragment2: Fragment() {
    private val CAMERA_REQUEST: Int = 1888
//    private lateinit var home2: TextView
//    private lateinit var imageDisplay:Button
//    private lateinit var clickImage:ImageView
    private var CAMERA_PERMISSION_CODE = 101
    private  var _dashBoardFragment2:DashboardfragmentTwoBinding? = null
    val dashBoardFragment2 get() = _dashBoardFragment2!!

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _dashBoardFragment2 = DashboardfragmentTwoBinding.inflate(inflater,parent,false)


//        val view = inflater.inflate(R.layout.dashboardfragment_two, parent, false)
//        home2 = view.findViewById(R.id.home2)
       dashBoardFragment2.home2.text  = arguments?.getString("email")
        dashBoardFragment2.home2.text = "email"
//        imageDisplay = view.findViewById(R.id.imageDisplay)
//        clickImage = view.findViewById(R.id.click_image2)
        dashBoardFragment2.imageDisplay.setOnClickListener{
//            checkPermission(android.Manifest.permission.CAMERA,
//                CAMERA_PERMISSION_CODE)
//           val data=  arguments?.getString("displayingImage")  as Intent?
            val photo = (data1?.extras!!["data"] as Bitmap?)!!
            dashBoardFragment2.clickImage2.setImageBitmap(photo)
        }



        // Defines the xml file for the fragment
        return dashBoardFragment2.root
    }



//
//    private fun addImageFragment(file1Path: String?) {
//        val fragment  = ImageFragment()
//        val bundle = Bundle()
//        bundle.putString("image1", file1Path)
//        fragment.arguments = bundle
//        // Begin the transaction
//        // Begin the transaction
//        val ft = activity?.supportFragmentManager?.beginTransaction()
//        ft?.replace(R.id.placeholderForDashboardFragment, fragment)
//        ft?.addToBackStack(null)
//        ft?.commit()
//    }



//
//    private fun dispatchTakePictureIntent(){
//        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
//            //create the File whre the photo should go
//                   val photoUri= getPhotoUri()
//                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
//                    startActivityForResult(takePictureIntent, CAMERA_REQUEST)
//        }
//    }

//    private fun getPhotoUri(): Uri? {
//        val photoFile:File? = try {
//            createImageFile()
//        }catch (ex:IOException){
//            //Error  occured while creating the file
//            Log.d("TAG","$ex")
//            null
//        }
//        //continue only if the File was successfully created
//        lateinit var photoUri:Uri
//        photoFile?.also {
//            photoUri = context?.let { it1 ->
//                FileProvider.getUriForFile(it1,
//                    "com.example.android.fileProvider",
//                    it
//                )
//            }!!
//        }
//        return photoUri


//}
//    //Function to check and request permission
//    private fun checkPermission(permission: String, requestCode: Int){
//        if (context?.let { ContextCompat.checkSelfPermission(it, permission) } == PackageManager.PERMISSION_DENIED){
//
//            //Requesting the permission
//            requestPermissions( arrayOf(permission), requestCode)
//
////            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
////            startActivityForResult(intent, picId)
//        }else{
//            Toast.makeText(activity, "permission already granted", Toast.LENGTH_SHORT).show()
////            val cameraIntent= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
////            val imageFile = createImageFile()
////            //The Name of the Intent-extra used to indicate a content-resolver Uri to be used to store the requested image or video
////            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imageFile))
////            startActivityForResult(cameraIntent, CAMERA_REQUEST)
//            dispatchTakePictureIntent()
//
//        }
//    }
//
//
//    lateinit var currentPhotoPath: String
//
//    @Throws(IOException::class)
//    private fun createImageFile(): File {
//        // Create an image file name
//        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
//        val storageDir: File? = context?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
//        return File.createTempFile(
//            "JPEG_${timeStamp}_", /* prefix */
//        ".jpg", /* suffix */
//        storageDir  /*directory*/
//        ).apply {
//            //save a file: path for use with ACTION_VIEW intents
//            currentPhotoPath = absolutePath
//        }
//    }
//
//
//
//    @Deprecated("Deprecated in Java")
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == CAMERA_PERMISSION_CODE){
//            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                Toast.makeText(activity, "camera Permission Granted", Toast.LENGTH_SHORT ).show()
////                val cameraIntent= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
////                val imageFile = createImageFile()
////                //The Name of the Intent-extra used to indicate a content-resolver Uri to be used to store the requested image or video
////                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imageFile))
////                startActivityForResult(cameraIntent, CAMERA_REQUEST)
//                dispatchTakePictureIntent()
//
//            }else{
//                Toast.makeText(activity, "camera Permission Granted", Toast.LENGTH_SHORT ).show()
//            }
//        }
//    }
//
//
//        // this method will help to retrive the image
//    @Deprecated("Deprecated in Java")
//    override fun onActivityResult(requestCode:Int, resultCode:Int, data:Intent?) {
//        // Match the request 'picId' with requestCode
//        if (requestCode == picId && resultCode == Activity.RESULT_OK){
////            //BitMap is dataStructure of Image file which store the image in memory
////            val photo: Bitmap = data?.extras?.get("data") as Bitmap
////            //set the image in imageView for display
////            clickImageId.setImageBitmap(photo)
//            val photo = data?.extras!!["data"] as Bitmap?
//            clickImage.setImageBitmap(photo)
//        }
//    }
//
//    // this method will help to retrive the image
////    @Deprecated("Deprecated in Java")
////    override fun onActivityResult(requestCode:Int, resultCode:Int, data:Intent?) {
////        // Match the request 'picId' with requestCode
////        if (requestCode == picId){
////            val imageUri = Uri.parse(data?.dataString)
////            val file1Path = imageUri.path
////
////            //set the image in imageView for display
////            home2.text = file1Path
////
////            addImageFragment(file1Path)
////
////
//////            findNavController().navigate(R.id.your_destination_fragment, bundle)
////        }
////    }

    companion object{
        var picId = 123
    }





}