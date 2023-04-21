package com.example.splashscreen.fragments

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.splashscreen.R
import com.example.splashscreen.databinding.ImageFragmentBinding
import com.example.splashscreen.databinding.TextInputLayoutBinding
import java.io.File
import java.lang.String


class ImageFragment : Fragment() {
//    private lateinit var imageView: ImageView
    private  var _imageFragmentBinding: ImageFragmentBinding? = null
    private val imageFragmentBinding get() = _imageFragmentBinding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val view = inflater.inflate(R.layout.image_fragment, parent, false)
        _imageFragmentBinding = ImageFragmentBinding.inflate(inflater, parent,false)


        val imgPath = arguments?.getString("image1")
        val bitmap = BitmapFactory.decodeFile(File(imgPath).toString())
       imageFragmentBinding.imageView2.setImageBitmap(bitmap)
        return  imageFragmentBinding.root
    }


}
