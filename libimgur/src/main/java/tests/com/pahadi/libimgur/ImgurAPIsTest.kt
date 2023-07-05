package tests.com.pahadi.libimgur

import com.pahadi.libimgur.ImgurClient
import com.pahadi.libimgur.params.Section
import org.junit.Test
import org.junit.Assert.assertNotNull

class ImgurAPIsTest {
    val api = ImgurClient.api
/*
* getting ERROR: com.android.tools.r8.internal.sd: Space characters in SimpleName 'get gallery-hot working' are not allowed prior to DEX version 040
*
* The error states that space characters in the test case name 'get gallery-hot working' are not allowed prior to DEX version 040.
* In Kotlin, test case names are usually enclosed within backticks (`) to allow for special characters and spaces. However, it seems that the space character is causing an issue in this case.
* To resolve this error, you can modify the test case name to remove the space character
*
* */
@Test
fun `get_tags_working`(){
    val response = api.getTags().execute()
    assertNotNull(response.body())
}

    @Test
    fun `get_gallery_hot_working`(){
    val response = api.getGallery(Section.HOT).execute()
    assertNotNull(response.body())
}
    @Test
   fun `get_gallery_top_working`(){
    val response = api.getGallery(Section.TOP).execute()
    assertNotNull(response.body())
}



}