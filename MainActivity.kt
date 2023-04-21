//import android.os.Bundle
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import androidx.databinding.DataBindingUtil
//import androidx.lifecycle.ViewModelProvider
//import androidx.lifecycle.ViewModelProviders
//import com.example.splashscreen.LoginResultCallBacks
//import com.example.splashscreen.LoginViewModel
//import com.example.splashscreen.LoginViewModelFactory
//import com.example.splashscreen.R
//
//class MainActivity : AppCompatActivity(), LoginResultCallBacks {
//    override fun onSuccess(message: String) {
//        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onError(message: String) {
//        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_login)
//
//        val activityMainBinding = DataBindingUtil.setContentView(this,R.layout.fragment_login)
//        activityMainBinding.viewModel = ViewModelProvider(this)
//            .get(LoginViewModel::class.java)
//    }
//}