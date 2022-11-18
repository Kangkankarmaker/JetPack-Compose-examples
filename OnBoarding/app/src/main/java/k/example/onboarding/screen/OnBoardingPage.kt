package k.example.onboarding.screen

import androidx.annotation.DrawableRes
import k.example.onboarding.R

sealed class OnBoardingPage(
    @DrawableRes
    val image:Int,
    val title:String,
    val description:String,
){
    object First:OnBoardingPage(
        image = R.drawable.ic_launcher_background,
        title = "Meeting",
        description = "MeetingMeetingMeetingMeetingMeetingMeetingMeetingMeetingMeeting"
    )

    object Second:OnBoardingPage(
        image = R.drawable.ic_launcher_background,
        title = "Meeting2",
        description = "2MeetingMeetingMeetingMeetingMeetingMeetingMeetingMeetingMeeting"
    )

    object Third:OnBoardingPage(
        image = R.drawable.ic_launcher_background,
        title = "Meeting3",
        description = "3MeetingMeetingMeetingMeetingMeetingMeetingMeetingMeetingMeeting"
    )
}
