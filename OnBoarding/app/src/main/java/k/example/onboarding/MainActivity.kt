package k.example.onboarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.datastore.preferences.protobuf.ExperimentalApi
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint
import k.example.onboarding.navigation.SetUpNavGraph
import k.example.onboarding.ui.theme.OnBoardingTheme
import k.example.onboarding.viewModel.SplashViewModel
import javax.inject.Inject

@ExperimentalAnimationApi
@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().setKeepOnScreenCondition{
            !splashViewModel.isLoading.value
        }


        setContent {
            OnBoardingTheme {
                val screen by splashViewModel.startDestination
                val navController= rememberNavController()
                SetUpNavGraph(navController=navController, startDestination = screen)
            }
        }
    }
}

