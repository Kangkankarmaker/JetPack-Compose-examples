package k.example.navigationcomponent.navigation

const val DETAILS_ARGUMENT_KEY="id"
const val DETAILS_ARGUMENT_KEY2="name"

const val ROOT_ROUTE="root"
const val HOME_ROUTE="home"
const val AUTHENTICATION_ROUTE="authentication"

sealed class Screen(val route:String){
    object Home:Screen(route = "home_screen")

    //example of required argument
   /* object Detail:Screen(route = "detail_screen/{$DETAILS_ARGUMENT_KEY}/{$DETAILS_ARGUMENT_KEY2}"){
        *//*fun passID(id:Int):String{
            return this.route.replace(oldValue = "{$DETAILS_ARGUMENT_KEY}", newValue = id.toString())
        }*//*
        fun passNameAndID(
            id:Int,
            name:String
        ):String{
            return "detail_screen/$id/$name"
        }
    }*/

    //example of optional argument
    object Detail:Screen(route = "detail_screen?id={id}&name={name}"){
        fun passID(id:Int=0): String {
            return "detail_screen?id=$id"
        }
        fun passNameAndID(
            id:Int=0,
            name:String="kangkan"
        ):String{
            return "detail_screen?=$id/&name=$name"
        }
    }


    ////////////////////////
    object SignUp:Screen(route = "signup_screen")
    object LogIn:Screen(route = "login_screen")
}
