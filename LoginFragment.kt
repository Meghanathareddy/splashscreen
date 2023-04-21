package com.example.splashscreen.fragments

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.splashscreen.*
import com.example.splashscreen.databinding.ActivityMainBinding
import com.example.splashscreen.databinding.TextInputLayoutBinding
import com.google.android.material.textfield.TextInputEditText
import java.util.*


class LoginFragment:Fragment(){
//    private lateinit var password: TextInputEditText
//    private lateinit var email:TextInputEditText
//    private lateinit var button:Button
//    private lateinit var textMessage: TextView
    private lateinit var dialog: LoadingDialog

    //    private var emailLiveData = MutableLiveData<String>()
    private lateinit var viewModel:LoginViewModel
    private  var binding: TextInputLayoutBinding? = null
//    val binding get() = _binding!!
    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.


    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = TextInputLayoutBinding.inflate(inflater,parent, false)

//        val view = inflater.inflate(R.layout.text_input_layout, parent, false)
//        email = view.findViewById(R.id.userId1)
//        password = view.findViewById(R.id.password1)
//        button = view.findViewById(R.id.loginBtn)
//        textMessage = view.findViewById(R.id.tvMessage)
        dialog = activity?.let { LoadingDialog(it) }!!
//        val spannable = SpannableStringBuilder("For more info, view Our Privacy Policy")

//        val clickableSpan = object: ClickableSpan(){
//            override fun onClick(view: View) {
//             Toast.makeText(activity, "privacy Policy clicked!", Toast.LENGTH_SHORT).show()
//            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
//            startActivity(intent)
//            }
//        }
        val ss = SpannableString("For more info, view Our Privacy Policy")
        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(textView: View) {
                Toast.makeText(activity, "privacy Policy clicked!", Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
            startActivity(intent)
            }

            override fun updateDrawState(ds: TextPaint) {

                ds.linkColor = Color.BLACK
                super.updateDrawState(ds)

            }
        }
        ss.setSpan(clickableSpan, 24, ss.length, Spanned.SPAN_EXCLUSIVE_INCLUSIVE)


        binding!!.tvMessage.text = ss
        binding!!.tvMessage.movementMethod = LinkMovementMethod.getInstance()
        binding!!.tvMessage.highlightColor = Color.TRANSPARENT

//        spannable.setSpan(
//            UnderlineSpan(),
//            24,
//            spannable.length,
//            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
//        )
//        spannable.setSpan(
//            clickableSpan,
//            24,
//            spannable.length,
//            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
//        )
//
//        spannable.setSpan(
//            ForegroundColorSpan(Color.RED),
//            24,
//            spannable.length,
//            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
//        )
//        textMessage.setOnClickListener {
//            Toast.makeText(activity, "privacy Policy clicked!", Toast.LENGTH_SHORT).show()
//            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
//            startActivity(intent)
//        }

//        textMessage.setText(spannable, TextView.BufferType.SPANNABLE)




        binding!!.loginBtn.setOnClickListener {
            viewModel.confirmInput(binding!!.userId1.text.toString(), binding!!.password1.text.toString())

        }
        // Defines the xml file for the fragment
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewModel.emailLiveData.observe(viewLifecycleOwner) {
            binding?.userId1?.error = it
        }

        viewModel.passwordLiveData.observe(viewLifecycleOwner) {
            binding?.password1?.error = it
        }

