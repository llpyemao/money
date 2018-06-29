package llp.money

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentManager
import android.support.v7.widget.Toolbar
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.Navigation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar : Toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fragmentManager : FragmentManager = getSupportFragmentManager()
        val navHostFragment : NavHostFragment = fragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        val navController : NavController  = navHostFragment.navController


        val bottomNavigation : BottomNavigationView  = findViewById<View>(R.id.bottom_navigation) as BottomNavigationView
        NavigationUI.setupActionBarWithNavController(this, navController)
        NavigationUI.setupWithNavController(bottomNavigation,navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.my_nav_host_fragment).navigateUp()
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        //你的代码
        super.onConfigurationChanged(newConfig)
    }

}

