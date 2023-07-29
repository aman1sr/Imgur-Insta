package tests.com.pahadi.libimgur

import com.pahadi.libimgur.ImgurClient
import com.pahadi.libimgur.params.Section
import kotlinx.coroutines.runBlocking
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

    // detailed Stories
    @Test
    fun `get_tag_detailed_stories`() = runBlocking {
        val response = api.getTagGallery("aww")
        assertNotNull(response.body())
    }

    // HOME stories
@Test
fun `get_tags_working`()= runBlocking {
    val response = api.getTags()
    assertNotNull(response.body())
}


    // below 2 APIs for Bottom Tab
    @Test
    fun `get_gallery_hot_working`()= runBlocking {
        val response = api.getGallery(Section.HOT)
        assertNotNull(response.body())
    }
    @Test
   fun `get_gallery_top_working`() = runBlocking {
        val response = api.getGallery(Section.TOP)
        assertNotNull(response.body())
    }



}