        viewModel.loginLiveData.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()){
                saveToken(it)
                navigationToDashboard()
            }else{
                Toast.makeText(activity, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.fullScreenLoader.observe(viewLifecycleOwner){
                if(it){
                    Log.d("startLoading","startloading")
                    dialog.startLoadingDialog()
                }else{

                        Log.d("startLoading","dismissloading")
                        dialog.dismissDialog()
                }
        }


    }

    private fun saveToken(token:String){
        val sh: SharedPreferences = context?.getSharedPreferences("login", MODE_PRIVATE) !!
        val  sharedPreferences = sh.edit()
        sharedPreferences.putString("token", token)
        sharedPreferences.apply()
    }




    //Fetch the stored data in onResume()
    //Because this is what will be called
    //when the app opens again

//    override fun onResume() {
//        super.onResume()
//
//        //Fetching the stored data
//        //from shared preferences
//        val sh: SharedPreferences = context?.getSharedPreferences("MySharedPref", MODE_PRIVATE) !!
//
//        val s1 = sh.getString("email", "")
//        val a = sh.getString("password", "")
//
//        // Setting the fetched data
//        // in the EditTexts
//
//        // Setting the fetched data
//        // in the EditTexts
//        email.setText(s1)
//        password.setText(a)
//    }
//
//    //store the data in the sharedPreferences
//    //in the onPause() method
//    //When the user closes the application
//    //onPause() will be called
//    //and data will be stored
//    override fun onPause(){
//        super.onPause()
//        // Creating a shared pref object
//        // with a file name "MySharedPref"
//        // in private mode
//        // Creating a shared pref object
//        // with a file name "MySharedPref"
//        // in private mode
//        val sharedPreferences: SharedPreferences =
//            context?.getSharedPreferences("MySharedPref", MODE_PRIVATE) !!
//        val myEdit = sharedPreferences.edit()
//
//        // write all the data entered by the user in SharedPreference and apply
//
//        // write all the data entered by the user in SharedPreference and apply
//        myEdit.putString("email", email.getText().toString())
//        myEdit.putInt("password", password.getText().toString().toInt())
//        myEdit.apply()
//
//
//    }

    private fun navigationToDashboard(){
        val intent = Intent(activity, DashBoardActivity::class.java)
        val bundle= Bundle()
        bundle.putString(BUNDLE_KEY_NAME, binding?.userId1?.text.toString())
        intent.putExtras(bundle)
        startActivity(intent)
    }



    companion object{
        var BUNDLE_KEY_NAME:String = "email"
    }


}




//    private fun validateEmail():Boolean{
//        /*
//        It validate email entered in the input
//         */
//
//        //Extract input from EditText
//        var emailInput:String = email.text.toString().trim()
//
//        //if the email input field is empty
//        if (emailInput.isEmpty()){
//            email.error = "Field can not be empty"
//            return false
//        }
//        //Matching the input email to a predefined email Pattern
//        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
//            email.error = "Please enter a valid email Address"
//            return false
//        }else{
//            email.error = null
//            return true
//        }
//    }
//    private fun validatePassword():Boolean{
//        /*
//        It validate password entered in the input
//         */
//
//        //Extract input from EditText
//        var passwordInput:String = password.text.toString().trim()
//
//        //if the email input field is empty
//        if (passwordInput.isEmpty()){
//            password.error = "Field can not be empty"
//            return false
//        }
//        //Matching the input email to a predefined email Pattern
//        else if (! (PASSWORD_PATTERN.matcher(passwordInput).matches())){
//            password.error = "Password is too weak"
//            return false
//        }else{
//            email.error = null
//            return true
//        }
//    }

//    fun confirmInput(){
//        /*
//        It validate email entered in the input
//         */
//
//        if (!validateEmail() or !validatePassword()){
//            return
//        }
//        //if the email and password matches, a toast message
//        // with email and password is displayed
//        var input:String = "Email:"+email.text.toString()
//        input += "\n"
//        input += "Password:"+password.text.toString()
//        Toast.makeText(activity,input, Toast.LENGTH_SHORT).show()
//        navigationToDashboard()



//    private fun navigationToDashboard(){
//        val intent = Intent(activity, DashBoardActivity::class.java)
//        val bundle= Bundle()
//        bundle.putString(BUNDLE_KEY_NAME,"${email.text}")
//        intent.putExtras(bundle)
//        startActivity(intent)
//    }

//    /*
//public static final Pattern Email_ADDRESS
//            =Pattern.compile(
//            "[a-zA-z0-9\\+\\.\\_\\%\\+]{1,256}"+
//            "\\@"+
//            "[a-zA-z0-9][a-zA-Z0-9\\-]{0,64}"+
//            "(" +
//            "\\." +
//            "[a-zA-z0-9][a-zA-Z0-9\\-]{0,25}"+
//            ")+"
//            )
// */


//}